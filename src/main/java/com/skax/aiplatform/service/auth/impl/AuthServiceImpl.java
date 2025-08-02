package com.skax.aiplatform.service.auth.impl;

import com.skax.aiplatform.common.security.JwtTokenProvider;
import com.skax.aiplatform.dto.auth.request.LoginReq;
import com.skax.aiplatform.dto.auth.request.RefreshTokenReq;
import com.skax.aiplatform.dto.auth.response.JwtTokenRes;
import com.skax.aiplatform.dto.auth.response.UserInfoRes;
import com.skax.aiplatform.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 인증 서비스 구현체
 * 
 * <p>사용자 로그인, 토큰 발급, 토큰 갱신 등의 인증 관련 비즈니스 로직을 처리합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    // 테스트용 사용자 데이터 (실제로는 데이터베이스에서 조회)
    private Map<String, String> testUsers;
    private final Map<String, List<String>> userAuthorities = initUserAuthorities();

    @PostConstruct
    private void initTestData() {
        testUsers = new HashMap<>();
        testUsers.put("admin", passwordEncoder.encode("admin123"));
        testUsers.put("user", passwordEncoder.encode("user123"));
        testUsers.put("test", passwordEncoder.encode("test123"));
    }

    /**
     * 테스트용 사용자 권한 데이터 초기화
     */
    private Map<String, List<String>> initUserAuthorities() {
        return Map.of(
                "admin", List.of("ROLE_ADMIN", "ROLE_USER"),
                "user", List.of("ROLE_USER"),
                "test", List.of("ROLE_USER")
        );
    }

    /**
     * 사용자 로그인
     * 
     * @param loginReq 로그인 요청
     * @return JWT 토큰 응답
     */
    @Override
    public JwtTokenRes login(LoginReq loginReq) {
        log.info("사용자 로그인 시도: {}", loginReq.getUsername());

        // 사용자 인증 (실제로는 UserDetailsService 사용)
        if (!authenticateUser(loginReq.getUsername(), loginReq.getPassword())) {
            log.warn("로그인 실패 - 잘못된 인증 정보: {}", loginReq.getUsername());
            throw new BadCredentialsException("사용자명 또는 비밀번호가 올바르지 않습니다");
        }

        // 권한 정보 조회
        List<String> authorities = userAuthorities.getOrDefault(loginReq.getUsername(), List.of("ROLE_USER"));
        String authoritiesStr = String.join(", ", authorities);

        // 토큰 생성
        String accessToken = jwtTokenProvider.createAccessToken(loginReq.getUsername(), authoritiesStr);
        String refreshToken = jwtTokenProvider.createRefreshToken(loginReq.getUsername());

        log.info("사용자 로그인 성공: {}, 권한: {}", loginReq.getUsername(), authoritiesStr);

        return JwtTokenRes.of(
                accessToken, 
                refreshToken, 
                jwtTokenProvider.getAccessTokenValidityInMilliseconds()
        );
    }

    /**
     * Access Token 갱신
     * 
     * @param refreshTokenReq 토큰 갱신 요청
     * @return 새로운 JWT 토큰 응답
     */
    @Override
    public JwtTokenRes refreshToken(RefreshTokenReq refreshTokenReq) {
        log.info("토큰 갱신 요청");

        try {
            // 새로운 Access Token 생성
            String newAccessToken = jwtTokenProvider.refreshAccessToken(refreshTokenReq.getRefreshToken());
            
            // 기존 Refresh Token의 사용자명 추출
            String username = jwtTokenProvider.getUsernameFromToken(refreshTokenReq.getRefreshToken());
            
            log.info("토큰 갱신 성공: {}", username);

            return JwtTokenRes.of(
                    newAccessToken, 
                    refreshTokenReq.getRefreshToken(), // 기존 Refresh Token 재사용
                    jwtTokenProvider.getAccessTokenValidityInMilliseconds()
            );

        } catch (Exception e) {
            log.error("토큰 갱신 실패: {}", e.getMessage());
            throw new BadCredentialsException("유효하지 않은 Refresh Token입니다");
        }
    }

    /**
     * 현재 인증된 사용자 정보 조회
     * 
     * @return 사용자 정보 응답
     */
    @Override
    public UserInfoRes getCurrentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("인증되지 않은 사용자입니다");
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        
        List<String> authorities = userDetails.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .toList();

        log.info("현재 사용자 정보 조회: {}, 권한: {}", username, authorities);

        return UserInfoRes.builder()
                .username(username)
                .authorities(authorities)
                .userId(getUserId(username))
                .email(getEmail(username))
                .name(getName(username))
                .build();
    }

    /**
     * 로그아웃 (토큰 무효화)
     * 
     * @param accessToken Access Token
     */
    @Override
    public void logout(String accessToken) {
        // 실제로는 토큰을 블랙리스트에 추가하거나 Redis에서 제거
        String username = jwtTokenProvider.getUsernameFromToken(accessToken);
        log.info("사용자 로그아웃: {}", username);
        
        // TODO: 토큰 블랙리스트 처리 구현
    }

    /**
     * 사용자 인증 (테스트용)
     * 
     * @param username 사용자명
     * @param password 비밀번호
     * @return 인증 성공 여부
     */
    private boolean authenticateUser(String username, String password) {
        String encodedPassword = testUsers.get(username);
        return encodedPassword != null && passwordEncoder.matches(password, encodedPassword);
    }

    /**
     * 사용자 ID 조회 (테스트용)
     * 
     * @param username 사용자명
     * @return 사용자 ID
     */
    private Long getUserId(String username) {
        return switch (username) {
            case "admin" -> 1L;
            case "user" -> 2L;
            case "test" -> 3L;
            default -> 999L;
        };
    }

    /**
     * 사용자 이메일 조회 (테스트용)
     * 
     * @param username 사용자명
     * @return 사용자 이메일
     */
    private String getEmail(String username) {
        return username + "@example.com";
    }

    /**
     * 사용자 이름 조회 (테스트용)
     * 
     * @param username 사용자명
     * @return 사용자 이름
     */
    private String getName(String username) {
        return switch (username) {
            case "admin" -> "관리자";
            case "user" -> "일반사용자";
            case "test" -> "테스트사용자";
            default -> "사용자";
        };
    }
}
