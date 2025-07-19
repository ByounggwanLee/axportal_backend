package com.skax.aiportal.client.sktai.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * SKT AI 로깅 인터셉터
 * 
 * <p>SKT AI API 호출에 대한 상세한 로깅을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Component
public class SktAiLoggingInterceptor implements RequestInterceptor {

    private static final String REQUEST_ID_HEADER = "X-Request-ID";
    private static final String CORRELATION_ID_HEADER = "X-Correlation-ID";

    @Override
    public void apply(RequestTemplate template) {
        String requestId = generateRequestId();
        String correlationId = generateCorrelationId();
        
        log.info("=== SKT AI API 요청 시작 ===");
        log.info("요청 ID: {}", requestId);
        log.info("상관관계 ID: {}", correlationId);
        log.info("HTTP 메서드: {}", template.method());
        log.info("요청 URL: {}", template.url());
        
        // 요청 헤더 로깅
        if (!template.headers().isEmpty()) {
            log.debug("요청 헤더:");
            template.headers().forEach((key, values) -> {
                if (!isSensitiveHeader(key)) {
                    log.debug("  {}: {}", key, values);
                } else {
                    log.debug("  {}: [MASKED]", key);
                }
            });
        }

        // 요청 바디 로깅 (POST, PUT 등)
        if (template.body() != null) {
            String body = new String(template.body());
            if (isSensitiveBody(body)) {
                log.debug("요청 바디: [SENSITIVE DATA MASKED]");
            } else {
                log.debug("요청 바디: {}", body);
            }
        }

        // 쿼리 파라미터 로깅
        if (!template.queries().isEmpty()) {
            log.debug("쿼리 파라미터:");
            template.queries().forEach((key, values) -> {
                if (!isSensitiveParameter(key)) {
                    log.debug("  {}: {}", key, values);
                } else {
                    log.debug("  {}: [MASKED]", key);
                }
            });
        }

        // 추적용 헤더 추가
        template.header(REQUEST_ID_HEADER, requestId);
        template.header(CORRELATION_ID_HEADER, correlationId);
        
        log.info("=== SKT AI API 요청 완료 ===");
    }

    /**
     * 고유한 요청 ID를 생성합니다.
     * 
     * @return 요청 ID
     */
    private String generateRequestId() {
        return "SKTAI-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    /**
     * 상관관계 ID를 생성합니다.
     * 
     * @return 상관관계 ID
     */
    private String generateCorrelationId() {
        return "CORR-" + System.currentTimeMillis() + "-" + 
               UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    /**
     * 민감한 헤더인지 확인합니다.
     * 
     * @param headerName 헤더 이름
     * @return 민감한 헤더 여부
     */
    private boolean isSensitiveHeader(String headerName) {
        String lowerName = headerName.toLowerCase();
        return lowerName.contains("authorization") ||
               lowerName.contains("token") ||
               lowerName.contains("secret") ||
               lowerName.contains("password") ||
               lowerName.contains("credential");
    }

    /**
     * 민감한 요청 바디인지 확인합니다.
     * 
     * @param body 요청 바디
     * @return 민감한 바디 여부
     */
    private boolean isSensitiveBody(String body) {
        if (body == null || body.isEmpty()) {
            return false;
        }
        
        String lowerBody = body.toLowerCase();
        return lowerBody.contains("password") ||
               lowerBody.contains("secret") ||
               lowerBody.contains("token") ||
               lowerBody.contains("credential");
    }

    /**
     * 민감한 파라미터인지 확인합니다.
     * 
     * @param paramName 파라미터 이름
     * @return 민감한 파라미터 여부
     */
    private boolean isSensitiveParameter(String paramName) {
        String lowerName = paramName.toLowerCase();
        return lowerName.contains("password") ||
               lowerName.contains("secret") ||
               lowerName.contains("token") ||
               lowerName.contains("credential");
    }
}
