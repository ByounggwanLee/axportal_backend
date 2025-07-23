package com.skax.aiportal.client.sktai.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT AI 인증 인터셉터
 * 
 * <p>
 * SKT AI API 호출 시 인증 토큰을 자동으로 추가합니다.
 * </p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Component
public class SktAiAuthInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Value("${sktai.api.client-id:default}")
    private String clientId;

    @Value("${sktai.api.client-secret:}")
    private String clientSecret;

    private volatile String accessToken;
    private volatile long tokenExpiryTime;

    @Override
    public void apply(RequestTemplate template) {

        log.debug("SKT AI 인증 인터셉터 실행 - URL: {}", template.url());

        try {
            // 현재 요청 컨텍스트에서 HttpServletRequest를 가져옵니다.
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();

            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                accessToken = request.getHeader(AUTHORIZATION_HEADER);
            }

            // 로그인 API는 인증 토큰 불필요
            if (isAuthEndpoint(template.url())) {
                log.debug("인증 엔드포인트 호출 - 토큰 추가 생략");
                addClientCredentials(template);
                return;
            }

            // 액세스 토큰 유효성 검사 및 갱신
            if (isTokenExpired()) {
                log.info("액세스 토큰 만료 또는 없음 - 토큰 갱신 필요");
                refreshAccessToken();
            }

            // Authorization 헤더 추가
            if (accessToken != null) {
                template.header(AUTHORIZATION_HEADER, accessToken);
                log.debug("Authorization 헤더 추가 완료");
            } else {
                log.warn("액세스 토큰이 없음 - Authorization 헤더 추가 실패");
            }

        } catch (Exception e) {
            log.error("SKT AI 인증 인터셉터 실행 중 오류 발생: {}", e.getMessage(), e);
        }
    }

    /**
     * 인증 관련 엔드포인트인지 확인합니다.
     * 
     * @param url 요청 URL
     * @return 인증 엔드포인트 여부
     */
    private boolean isAuthEndpoint(String url) {
        boolean isAuth = url.contains("/auth/login") ||
                url.contains("/auth/token/refresh") ||
                url.contains("/auth/token/exchange");
        log.debug("인증 엔드포인트 확인 - URL: {}, 결과: {}", url, isAuth);
        return isAuth;
    }

    /**
     * 클라이언트 인증 정보를 추가합니다.
     * 
     * @param template 요청 템플릿
     */
    private void addClientCredentials(RequestTemplate template) {
        log.debug("클라이언트 인증 정보 추가 - Client ID: {}", clientId);

        if (clientSecret != null && !clientSecret.isEmpty()) {
            template.query("client_secret", clientSecret);
            log.debug("클라이언트 시크릿 추가 완료");
        }

        template.query("client_id", clientId);
        log.debug("클라이언트 ID 추가 완료");
    }

    /**
     * 토큰이 만료되었는지 확인합니다.
     * 
     * @return 토큰 만료 여부
     */
    private boolean isTokenExpired() {
        boolean expired = accessToken == null || System.currentTimeMillis() >= tokenExpiryTime;
        log.debug("토큰 만료 확인 - 결과: {}, 현재시간: {}, 만료시간: {}",
                expired, System.currentTimeMillis(), tokenExpiryTime);
        return expired;
    }

    /**
     * 액세스 토큰을 갱신합니다.
     * 
     * TODO: 실제 토큰 갱신 로직 구현 필요
     */
    private void refreshAccessToken() {
        log.info("액세스 토큰 갱신 시작");

        try {
            // TODO: 실제 SKT AI 로그인 API 호출하여 토큰 획득
            // 현재는 더미 토큰으로 설정
            this.accessToken = "dummy_access_token";
            this.tokenExpiryTime = System.currentTimeMillis() + (60 * 60 * 1000); // 1시간 후 만료

            log.info("액세스 토큰 갱신 완료 - 만료시간: {}", tokenExpiryTime);
            log.debug("새로운 액세스 토큰: {}", accessToken.substring(0, Math.min(10, accessToken.length())) + "...");

        } catch (Exception e) {
            log.error("액세스 토큰 갱신 중 오류 발생: {}", e.getMessage(), e);
        }
    }

    /**
     * 수동으로 액세스 토큰을 설정합니다.
     * 
     * @param token     액세스 토큰
     * @param expiresIn 만료 시간 (초)
     */
    public void setAccessToken(String token, long expiresIn) {
        log.info("액세스 토큰 수동 설정 - 만료시간: {}초", expiresIn);
        this.accessToken = token;
        this.tokenExpiryTime = System.currentTimeMillis() + (expiresIn * 1000);
        log.debug("액세스 토큰 설정 완료");
    }

    /**
     * 현재 액세스 토큰을 반환합니다.
     * 
     * @return 액세스 토큰
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 토큰을 무효화합니다.
     */
    public void invalidateToken() {
        log.info("액세스 토큰 무효화");
        this.accessToken = null;
        this.tokenExpiryTime = 0;
    }
}
