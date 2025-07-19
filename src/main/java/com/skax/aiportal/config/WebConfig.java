package com.skax.aiportal.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 설정 클래스
 * 
 * <p>Spring MVC의 전반적인 설정을 담당합니다.
 * JSON 직렬화/역직렬화, CORS 등의 설정을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
@Tag(name = "웹 설정", description = "Spring MVC 웹 설정 관리")
public class WebConfig implements WebMvcConfigurer {

    /**
     * CORS 매핑을 설정합니다.
     * 
     * @param registry CORS 레지스트리
     */
    @Override
    @Operation(summary = "CORS 매핑 설정", description = "Cross-Origin Resource Sharing 매핑을 설정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "CORS 매핑 설정 성공")
    })
    public void addCorsMappings(CorsRegistry registry) {
        log.info("CORS 매핑 설정 시작");
        
        log.debug("모든 경로(/**)에 대한 CORS 매핑 추가 중");
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
        
        log.info("CORS 매핑 설정 완료");
        log.debug("CORS 설정 상세:");
        log.debug("  - 경로: /**");
        log.debug("  - 허용 오리진: *");
        log.debug("  - 허용 메서드: GET, POST, PUT, DELETE, PATCH, OPTIONS");
        log.debug("  - 허용 헤더: *");
        log.debug("  - 인증 정보 포함: true");
        log.debug("  - 캐시 시간: 3600초");
    }

    /**
     * Jackson ObjectMapper를 설정합니다.
     * 
     * @param builder Jackson2ObjectMapperBuilder
     * @return ObjectMapper
     */
    @Bean
    @Primary
    @Operation(summary = "Jackson ObjectMapper 설정", description = "JSON 직렬화/역직렬화를 위한 ObjectMapper를 설정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "ObjectMapper 설정 성공")
    })
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        log.info("Jackson ObjectMapper 설정 시작");
        
        log.debug("JavaTimeModule 추가 중 - Java 8 시간 API 지원");
        log.debug("날짜 형식 설정 중: yyyy-MM-dd HH:mm:ss");
        
        ObjectMapper mapper = builder
                .modules(new JavaTimeModule())
                .simpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .build();
        
        log.info("Jackson ObjectMapper 설정 완료");
        log.debug("ObjectMapper 설정 상세:");
        log.debug("  - JavaTimeModule: 활성화");
        log.debug("  - 날짜 형식: yyyy-MM-dd HH:mm:ss");
        log.debug("  - 등록된 모듈 수: {}", mapper.getRegisteredModuleIds().size());
        log.debug("  - 등록된 모듈: {}", mapper.getRegisteredModuleIds());
        
        return mapper;
    }
}
