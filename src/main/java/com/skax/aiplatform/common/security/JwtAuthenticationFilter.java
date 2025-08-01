package com.skax.aiplatform.common.security;

import com.skax.aiplatform.common.util.TraceUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JWT 인증 필터
 * 
 * <p>HTTP 요청에서 JWT 토큰을 추출하고 검증하여 
 * Spring Security 컨텍스트에 인증 정보를 설정합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException {

        // JWT 토큰 추출
        String jwt = extractJwtFromRequest(request);
        
        if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
            try {
                // 토큰에서 사용자 정보 추출
                String username = jwtTokenProvider.getUsernameFromToken(jwt);
                String authorities = jwtTokenProvider.getAuthoritiesFromToken(jwt);
                
                // 사용자 정보를 MDC에 설정
                TraceUtils.setUserId(username);
                
                // 권한 정보 파싱
                List<SimpleGrantedAuthority> grantedAuthorities = parseAuthorities(authorities);
                
                // UserDetails 객체 생성
                UserDetails userDetails = User.builder()
                        .username(username)
                        .password("") // JWT 토큰 기반 인증에서는 비밀번호 불필요
                        .authorities(grantedAuthorities)
                        .build();
                
                // Authentication 객체 생성
                UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(userDetails, null, grantedAuthorities);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // Security Context에 인증 정보 설정
                SecurityContextHolder.getContext().setAuthentication(authentication);
                
                log.debug("JWT 토큰으로 사용자 인증 완료: username={}, authorities={}", username, authorities);
                
            } catch (Exception e) {
                log.error("JWT 토큰 처리 중 오류 발생", e);
                SecurityContextHolder.clearContext();
            }
        }
        
        filterChain.doFilter(request, response);
    }

    /**
     * HTTP 요청에서 JWT 토큰 추출
     * 
     * @param request HTTP 요청
     * @return JWT 토큰 (Bearer 접두사 제거)
     */
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX.length());
        }
        
        return null;
    }

    /**
     * 권한 문자열을 SimpleGrantedAuthority 리스트로 변환
     * 
     * @param authorities 권한 문자열 (예: "[ROLE_USER, ROLE_ADMIN]")
     * @return SimpleGrantedAuthority 리스트
     */
    private List<SimpleGrantedAuthority> parseAuthorities(String authorities) {
        if (!StringUtils.hasText(authorities)) {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        
        // "[ROLE_USER, ROLE_ADMIN]" -> "ROLE_USER, ROLE_ADMIN"
        String cleanAuthorities = authorities.replaceAll("[\\[\\]]", "");
        
        return Arrays.stream(cleanAuthorities.split(","))
                .map(String::trim)
                .filter(StringUtils::hasText)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /**
     * 특정 경로에 대해 필터를 건너뛸지 결정
     * 
     * @param request HTTP 요청
     * @return 필터 건너뛰기 여부
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        
        // 인증이 필요 없는 경로들
        return path.startsWith("/api/v1/auth/") ||
               path.startsWith("/health") ||
               path.startsWith("/actuator") ||
               path.startsWith("/swagger-ui") ||
               path.startsWith("/v3/api-docs") ||
               path.startsWith("/favicon.ico");
    }
}
