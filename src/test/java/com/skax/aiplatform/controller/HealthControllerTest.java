package com.skax.aiplatform.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * HealthController 단위 테스트
 * 
 * <p>헬스 체크 컨트롤러의 동작을 검증하는 테스트 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@WebMvcTest(HealthController.class)
@ActiveProfiles("local")
@DisplayName("HealthController 테스트")
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("헬스 체크 - 성공")
    void health_Success() throws Exception {
        // when & then
        mockMvc.perform(get("/health"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("애플리케이션이 정상 작동 중입니다"))
                .andExpect(jsonPath("$.data.status").value("UP"))
                .andExpect(jsonPath("$.data.application.name").exists())
                .andExpect(jsonPath("$.data.application.version").exists())
                .andExpect(jsonPath("$.data.server.javaVersion").exists())
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    @DisplayName("시스템 정보 조회 - 성공")
    void info_Success() throws Exception {
        // when & then
        mockMvc.perform(get("/info"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("시스템 정보 조회 완료"))
                .andExpect(jsonPath("$.data.application.name").exists())
                .andExpect(jsonPath("$.data.system.javaVersion").exists())
                .andExpect(jsonPath("$.data.memory.total").exists())
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
