package com.skax.aiportal.controller;

import com.skax.aiportal.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 헬스체크 컨트롤러
 * 
 * <p>애플리케이션의 상태를 확인하기 위한 API를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
@Tag(name = "Health Check", description = "헬스체크 API")
public class HealthController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    /**
     * 간단한 헬스체크
     * 
     * @return 상태 응답
     */
    @GetMapping
    @Operation(summary = "헬스체크", description = "애플리케이션의 기본 상태를 확인합니다.")
    public ResponseEntity<ApiResponse<String>> health() {
        log.debug("Health check requested");
        return ResponseEntity.ok(ApiResponse.success("UP", "애플리케이션이 정상적으로 동작 중입니다."));
    }

    /**
     * 상세 헬스체크
     * 
     * @return 상세 상태 응답
     */
    @GetMapping("/info")
    @Operation(summary = "상세 헬스체크", description = "애플리케이션의 상세 정보를 포함한 상태를 확인합니다.")
    public ResponseEntity<ApiResponse<Map<String, Object>>> healthInfo() {
        log.debug("Detailed health check requested");
        
        Map<String, Object> info = new HashMap<>();
        info.put("application", applicationName);
        info.put("status", "UP");
        info.put("profile", activeProfile);
        info.put("timestamp", LocalDateTime.now());
        info.put("version", "1.0.0");
        
        return ResponseEntity.ok(ApiResponse.success(info, "애플리케이션 상세 정보"));
    }
}
