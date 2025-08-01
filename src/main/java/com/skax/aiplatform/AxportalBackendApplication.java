package com.skax.aiplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * AxportalBackend 메인 애플리케이션 클래스
 * 
 * <p>Spring Boot 기반의 AI Portal RESTful API 서버입니다.
 * JWT 인증, 다중 데이터베이스 지원, OpenFeign 클라이언트 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class AxportalBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxportalBackendApplication.class, args);
    }

}
