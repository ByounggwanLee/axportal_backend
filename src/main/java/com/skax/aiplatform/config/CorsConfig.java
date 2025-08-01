package com.skax.aiplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * CORS(Cross-Origin Resource Sharing) 설정
 * 
 * <p>웹 애플리케이션에서 다른 도메인의 리소스에 접근할 수 있도록 
 * CORS 정책을 설정합니다. 개발 환경에서는 더 유연한 설정을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${cors.allowed-origins:*}")
    private String[] allowedOrigins;

    @Value("${cors.allowed-methods:GET,POST,PUT,PATCH,DELETE,OPTIONS,HEAD}")
    private String[] allowedMethods;

    @Value("${cors.allowed-headers:*}")
    private String[] allowedHeaders;

    @Value("${cors.exposed-headers:Authorization,Content-Type,X-Total-Count}")
    private String[] exposedHeaders;

    @Value("${cors.allow-credentials:true}")
    private boolean allowCredentials;

    @Value("${cors.max-age:86400}")
    private long maxAge;

    /**
     * WebMvcConfigurer를 통한 CORS 설정
     * 
     * @param registry CORS 레지스트리
     */
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(allowedOrigins)
                .allowedMethods(allowedMethods)
                .allowedHeaders(allowedHeaders)
                .exposedHeaders(exposedHeaders)
                .allowCredentials(allowCredentials)
                .maxAge(maxAge);
    }

    /**
     * 전역 CORS 설정 (Spring Security와 통합)
     * 
     * @return CorsConfigurationSource
     */
    @Bean("globalCorsConfigurationSource")
    public CorsConfigurationSource globalCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // 개발 환경에서 모든 오리진 허용
        configuration.setAllowedOriginPatterns(Arrays.asList(allowedOrigins));
        
        // 모든 HTTP 메서드 허용
        configuration.setAllowedMethods(Arrays.asList(allowedMethods));
        
        // 모든 헤더 허용
        configuration.setAllowedHeaders(Arrays.asList(allowedHeaders));
        
        // 노출할 헤더 설정
        configuration.setExposedHeaders(Arrays.asList(exposedHeaders));
        
        // 자격 증명 허용
        configuration.setAllowCredentials(allowCredentials);
        
        // 프리플라이트 캐시 시간
        configuration.setMaxAge(maxAge);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }

    /**
     * 개발 환경용 관대한 CORS 설정
     * 
     * @return CorsConfigurationSource
     */
    @Bean("developmentCorsConfigurationSource")
    @Primary
    public CorsConfigurationSource developmentCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // 개발 환경에서 모든 오리진 허용
        configuration.setAllowedOriginPatterns(List.of("*"));
        
        // 모든 HTTP 메서드 허용
        configuration.setAllowedMethods(List.of("*"));
        
        // 모든 헤더 허용
        configuration.setAllowedHeaders(List.of("*"));
        
        // 일반적인 헤더들 노출
        configuration.setExposedHeaders(List.of(
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials",
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Methods",
                "Access-Control-Max-Age",
                "Authorization",
                "Content-Type",
                "X-Requested-With",
                "X-Total-Count",
                "X-Page-Count",
                "X-User-Id",
                "X-Trace-Id"
        ));
        
        // 자격 증명 허용
        configuration.setAllowCredentials(true);
        
        // 프리플라이트 캐시 시간 (개발 환경에서는 길게 설정)
        configuration.setMaxAge(86400L); // 24시간

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }
}
