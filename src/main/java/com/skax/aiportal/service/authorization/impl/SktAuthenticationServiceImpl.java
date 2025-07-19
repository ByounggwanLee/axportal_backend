package com.skax.aiportal.service.authorization.impl;

import com.skax.aiportal.client.sktai.authorization.SktAiAuthenticationClient;
import com.skax.aiportal.client.sktai.authorization.SktAiUserManagementClient;
import com.skax.aiportal.client.sktai.authorization.dto.request.OAuth2LoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.SystemLoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenWithProjectResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.MeResponse;
import com.skax.aiportal.dto.authorization.request.AuthLoginRequest;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginRequest;
import com.skax.aiportal.dto.authorization.response.AuthTokenResponse;
import com.skax.aiportal.dto.authorization.response.AuthTokenWithProjectResponse;
import com.skax.aiportal.service.authorization.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * SKT AI 인증 서비스 구현 클래스
 * 
 * <p>SKT AI 플랫폼의 인증 관련 비즈니스 로직을 구현합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */ 
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAuthenticationServiceImpl implements AuthenticationService {

    private final SktAiAuthenticationClient authenticationClient;
    private final SktAiUserManagementClient userManagementClient;

    @Override
    public AuthTokenWithProjectResponse login(AuthLoginRequest request) {
        log.info("OAuth2 로그인 시도: 사용자={}", request.getUsername());
        
        try {
            // SKT AI 클라이언트용 요청 객체로 변환
            OAuth2LoginRequest clientRequest = OAuth2LoginRequest.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .clientId("default") // 기본 클라이언트 ID 사용
                    .grantType("password")
                    .build();

            // SKT AI 인증 API 호출
            AccessTokenWithProjectResponse clientResponse = authenticationClient.login(clientRequest);
            
            // 응답 객체 변환
            AuthTokenWithProjectResponse response = convertToAuthTokenWithProjectResponse(clientResponse);
            
            log.info("OAuth2 로그인 성공: 사용자={}", request.getUsername());
            return response;
            
        } catch (Exception e) {
            log.error("OAuth2 로그인 실패: 사용자={}, 오류={}", request.getUsername(), e.getMessage(), e);
            throw new RuntimeException("로그인에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AuthTokenResponse systemLogin(String clientSecret, String clientName, AuthSystemLoginRequest request) {
        log.info("시스템 로그인 시도: 사용자={}, 클라이언트={}", request.getUsername(), clientName);
        
        try {
            // SKT AI 클라이언트용 요청 객체로 변환
            SystemLoginRequest clientRequest = SystemLoginRequest.builder()
                    .username(request.getUsername())
                    // .email(request.getEmail())
                    // .firstName(request.getFirstName())
                    // .lastName(request.getLastName())
                    // .enabled(request.getEnabled())
                    // .emailVerified(request.getEmailVerified())
                    .build();

            // SKT AI 시스템 로그인 API 호출
            AccessTokenResponse clientResponse = authenticationClient.systemLogin(
                    clientSecret, clientName, clientRequest);
            
            // 응답 객체 변환
            AuthTokenResponse response = convertToAuthTokenResponse(clientResponse);
            
            log.info("시스템 로그인 성공: 사용자={}", request.getUsername());
            return response;
            
        } catch (Exception e) {
            log.error("시스템 로그인 실패: 사용자={}, 오류={}", request.getUsername(), e.getMessage(), e);
            throw new RuntimeException("시스템 로그인에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object ssoLogin() {
        log.info("SSO 로그인 요청");
        
        try {
            Object response = authenticationClient.ssoLogin();
            log.info("SSO 로그인 처리 완료");
            return response;
            
        } catch (Exception e) {
            log.error("SSO 로그인 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("SSO 로그인에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object ssoCallback() {
        log.info("SSO 콜백 처리 요청");
        
        try {
            Object response = authenticationClient.ssoCallback();
            log.info("SSO 콜백 처리 완료");
            return response;
            
        } catch (Exception e) {
            log.error("SSO 콜백 처리 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("SSO 콜백 처리에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object getSamlMetadata() {
        log.info("SAML 메타데이터 조회 요청");
        
        try {
            Object response = authenticationClient.getSamlMetadata();
            log.info("SAML 메타데이터 조회 완료");
            return response;
            
        } catch (Exception e) {
            log.error("SAML 메타데이터 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("SAML 메타데이터 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public String getSamlLoginForm() {
        log.info("SAML 로그인 폼 조회 요청");
        
        try {
            String response = authenticationClient.getSamlLoginForm();
            log.info("SAML 로그인 폼 조회 완료");
            return response;
            
        } catch (Exception e) {
            log.error("SAML 로그인 폼 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("SAML 로그인 폼 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object logout(String username) {
        log.info("로그아웃 요청: 사용자={}", username);
        
        try {
            Object response = authenticationClient.logout(username);
            log.info("로그아웃 완료: 사용자={}", username);
            return response;
            
        } catch (Exception e) {
            log.error("로그아웃 실패: 사용자={}, 오류={}", username, e.getMessage(), e);
            throw new RuntimeException("로그아웃에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AuthTokenWithProjectResponse refreshToken(String refreshToken) {
        log.info("토큰 갱신 요청");
        
        try {
            AccessTokenWithProjectResponse clientResponse = authenticationClient.refreshToken(refreshToken);
            AuthTokenWithProjectResponse response = convertToAuthTokenWithProjectResponse(clientResponse);
            
            log.info("토큰 갱신 완료");
            return response;
            
        } catch (Exception e) {
            log.error("토큰 갱신 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("토큰 갱신에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AuthTokenWithProjectResponse exchangeToken(String toExchangeClientName) {
        log.info("토큰 교환 요청: 클라이언트={}", toExchangeClientName);
        
        try {
            AccessTokenWithProjectResponse clientResponse = 
                    authenticationClient.exchangeToken(toExchangeClientName);
            AuthTokenWithProjectResponse response = convertToAuthTokenWithProjectResponse(clientResponse);
            
            log.info("토큰 교환 완료: 클라이언트={}", toExchangeClientName);
            return response;
            
        } catch (Exception e) {
            log.error("토큰 교환 실패: 클라이언트={}, 오류={}", toExchangeClientName, e.getMessage(), e);
            throw new RuntimeException("토큰 교환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean validateToken(String accessToken) {
        log.info("토큰 유효성 검증 요청");
        
        try {
            // 현재 사용자 정보를 조회하여 토큰 유효성 간접 확인
            getCurrentUser();
            log.info("토큰 유효성 검증 성공");
            return true;
            
        } catch (Exception e) {
            log.warn("토큰 유효성 검증 실패: 오류={}", e.getMessage());
            return false;
        }
    }

    @Override
    public Object getCurrentUser() {
        log.info("현재 사용자 정보 조회 요청");
        
        try {
            MeResponse response = userManagementClient.getMyInfo();
            log.info("현재 사용자 정보 조회 완료: 사용자={}", response.getUsername());
            return response;
            
        } catch (Exception e) {
            log.error("현재 사용자 정보 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("사용자 정보 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    /**
     * SKT AI 클라이언트 응답을 서비스 응답으로 변환
     */
    private AuthTokenResponse convertToAuthTokenResponse(AccessTokenResponse clientResponse) {
        return AuthTokenResponse.builder()
                .accessToken(clientResponse.getAccessToken())
                .refreshToken(clientResponse.getRefreshToken())
                .tokenType(clientResponse.getTokenType())
                .expiresIn(clientResponse.getExpiresIn() != null ? clientResponse.getExpiresIn().longValue() : null)
                .scope(null)
                .build();
    }

    /**
     * SKT AI 클라이언트 응답을 서비스 응답으로 변환
     */
    private AuthTokenWithProjectResponse convertToAuthTokenWithProjectResponse(
            AccessTokenWithProjectResponse clientResponse) {
        return AuthTokenWithProjectResponse.builder()
                .accessToken(clientResponse.getAccessToken())
                .refreshToken(clientResponse.getRefreshToken())
                .tokenType(clientResponse.getTokenType())
                .expiresIn(clientResponse.getExpiresIn() != null ? clientResponse.getExpiresIn().longValue() : null)
                // .scope(clientResponse.getScope())
                // 추가적인 변환 로직은 필요에 따라 구현 
                .build();
    }
}