package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.request.BodyLoginAccessTokenApiV1AuthLoginPost;
import com.skax.aiplatform.client.sktax.auth.dto.response.AccessTokenResponse;
import com.skax.aiplatform.client.sktax.auth.dto.response.AccessTokenResponseWithProject;
import com.skax.aiplatform.client.sktax.auth.dto.SystemLoginPayload;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 인증 API Feign Client
 * 
 * <p>인증, 로그인, 로그아웃, 토큰 관리 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthClient {

    /**
     * 로그인 액세스 토큰 발급
     * 
     * @param loginRequest 로그인 요청 데이터
     * @return 액세스 토큰 응답
     */
    @PostMapping(value = "/api/v1/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AccessTokenResponseWithProject loginAccessToken(
            @RequestBody BodyLoginAccessTokenApiV1AuthLoginPost loginRequest
    );

    /**
     * SSO 로그인
     * 
     * @return SSO 로그인 응답
     */
    @GetMapping("/api/v1/auth/login/sso")
    Object ssoLogin();

    /**
     * SSO 콜백
     * 
     * @return SSO 콜백 응답
     */
    @GetMapping("/api/v1/auth/login/sso/callback")
    Object ssoCallback();

    /**
     * 시스템 로그인
     * 
     * @param clientSecret 클라이언트 시크릿
     * @param clientName 클라이언트명 (기본값: default)
     * @param payload 시스템 로그인 Payload
     * @return 액세스 토큰 응답
     */
    @PostMapping("/api/v1/auth/login/system")
    AccessTokenResponse loginSystem(
            @RequestParam("client_secret") String clientSecret,
            @RequestParam(value = "client_name", defaultValue = "default") String clientName,
            @RequestBody SystemLoginPayload payload
    );

    /**
     * 로그아웃
     * 
     * @param username 사용자명
     * @return 로그아웃 응답
     */
    @PostMapping("/api/v1/auth/logout")
    Object logout(@RequestParam("username") String username);

    /**
     * 리프레시 토큰을 이용한 액세스 토큰 재발급
     * 
     * @param refreshToken 리프레시 토큰
     * @return 액세스 토큰 응답
     */
    @PostMapping("/api/v1/auth/token/refresh")
    AccessTokenResponseWithProject refreshToken(
            @RequestParam("refresh_token") String refreshToken
    );

    /**
     * 토큰 교환
     * 
     * @param toExchangeClientName 교환할 클라이언트명 (기본값: default)
     * @return 액세스 토큰 응답
     */
    @GetMapping("/api/v1/auth/token/exchange")
    AccessTokenResponseWithProject exchangeToken(
            @RequestParam(value = "to_exchange_client_name", defaultValue = "default") String toExchangeClientName
    );
}
