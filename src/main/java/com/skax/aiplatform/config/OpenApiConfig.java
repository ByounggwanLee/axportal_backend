package com.skax.aiplatform.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI 3 문서화 설정
 * 
 * <p>Swagger UI를 통한 API 문서화 설정을 담당합니다.
 * JWT 인증 스키마와 프로젝트 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Configuration
public class OpenApiConfig {

    @Value("${app.name:AxportalBackend}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @Value("${app.description:Spring Boot 기반의 AI Portal RESTful API}")
    private String appDescription;

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    /**
     * OpenAPI 설정 빈
     * 
     * @return OpenAPI 설정 객체
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(getApiInfo())
                .servers(getServers())
                .addSecurityItem(getSecurityRequirement())
                .components(getComponents());
    }

    /**
     * API 정보 설정
     * 
     * @return API 정보 객체
     */
    private Info getApiInfo() {
        return new Info()
                .title(appName + " API")
                .description(appDescription)
                .version(appVersion)
                .contact(new Contact()
                        .name("ByounggwanLee")
                        .email("developer@skax.com")
                        .url("https://github.com/byounggwanlee"))
                .license(new License()
                        .name("MIT License")
                        .url("https://opensource.org/licenses/MIT"));
    }

    /**
     * 서버 정보 설정
     * 
     * @return 서버 정보 리스트
     */
    private List<Server> getServers() {
        String baseUrl = "http://localhost:" + serverPort;
        if (contextPath != null && !contextPath.isEmpty()) {
            baseUrl += contextPath;
        }
        
        return List.of(
                new Server()
                        .url(baseUrl)
                        .description("로컬 개발 서버"),
                new Server()
                        .url("https://api-dev.skax.com" + (contextPath != null ? contextPath : ""))
                        .description("개발 서버"),
                new Server()
                        .url("https://api-staging.skax.com" + (contextPath != null ? contextPath : ""))
                        .description("스테이징 서버"),
                new Server()
                        .url("https://api.skax.com" + (contextPath != null ? contextPath : ""))
                        .description("운영 서버")
        );
    }

    /**
     * 보안 요구사항 설정
     * 
     * @return 보안 요구사항 객체
     */
    private SecurityRequirement getSecurityRequirement() {
        return new SecurityRequirement().addList("Bearer Authentication");
    }

    /**
     * 컴포넌트 설정 (보안 스키마 포함)
     * 
     * @return 컴포넌트 객체
     */
    private Components getComponents() {
        return new Components()
                .addSecuritySchemes("Bearer Authentication", 
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("JWT 토큰을 입력하세요 (Bearer 접두사 제외)")
                );
    }
}
