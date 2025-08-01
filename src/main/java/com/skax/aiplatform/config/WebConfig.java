package com.skax.aiplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 설정
 * 
 * <p>Spring MVC 관련 설정을 담당합니다.
 * 인터셉터, CORS, 정적 리소스 등의 설정을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 인터셉터 등록
     * 
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO: 필요한 인터셉터 추가 (로깅, 인증 등)
        // registry.addInterceptor(new LoggingInterceptor())
        //         .addPathPatterns("/**")
        //         .excludePathPatterns("/health", "/actuator/**");
    }

    /**
     * CORS 설정 (추가적인 CORS 설정이 필요한 경우)
     * 주요 CORS 설정은 SecurityConfig에서 처리됨
     * 
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
