package com.skax.aiplatform.client.sktax.intercept;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * SKTAX API 호출 시 공통 헤더 및 인증 정보를 추가하는 인터셉터
 * 
 * <p>모든 SKTAX API 호출에 대해 다음 기능을 제공합니다:</p>
 * <ul>
 *   <li>Bearer Token 자동 추가</li>
 *   <li>Content-Type 헤더 설정</li>
 *   <li>User-Agent 헤더 설정</li>
 *   <li>요청 로깅</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Slf4j
@Component
public class SktAxRequestInterceptor implements RequestInterceptor {

    @Value("${app.name:AxPortal}")
    private String applicationName;

    @Value("${app.version:1.0.0}")
    private String applicationVersion;

    /**
     * SKTAX API 요청에 공통 헤더와 인증 정보를 추가
     * 
     * @param template Feign Request Template
     */
    @Override
    public void apply(RequestTemplate template) {
        // Content-Type 설정
        if (!template.headers().containsKey("Content-Type")) {
            template.header("Content-Type", "application/json");
        }

        // User-Agent 설정
        template.header("User-Agent", String.format("%s/%s", applicationName, applicationVersion));

        // Bearer Token 추가 (현재 인증된 사용자의 토큰 사용)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getCredentials() != null) {
            String token = authentication.getCredentials().toString();
            if (!token.startsWith("Bearer ")) {
                token = "Bearer " + token;
            }
            template.header("Authorization", token);
            log.debug("Added Authorization header for SKTAX API call: {}", template.url());
        } else {
            log.warn("No authentication found for SKTAX API call: {}", template.url());
        }

        // 요청 정보 로깅
        log.info("SKTAX API Request: {} {}", template.method(), template.url());
        if (log.isDebugEnabled()) {
            log.debug("Request Headers: {}", template.headers());
            if (template.body() != null) {
                log.debug("Request Body: {}", new String(template.body()));
            }
        }
    }
}
