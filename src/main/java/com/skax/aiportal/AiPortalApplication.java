package com.skax.aiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * AXPORTAL BACKEND 메인 애플리케이션 클래스
 * 
 * <p>Spring Boot 애플리케이션의 진입점입니다.
 * JPA Auditing과 OpenFeign을 활성화합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class AiPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiPortalApplication.class, args);
    }
}
