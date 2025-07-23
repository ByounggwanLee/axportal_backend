package com.skax.aiportal.service.authorization;

import com.skax.aiportal.dto.authorization.request.AuthLoginRequest;
import com.skax.aiportal.dto.authorization.request.AuthLogoutRequest;
import com.skax.aiportal.dto.authorization.request.AuthRefreshTokenRequest;
import com.skax.aiportal.dto.authorization.request.AuthSystemLoginRequest;
import com.skax.aiportal.dto.authorization.request.AuthTokenExchangeRequest;
import com.skax.aiportal.dto.authorization.response.AuthLoginResponse;
import com.skax.aiportal.dto.authorization.response.AuthLogoutResponse;
import com.skax.aiportal.dto.authorization.response.AuthRefreshTokenResponse;
import com.skax.aiportal.dto.authorization.response.AuthSamlLoginFormResponse;
import com.skax.aiportal.dto.authorization.response.AuthSamlMetadataResponse;
import com.skax.aiportal.dto.authorization.response.AuthSsoCallbackResponse;
import com.skax.aiportal.dto.authorization.response.AuthSsoLoginResponse;
import com.skax.aiportal.dto.authorization.response.AuthSystemLoginResponse;
import com.skax.aiportal.dto.authorization.response.AuthTokenExchangeResponse;

/**
 * 인증 서비스 인터페이스
 * 
 * <p>SKT AI 플랫폼의 인증 관련 비즈니스 로직을 처리하는 서비스 인터페이스입니다.
 * OAuth2 로그인, SSO, SAML, 시스템 로그인, 토큰 관리 등의 기능을 제공합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>OAuth2 패스워드 플로우 로그인</li>
 *   <li>SSO (Single Sign-On) 인증</li>
 *   <li>SAML 기반 인증</li>
 *   <li>시스템 간 인증</li>
 *   <li>토큰 갱신 및 교환</li>
 *   <li>로그아웃 처리</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * OAuth2 패스워드 플로우 로그인
     * 
     * <p>사용자 이름과 비밀번호를 사용하여 OAuth2 인증을 수행합니다.
     * 성공 시 액세스 토큰과 리프레시 토큰, 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param request OAuth2 로그인 요청 정보 (username, password, client_id 등)
     * @return OAuth2 로그인 응답 (액세스 토큰, 리프레시 토큰, 프로젝트 목록)
     * @throws IllegalArgumentException 요청 파라미터가 유효하지 않은 경우
     * @throws RuntimeException 인증 실패 또는 서버 오류 시
     */
    AuthLoginResponse login(AuthLoginRequest request);

    /**
     * SSO 로그인 초기화
     * 
     * <p>Single Sign-On 로그인 프로세스를 시작합니다.
     * SSO 제공자로의 리디렉션 URL이나 관련 정보를 반환합니다.</p>
     * 
     * @return SSO 로그인 초기화 응답 (리디렉션 URL, 상태 정보 등)
     * @throws RuntimeException SSO 초기화 실패 시
     */
    AuthSsoLoginResponse ssoLogin();

    /**
     * SSO 콜백 처리
     * 
     * <p>SSO 제공자로부터의 콜백을 처리합니다.
     * 인증 코드를 액세스 토큰으로 교환하고 사용자 정보를 반환합니다.</p>
     * 
     * @return SSO 콜백 처리 응답 (사용자 정보, 토큰 등)
     * @throws RuntimeException SSO 콜백 처리 실패 시
     */
    AuthSsoCallbackResponse ssoCallback();

    /**
     * SAML IdP 메타데이터 조회
     * 
     * <p>SAML Identity Provider의 메타데이터 정보를 조회합니다.
     * SAML SP 설정에 필요한 IdP 정보를 제공합니다.</p>
     * 
     * @return SAML IdP 메타데이터 응답 (엔드포인트, 인증서 등)
     * @throws RuntimeException 메타데이터 조회 실패 시
     */
    AuthSamlMetadataResponse getSamlMetadata();

    /**
     * SAML 로그인 폼 조회
     * 
     * <p>SAML 로그인을 위한 HTML 폼을 조회합니다.
     * 사용자가 직접 SAML 로그인을 수행할 수 있는 폼을 제공합니다.</p>
     * 
     * @return SAML 로그인 폼 응답 (HTML 폼)
     * @throws RuntimeException SAML 폼 조회 실패 시
     */
    AuthSamlLoginFormResponse getSamlLoginForm();

    /**
     * 시스템 로그인
     * 
     * <p>시스템 간 인증을 위한 로그인을 수행합니다.
     * 클라이언트 시크릿을 사용하여 시스템 레벨의 액세스 토큰을 발급받습니다.</p>
     * 
     * @param request 시스템 로그인 요청 정보 (client_secret, client_name 등)
     * @return 시스템 로그인 응답 (액세스 토큰, 만료 시간 등)
     * @throws IllegalArgumentException 클라이언트 시크릿이 유효하지 않은 경우
     * @throws RuntimeException 시스템 인증 실패 시
     */
    AuthSystemLoginResponse systemLogin(AuthSystemLoginRequest request);

    /**
     * 로그아웃
     * 
     * <p>사용자의 로그아웃을 처리합니다.
     * 서버 측에서 토큰을 무효화하고 세션을 종료합니다.</p>
     * 
     * @param request 로그아웃 요청 정보 (username 등)
     * @return 로그아웃 처리 응답 (성공 여부, 메시지 등)
     * @throws IllegalArgumentException 사용자명이 유효하지 않은 경우
     * @throws RuntimeException 로그아웃 처리 실패 시
     */
    AuthLogoutResponse logout(AuthLogoutRequest request);

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * <p>만료된 액세스 토큰을 리프레시 토큰을 사용하여 갱신합니다.
     * 새로운 액세스 토큰과 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param request 토큰 갱신 요청 정보 (refresh_token)
     * @return 토큰 갱신 응답 (새로운 액세스 토큰, 프로젝트 목록)
     * @throws IllegalArgumentException 리프레시 토큰이 유효하지 않은 경우
     * @throws RuntimeException 토큰 갱신 실패 시
     */
    AuthRefreshTokenResponse refreshToken(AuthRefreshTokenRequest request);

    /**
     * 토큰 교환
     * 
     * <p>현재 토큰을 다른 클라이언트용 토큰으로 교환합니다.
     * 마이크로서비스 간 토큰 전달 시 사용됩니다.</p>
     * 
     * @param request 토큰 교환 요청 정보 (to_exchange_client_name)
     * @return 토큰 교환 응답 (교환된 토큰, 프로젝트 목록)
     * @throws IllegalArgumentException 교환 대상 클라이언트명이 유효하지 않은 경우
     * @throws RuntimeException 토큰 교환 실패 시
     */
    AuthTokenExchangeResponse exchangeToken(AuthTokenExchangeRequest request);
}
