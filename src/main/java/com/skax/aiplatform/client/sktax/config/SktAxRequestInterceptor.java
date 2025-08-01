package com.skax.aiplatform.client.sktax.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * SKTAX API 요청 인터셉터
 * 
 * <p>모든 SKTAX API 요청에 공통으로 적용되는 헤더, 인증 정보 등을 설정합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Slf4j
public class SktAxRequestInterceptor implements RequestInterceptor {

    private static final String CONTENT_TYPE = "application/json";
    private static final String USER_AGENT = "AXPORTAL-Backend/1.0";

    @Override
    public void apply(RequestTemplate template) {
        // 공통 헤더 설정
        template.header("Content-Type", CONTENT_TYPE);
        template.header("User-Agent", USER_AGENT);
        template.header("Accept", "application/json");
        
        // 요청 로깅
        log.debug("SKTAX API 요청: {} {}", template.method(), template.url());
        
        // Authorization 헤더는 별도의 토큰 관리 로직에서 처리
        // 향후 OAuth2 토큰이나 API Key 추가 가능
    }
}
