package com.skax.aiportal.client.sktai.config;

import feign.Logger;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SKT AI 클라이언트 설정 클래스
 * 
 * <p>SKT AI API 연동을 위한 Feign Client 설정을 담당합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
public class SktAiClientConfig {

    @Value("${sktai.api.base-url:https://aip-stg.sktai.io}")
    private String baseUrl;

    @Value("${sktai.api.timeout.connect:5000}")
    private int connectTimeout;

    @Value("${sktai.api.timeout.read:30000}")
    private int readTimeout;

    /**
     * Feign 로깅 레벨을 설정합니다.
     * 
     * @return Logger.Level
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        log.info("SKT AI Feign 로깅 레벨 설정 - FULL");
        return Logger.Level.FULL;
    }

    /**
     * SKT AI API 요청 인터셉터를 설정합니다.
     * 
     * @return RequestInterceptor
     */
    @Bean("sktAiRequestInterceptor")
    public RequestInterceptor sktAiRequestInterceptor() {
        log.info("SKT AI 요청 인터셉터 설정 시작");
        log.debug("기본 URL: {}", baseUrl);
        log.debug("연결 타임아웃: {}ms", connectTimeout);
        log.debug("읽기 타임아웃: {}ms", readTimeout);
        
        return requestTemplate -> {
            log.debug("SKT AI API 요청 인터셉터 실행 - URL: {}", requestTemplate.url());
            
            // 공통 헤더 설정
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("User-Agent", "AXPORTAL-Backend/1.0");
            
            log.debug("공통 헤더 설정 완료 - Accept: application/json, Content-Type: application/json");
        };
    }

    /**
     * 설정 정보를 반환합니다.
     * 
     * @return SktAiConfig
     */
    @Bean
    public SktAiConfig sktAiConfig() {
        log.info("SKT AI 설정 정보 생성");
        SktAiConfig config = SktAiConfig.builder()
                .baseUrl(baseUrl)
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .build();
        
        log.debug("SKT AI 설정 정보: {}", config);
        return config;
    }

    /**
     * SKT AI 설정 정보 클래스
     */
    @lombok.Builder
    @lombok.Getter
    @lombok.ToString
    public static class SktAiConfig {
        private final String baseUrl;
        private final int connectTimeout;
        private final int readTimeout;
    }
}
