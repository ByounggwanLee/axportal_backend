package com.skax.aiportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Spring Boot 애플리케이션 테스트
 * 
 * <p>애플리케이션 컨텍스트 로딩 테스트</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@SpringBootTest
@ActiveProfiles("test")
class AiPortalApplicationTests {

    /**
     * 애플리케이션 컨텍스트 로딩 테스트
     */
    @Test
    void contextLoads() {
        // Spring Boot 애플리케이션이 정상적으로 시작되는지 확인
    }
}
