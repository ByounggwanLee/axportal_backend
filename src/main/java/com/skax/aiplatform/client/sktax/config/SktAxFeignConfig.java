package com.skax.aiplatform.client.sktax.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SKTAX 외부 API 호출을 위한 Feign Client 설정
 * 
 * <p>OpenFeign을 통해 SKTAX 서비스들과 통신하기 위한 공통 설정을 제공합니다.
 * 로깅, 인터셉터, 에러 처리 등의 기능을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class SktAxFeignConfig {

    /**
     * Feign Client 로그 레벨 설정
     * 
     * @return Feign Logger Level (개발환경에서는 FULL, 운영환경에서는 BASIC)
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 요청 인터셉터 등록
     * 
     * @return SktAx 요청 인터셉터
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new SktAxRequestInterceptor();
    }

    /**
     * 에러 디코더 등록
     * 
     * @return SktAx 에러 디코더
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new SktAxErrorDecoder();
    }
}
