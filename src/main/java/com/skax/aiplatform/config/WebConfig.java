package com.skax.aiplatform.config;

import com.skax.aiplatform.common.filter.RequestTraceFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
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
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final RequestTraceFilter requestTraceFilter;

    /**
     * 요청 추적 필터 등록
     * 
     * @return 필터 등록 빈
     */
    @Bean
    public FilterRegistrationBean<RequestTraceFilter> requestTraceFilterRegistration() {
        FilterRegistrationBean<RequestTraceFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(requestTraceFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registration.setName("requestTraceFilter");
        return registration;
    }

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
     * CORS 설정
     * 
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders("X-Trace-Id", "X-Span-Id")
                .maxAge(3600);
    }
}
