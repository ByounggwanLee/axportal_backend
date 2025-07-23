package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.request.OAuth2LoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.SystemLoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenWithProjectResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * SKT AI 인증 API Feign 클라이언트
 * 
 * <p>SKT AI 플랫폼의 인증 관련 API를 호출하는 Feign 클라이언트입니다.
 * OAuth2, SSO, SAML, 시스템 로그인, 토큰 관리 등의 인증 기능을 제공합니다.</p>
 * 
 * <p>지원하는 인증 방식:</p>
 * <ul>
 *   <li>OAuth2 패스워드 플로우</li>
 *   <li>Single Sign-On (SSO)</li>
 *   <li>SAML 기반 인증</li>
 *   <li>시스템 간 인증</li>
 *   <li>토큰 갱신 및 교환</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-authentication",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = SktAiClientConfig.class ,
    path = "/api/v1/auth"
)
public interface SktAiAuthenticationClient {

    /**
     * OAuth2 패스워드 플로우 로그인
     * 
     * <p>사용자명과 비밀번호를 사용하여 OAuth2 인증을 수행합니다.
     * 성공 시 액세스 토큰, 리프레시 토큰, 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param request OAuth2 로그인 요청 정보
     * @return 액세스 토큰과 프로젝트 정보
     */
    @PostMapping(value="/login", consumes = "multipart/form-data", produces = "application/json")
    AccessTokenWithProjectResponse login(@Valid @RequestBody OAuth2LoginRequest request);

    /**
     * SSO 로그인 초기화
     * 
     * <p>Single Sign-On 로그인 프로세스를 시작합니다.
     * SSO 제공자로의 리디렉션 URL을 반환합니다.</p>
     * 
     * @return SSO 로그인 초기화 정보
     */
    @GetMapping("/sso/login")
    Object ssoLogin();

    /**
     * SSO 콜백 처리
     * 
     * <p>SSO 제공자로부터의 콜백을 처리합니다.
     * 인증 코드를 액세스 토큰으로 교환합니다.</p>
     * 
     * @return SSO 콜백 처리 결과
     */
    @GetMapping("/sso/callback")
    Object ssoCallback();

    /**
     * SAML IdP 메타데이터 조회
     * 
     * <p>SAML Identity Provider의 메타데이터 정보를 조회합니다.
     * SAML SP 설정에 필요한 IdP 정보를 제공합니다.</p>
     * 
     * @return SAML IdP 메타데이터
     */
    @GetMapping("/saml/metadata")
    Object getSamlMetadata();

    /**
     * 시스템 로그인
     * 
     * <p>시스템 간 인증을 위한 로그인을 수행합니다.
     * 클라이언트 시크릿을 사용하여 시스템 레벨의 액세스 토큰을 발급받습니다.</p>
     * 
     * @param clientSecret 클라이언트 시크릿
     * @param clientName 클라이언트 이름
     * @param request 시스템 로그인 요청 정보
     * @return 시스템 액세스 토큰
     */
    @PostMapping(value = "/system/login", consumes = "multipart/form-data", produces = "application/json")
    AccessTokenResponse systemLogin(
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("client_name") String clientName,
            @Valid @RequestBody SystemLoginRequest request
    );

    /**
     * 로그아웃
     * 
     * <p>사용자의 로그아웃을 처리합니다.
     * 서버 측에서 토큰을 무효화하고 세션을 종료합니다.</p>
     * 
     * @param username 사용자명
     */
    @PostMapping(value="/logout", consumes = "multipart/form-data", produces = "application/json")
    void logout(@RequestParam("username") String username);

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * <p>만료된 액세스 토큰을 리프레시 토큰을 사용하여 갱신합니다.
     * 새로운 액세스 토큰과 사용 가능한 프로젝트 목록을 반환합니다.</p>
     * 
     * @param refreshToken 리프레시 토큰
     * @return 갱신된 액세스 토큰과 프로젝트 정보
     */
    @PostMapping(value = "/token/refresh", consumes = "multipart/form-data", produces = "application/json")
    AccessTokenWithProjectResponse refreshToken(@RequestParam("refresh_token") String refreshToken);

    /**
     * 토큰 교환
     * 
     * <p>현재 토큰을 다른 클라이언트용 토큰으로 교환합니다.
     * 마이크로서비스 간 토큰 전달 시 사용됩니다.</p>
     * 
     * @param toExchangeClientName 교환할 대상 클라이언트 이름
     * @return 교환된 토큰과 프로젝트 정보
     */
    @PostMapping(value = "/exchange", consumes = "multipart/form-data", produces = "application/json")
    AccessTokenWithProjectResponse exchangeToken(@RequestParam("to_exchange_client_name") String toExchangeClientName);
}
