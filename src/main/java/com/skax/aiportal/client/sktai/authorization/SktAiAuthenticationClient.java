package com.skax.aiportal.client.sktai.authorization;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.authorization.dto.request.OAuth2LoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.SystemLoginRequest;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.AccessTokenWithProjectResponse;

/**
 * SKT AI 인증 API Feign Client
 * 
 * <p>SKT AI 플랫폼의 인증 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-auth",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = {
                com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
                com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
                com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiAuthenticationClient {

    /**
     * OAuth2 패스워드 플로우 로그인
     * 
     * @param request 로그인 요청 정보
     * @return 액세스 토큰 및 프로젝트 정보
     */
    @PostMapping(value = "/api/v1/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AccessTokenWithProjectResponse login(@RequestBody OAuth2LoginRequest request);

    /**
     * SSO 로그인
     * 
     * @return SSO 로그인 응답
     */
    @GetMapping(value="/api/v1/auth/login/sso", produces = MediaType.APPLICATION_JSON_VALUE)
    Object ssoLogin();

    /**
     * SSO 콜백
     * 
     * @return SSO 콜백 응답
     */
    @GetMapping(value = "/api/v1/auth/login/sso/callback", produces = MediaType.APPLICATION_XML_VALUE)
    Object ssoCallback();

    /**
     * SAML IdP 메타데이터 조회
     * 
     * @return SAML 메타데이터
     */
    @GetMapping(value="/api/v1/auth/saml_idp/metadata", produces = MediaType.APPLICATION_XML_VALUE)
    Object getSamlMetadata();

    /**
     * SAML 로그인 폼
     * 
     * @return 로그인 폼 HTML
     */
    @GetMapping(value = "/api/v1/auth/saml_idp/sso", produces = MediaType.TEXT_HTML_VALUE)
    String getSamlLoginForm();

    /**
     * 시스템 로그인
     * 
     * @param clientSecret 클라이언트 시크릿
     * @param clientName 클라이언트명 (기본값: default)
     * @param request 시스템 로그인 요청 정보
     * @return 액세스 토큰
     */
    @PostMapping(value = "/api/v1/auth/login/system", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AccessTokenResponse systemLogin(
            @RequestParam("client_secret") String clientSecret,
            @RequestParam(value = "client_name", defaultValue = "default") String clientName,
            @RequestBody SystemLoginRequest request
    );

    /**
     * 로그아웃
     * 
     * @param username 사용자명
     * @return 로그아웃 결과
     */
    @PostMapping(value = "/api/v1/auth/logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Object logout(@RequestParam("username") String username);

    /**
     * 리프레시 토큰을 사용한 액세스 토큰 갱신
     * 
     * @param refreshToken 리프레시 토큰
     * @return 새로운 액세스 토큰 및 프로젝트 정보
     */
    @PostMapping(value= "/api/v1/auth/token/refresh", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AccessTokenWithProjectResponse refreshToken(@RequestParam("refresh_token") String refreshToken);

    /**
     * 토큰 교환
     * 
     * @param toExchangeClientName 교환할 클라이언트명 (기본값: default)
     * @return 교환된 토큰 및 프로젝트 정보
     */
    @GetMapping(value="/api/v1/auth/token/exchange", produces = MediaType.APPLICATION_JSON_VALUE)
    AccessTokenWithProjectResponse exchangeToken(
            @RequestParam(value = "to_exchange_client_name", defaultValue = "default") String toExchangeClientName
    );
}
