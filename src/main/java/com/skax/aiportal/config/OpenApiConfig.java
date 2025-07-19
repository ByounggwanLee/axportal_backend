package com.skax.aiportal.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI 3 설정 클래스
 * 
 * <p>Swagger UI를 통한 API 문서화를 위한 설정을 담당합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${server.servlet.context-path:/api}")
    private String contextPath;

    /**
     * OpenAPI 설정을 정의합니다.
     * 
     * @return OpenAPI 설정 객체
     */
    @Bean
    public OpenAPI customOpenAPI() {
        log.info("OpenAPI 설정 시작");
        
        log.debug("서버 포트: {}, 컨텍스트 경로: {}", serverPort, contextPath);
        
        List<Server> servers = List.of(
                new Server()
                        .url("http://localhost:" + serverPort + contextPath)
                        .description("개발 서버"),
                new Server()
                        .url("https://api.axportal.com" + contextPath)
                        .description("운영 서버")
        );
        
        log.debug("설정된 서버 목록:");
        servers.forEach(server -> 
                log.debug("  - {}: {}", server.getDescription(), server.getUrl()));
        
        OpenAPI openAPI = new OpenAPI()
                .info(apiInfo())
                .servers(servers);
        
        log.info("OpenAPI 설정 완료");
        return openAPI;
    }

    /**
     * API 정보를 설정합니다.
     * 
     * @return API 정보 객체
     */
    private Info apiInfo() {
        log.debug("API 정보 설정 시작");
        
        Contact contact = new Contact()
                .name("ByounggwanLee")
                .email("developer@axportal.com")
                .url("https://github.com/byounggwanlee");
        
        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");
        
        Info info = new Info()
                .title("AXPORTAL BACKEND API")
                .description("AI Portal 백엔드 서비스 API 문서")
                .version("1.0.0")
                .contact(contact)
                .license(license);
        
        log.debug("API 정보 설정 완료:");
        log.debug("  - 제목: {}", info.getTitle());
        log.debug("  - 설명: {}", info.getDescription());
        log.debug("  - 버전: {}", info.getVersion());
        log.debug("  - 연락처: {} ({})", contact.getName(), contact.getEmail());
        log.debug("  - 라이센스: {}", license.getName());
        
        return info;
    }
}
