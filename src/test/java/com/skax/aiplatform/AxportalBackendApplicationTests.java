package com.skax.aiplatform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 애플리케이션 컨텍스트 로딩 테스트
 * 
 * <p>Spring Boot 애플리케이션이 정상적으로 시작되는지 확인하는 기본 테스트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@SpringBootTest
@ActiveProfiles("local")
class AxportalBackendApplicationTests {

    /**
     * 애플리케이션 컨텍스트가 정상적으로 로딩되는지 테스트
     */
    @Test
    void contextLoads() {
        // Spring 컨텍스트가 정상적으로 로딩되면 테스트 통과
    }

}
