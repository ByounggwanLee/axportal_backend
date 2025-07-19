package com.skax.aiportal.service.authorization;

import com.skax.aiportal.dto.authorization.request.AuthLoginRequest;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginRequest;
import com.skax.aiportal.dto.authorization.response.AuthTokenResponse;
import com.skax.aiportal.dto.authorization.response.AuthTokenWithProjectResponse;

/**
 * 인증 서비스 인터페이스
 * 
 * <p>SKT AI 플랫폼의 인증 관련 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * OAuth2 패스워드 플로우를 통한 로그인
     * 
     * @param request 로그인 요청 정보
     * @return 액세스 토큰 및 프로젝트 정보
     */
    AuthTokenWithProjectResponse login(AuthLoginRequest request);

    /**
     * 시스템 로그인
     * 
     * @param clientSecret 클라이언트 시크릿
     * @param clientName 클라이언트명
     * @param request 시스템 로그인 요청 정보
     * @return 액세스 토큰
     */
    AuthTokenResponse systemLogin(String clientSecret, String clientName, AuthSystemLoginRequest request);

    /**
     * SSO 로그인 처리
     * 
     * @return SSO 로그인 응답
     */
    Object ssoLogin();

    /**
     * SSO 콜백 처리
     * 
     * @return SSO 콜백 응답
     */
    Object ssoCallback();

    /**
     * SAML 메타데이터 조회
     * 
     * @return SAML IdP 메타데이터
     */
    Object getSamlMetadata();

    /**
     * SAML 로그인 폼 조회
     * 
     * @return SAML 로그인 폼 HTML
     */
    String getSamlLoginForm();

    /**
     * 사용자 로그아웃
     * 
     * @param username 로그아웃할 사용자명
     * @return 로그아웃 결과
     */
    Object logout(String username);

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * @param refreshToken 리프레시 토큰
     * @return 새로운 액세스 토큰 및 프로젝트 정보
     */
    AuthTokenWithProjectResponse refreshToken(String refreshToken);

    /**
     * 토큰 교환 (프로젝트 변경 시 사용)
     * 
     * @param toExchangeClientName 교환할 클라이언트명
     * @return 교환된 토큰 및 프로젝트 정보
     */
    AuthTokenWithProjectResponse exchangeToken(String toExchangeClientName);

    /**
     * 토큰 유효성 검증
     * 
     * @param accessToken 검증할 액세스 토큰
     * @return 토큰 유효성 여부
     */
    boolean validateToken(String accessToken);

    /**
     * 현재 로그인한 사용자 정보 조회
     * 
     * @return 사용자 정보
     */
    Object getCurrentUser();
}
