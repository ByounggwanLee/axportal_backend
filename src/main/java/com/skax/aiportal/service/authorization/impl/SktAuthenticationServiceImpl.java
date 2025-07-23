package com.skax.aiportal.service.authorization.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skax.aiportal.client.sktai.authorization.SktAiAuthenticationClient;
import com.skax.aiportal.client.sktai.authorization.dto.request.OAuth2LoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.SystemLoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenWithProjectResponse;
import com.skax.aiportal.constant.AuthConstants;
import com.skax.aiportal.dto.authorization.request.AuthLoginReq;
import com.skax.aiportal.dto.authorization.request.AuthLogoutReq;
import com.skax.aiportal.dto.authorization.request.AuthRefreshTokenReq;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginReq;
import com.skax.aiportal.dto.authorization.request.AuthTokenExchangeReq;
import com.skax.aiportal.dto.authorization.response.AuthLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthLogoutRes;
import com.skax.aiportal.dto.authorization.response.AuthRefreshTokenRes;
import com.skax.aiportal.dto.authorization.response.AuthSamlMetadataRes;
import com.skax.aiportal.dto.authorization.response.AuthSsoCallbackRes;
import com.skax.aiportal.dto.authorization.response.AuthSsoLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthSystemLoginRes;
import com.skax.aiportal.dto.authorization.response.AuthTokenExchangeRes;
import com.skax.aiportal.exception.AuthenticationException;
import com.skax.aiportal.service.authorization.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT AI 인증 서비스 구현체
 * 
 * <p>SKT AI 플랫폼의 인증 관련 비즈니스 로직을 처리하는 서비스 구현체입니다.
 * SktAiAuthenticationClient를 사용하여 실제 SKT AI API를 호출하고,
 * 응답을 내부 DTO로 변환하여 반환합니다.</p>
 * 
 * <p>주요 책임:</p>
 * <ul>
 *   <li>SKT AI Authentication API 호출</li>
 *   <li>요청/응답 DTO 변환</li>
 *   <li>비즈니스 로직 처리</li>
 *   <li>예외 처리 및 로깅</li>
 *   <li>트랜잭션 관리</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SktAuthenticationServiceImpl implements AuthenticationService {

    private final SktAiAuthenticationClient sktAiAuthenticationClient;

    /**
     * OAuth2 패스워드 플로우 로그인
     * 
     * @param request OAuth2 로그인 요청 정보
     * @return OAuth2 로그인 응답
     */
    @Override
    @Transactional
    public AuthLoginRes login(AuthLoginReq request) {
        log.info("OAuth2 로그인 시작: username={}", request.getUsername());
        
        try {
            // 내부 DTO를 클라이언트 DTO로 변환
            OAuth2LoginRequest clientRequest = OAuth2LoginRequest.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .clientId(request.getClientId())
                    .grantType(request.getGrantType())
                    .build();
            
            // 클라이언트 호출
            AccessTokenWithProjectResponse clientResponse = sktAiAuthenticationClient.login(clientRequest);
            
            // 클라이언트 응답을 내부 DTO로 변환
            AuthLoginRes response = AuthLoginRes.builder()
                    .accessToken(clientResponse.getAccessToken())
                    .refreshToken(clientResponse.getRefreshToken())
                    .tokenType(clientResponse.getTokenType())
                    .expiresIn(clientResponse.getExpiresIn())
                    .refreshExpiresIn(clientResponse.getRefreshExpiresIn())
                    .projects(convertToLoginProjectInfoList(clientResponse.getProjects()))
                    .build();
            
            log.info("OAuth2 로그인 성공: username={}", request.getUsername());
            return response;
            
        } catch (Exception e) {
            log.error("OAuth2 로그인 실패: username={}, error={}", request.getUsername(), e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.LOGIN_ERROR_CODE, 
                    AuthConstants.LOGIN_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * SSO 로그인 초기화
     * 
     * @return SSO 로그인 초기화 응답
     */
    @Override
    public AuthSsoLoginRes ssoLogin() {
        log.info("SSO 로그인 초기화 시작");
        
        try {
            // 클라이언트 호출
            Object clientResponse = sktAiAuthenticationClient.ssoLogin();
            
            // 응답 변환
            AuthSsoLoginRes response = AuthSsoLoginRes.builder()
                    .redirectUrl(String.valueOf(clientResponse))
                    .state(AuthConstants.DEFAULT_SSO_STATE)
                    .build();
            
            log.info("SSO 로그인 초기화 성공");
            return response;
            
        } catch (Exception e) {
            log.error("SSO 로그인 초기화 실패: error={}", e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.SSO_LOGIN_ERROR_CODE, 
                    AuthConstants.SSO_LOGIN_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * SSO 콜백 처리
     * 
     * @return SSO 콜백 처리 응답
     */
    @Override
    @Transactional
    public AuthSsoCallbackRes ssoCallback() {
        log.info("SSO 콜백 처리 시작");
        
        try {
            // 클라이언트 호출
            Object clientResponse = sktAiAuthenticationClient.ssoCallback();
            
            // 응답 변환
            AuthSsoCallbackRes response = AuthSsoCallbackRes.builder()
                    .success(true)
                    .message(AuthConstants.SSO_SUCCESS_MESSAGE)
                    .userData(String.valueOf(clientResponse))
                    .build();
            
            log.info("SSO 콜백 처리 성공");
            return response;
            
        } catch (Exception e) {
            log.error("SSO 콜백 처리 실패: error={}", e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.SSO_CALLBACK_ERROR_CODE, 
                    AuthConstants.SSO_CALLBACK_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * SAML IdP 메타데이터 조회
     * 
     * @return SAML IdP 메타데이터 응답
     */
    @Override
    public AuthSamlMetadataRes getSamlMetadata() {
        log.info("SAML 메타데이터 조회 시작");
        
        try {
            // 클라이언트 호출
            Object clientResponse = sktAiAuthenticationClient.getSamlMetadata();
            
            // 응답 변환
            AuthSamlMetadataRes response = AuthSamlMetadataRes.builder()
                    .metadata(String.valueOf(clientResponse))
                    .entityId(AuthConstants.DEFAULT_ENTITY_ID)
                    .ssoUrl(AuthConstants.DEFAULT_SSO_URL)
                    .build();
            
            log.info("SAML 메타데이터 조회 성공");
            return response;
            
        } catch (Exception e) {
            log.error("SAML 메타데이터 조회 실패: error={}", e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.SAML_METADATA_ERROR_CODE, 
                    AuthConstants.SAML_METADATA_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * 시스템 로그인
     * 
     * @param request 시스템 로그인 요청 정보
     * @return 시스템 로그인 응답
     */
    @Override
    @Transactional
    public AuthSystemLoginRes systemLogin(AuthSystemLoginReq request) {
        log.info("시스템 로그인 시작: clientName={}", request.getClientName());
        
        try {
            // 내부 DTO를 클라이언트 DTO로 변환
            SystemLoginRequest clientRequest = SystemLoginRequest.builder()
                    .username("system") // 시스템 사용자명
                    .roles(List.of()) // 빈 역할 목록
                    .groups(List.of()) // 빈 그룹 목록
                    .build();
            
            // 클라이언트 호출
            AccessTokenResponse clientResponse = sktAiAuthenticationClient.systemLogin(
                    request.getClientSecret(),
                    request.getClientName(),
                    clientRequest
            );
            
            // 클라이언트 응답을 내부 DTO로 변환
            AuthSystemLoginRes response = AuthSystemLoginRes.builder()
                    .accessToken(clientResponse.getAccessToken())
                    .tokenType(clientResponse.getTokenType())
                    .expiresIn(clientResponse.getExpiresIn())
                    .build();
            
            log.info("시스템 로그인 성공: clientName={}", request.getClientName());
            return response;
            
        } catch (Exception e) {
            log.error("시스템 로그인 실패: clientName={}, error={}", request.getClientName(), e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.SYSTEM_LOGIN_ERROR_CODE, 
                    AuthConstants.SYSTEM_LOGIN_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * 로그아웃
     * 
     * @param request 로그아웃 요청 정보
     * @return 로그아웃 처리 응답
     */
    @Override
    @Transactional
    public AuthLogoutRes logout(AuthLogoutReq request) {
        log.info("로그아웃 시작: username={}", request.getUsername());
        
        try {
            // 클라이언트 호출
            sktAiAuthenticationClient.logout(request.getUsername());
            
            // 응답 생성
            AuthLogoutRes response = AuthLogoutRes.builder()
                    .success(true)
                    .message(AuthConstants.LOGOUT_SUCCESS_MESSAGE)
                    .username(request.getUsername())
                    .build();
            
            log.info("로그아웃 성공: username={}", request.getUsername());
            return response;
            
        } catch (Exception e) {
            log.error("로그아웃 실패: username={}, error={}", request.getUsername(), e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.LOGOUT_ERROR_CODE, 
                    AuthConstants.LOGOUT_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * @param request 토큰 갱신 요청 정보
     * @return 토큰 갱신 응답
     */
    @Override
    @Transactional
    public AuthRefreshTokenRes refreshToken(AuthRefreshTokenReq request) {
        log.info("토큰 갱신 시작");
        
        try {
            // 클라이언트 호출
            AccessTokenWithProjectResponse clientResponse = sktAiAuthenticationClient.refreshToken(request.getRefreshToken());
            
            // 클라이언트 응답을 내부 DTO로 변환
            AuthRefreshTokenRes response = AuthRefreshTokenRes.builder()
                    .accessToken(clientResponse.getAccessToken())
                    .refreshToken(clientResponse.getRefreshToken())
                    .tokenType(clientResponse.getTokenType())
                    .expiresIn(clientResponse.getExpiresIn())
                    .refreshExpiresIn(clientResponse.getRefreshExpiresIn())
                    .projects(convertToRefreshProjectInfoList(clientResponse.getProjects()))
                    .build();
            
            log.info("토큰 갱신 성공");
            return response;
            
        } catch (Exception e) {
            log.error("토큰 갱신 실패: error={}", e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.REFRESH_TOKEN_ERROR_CODE, 
                    AuthConstants.REFRESH_TOKEN_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * 토큰 교환
     * 
     * @param request 토큰 교환 요청 정보
     * @return 토큰 교환 응답
     */
    @Override
    @Transactional
    public AuthTokenExchangeRes exchangeToken(AuthTokenExchangeReq request) {
        log.info("토큰 교환 시작: toExchangeClientName={}", request.getToExchangeClientName());
        
        try {
            // 클라이언트 호출
            AccessTokenWithProjectResponse clientResponse = sktAiAuthenticationClient.exchangeToken(
                    request.getToExchangeClientName()
            );
            
            // 클라이언트 응답을 내부 DTO로 변환
            AuthTokenExchangeRes response = AuthTokenExchangeRes.builder()
                    .accessToken(clientResponse.getAccessToken())
                    .refreshToken(clientResponse.getRefreshToken())
                    .tokenType(clientResponse.getTokenType())
                    .expiresIn(clientResponse.getExpiresIn())
                    .refreshExpiresIn(clientResponse.getRefreshExpiresIn())
                    .projects(convertToExchangeProjectInfoList(clientResponse.getProjects()))
                    .toExchangeClientName(request.getToExchangeClientName())
                    .build();
            
            log.info("토큰 교환 성공: toExchangeClientName={}", request.getToExchangeClientName());
            return response;
            
        } catch (Exception e) {
            log.error("토큰 교환 실패: toExchangeClientName={}, error={}", request.getToExchangeClientName(), e.getMessage(), e);
            throw new AuthenticationException(AuthConstants.TOKEN_EXCHANGE_ERROR_CODE, 
                    AuthConstants.TOKEN_EXCHANGE_ERROR_MESSAGE + ": " + e.getMessage(), e);
        }
    }

    /**
     * 클라이언트 프로젝트 정보를 내부 DTO로 변환 (로그인용)
     */
    private List<AuthLoginRes.ProjectInfo> convertToLoginProjectInfoList(
            List<AccessTokenWithProjectResponse.ProjectPayload> clientProjects) {
        if (clientProjects == null) {
            return List.of();
        }
        
        return clientProjects.stream()
                .map(clientProject -> AuthLoginRes.ProjectInfo.builder()
                        .id(clientProject.getId())
                        .name(clientProject.getName())
                        .description(clientProject.getDescription())
                        .status(clientProject.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 클라이언트 프로젝트 정보를 내부 DTO로 변환 (리프레시용)
     */
    private List<AuthRefreshTokenRes.ProjectInfo> convertToRefreshProjectInfoList(
            List<AccessTokenWithProjectResponse.ProjectPayload> clientProjects) {
        if (clientProjects == null) {
            return List.of();
        }
        
        return clientProjects.stream()
                .map(clientProject -> AuthRefreshTokenRes.ProjectInfo.builder()
                        .id(clientProject.getId())
                        .name(clientProject.getName())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 클라이언트 프로젝트 정보를 내부 DTO로 변환 (교환용)
     */
    private List<AuthTokenExchangeRes.ProjectInfo> convertToExchangeProjectInfoList(
            List<AccessTokenWithProjectResponse.ProjectPayload> clientProjects) {
        if (clientProjects == null) {
            return List.of();
        }
        
        return clientProjects.stream()
                .map(clientProject -> AuthTokenExchangeRes.ProjectInfo.builder()
                        .id(clientProject.getId())
                        .name(clientProject.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
