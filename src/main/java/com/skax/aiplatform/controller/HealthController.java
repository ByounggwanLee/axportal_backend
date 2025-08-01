package com.skax.aiplatform.controller;

import com.skax.aiplatform.common.response.AxResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 헬스 체크 컨트롤러
 * 
 * <p>애플리케이션의 상태 확인과 기본 정보를 제공하는 컨트롤러입니다.
 * 로드 밸런서나 모니터링 시스템에서 사용할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Health Check", description = "헬스 체크 및 시스템 정보 API")
public class HealthController {

    @Value("${app.name:AxportalBackend}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @Value("${app.description:Spring Boot 기반의 AI Portal RESTful API}")
    private String appDescription;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    /**
     * 기본 헬스 체크
     * 
     * @return 헬스 체크 응답
     */
    @GetMapping("/health")
    @Operation(summary = "헬스 체크", description = "애플리케이션의 기본 상태를 확인합니다.")
    public ResponseEntity<AxResponse<Map<String, Object>>> health() {
        log.debug("Health check requested");

        Map<String, Object> healthInfo = Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now(),
                "application", Map.of(
                        "name", appName,
                        "version", appVersion,
                        "description", appDescription,
                        "profile", activeProfile
                ),
                "server", Map.of(
                        "timezone", System.getProperty("user.timezone"),
                        "javaVersion", System.getProperty("java.version"),
                        "osName", System.getProperty("os.name"),
                        "osVersion", System.getProperty("os.version")
                )
        );

        return ResponseEntity.ok(AxResponse.success(healthInfo, "애플리케이션이 정상 작동 중입니다"));
    }

    /**
     * 상세 시스템 정보
     * 
     * @return 시스템 정보 응답
     */
    @GetMapping("/info")
    @Operation(summary = "시스템 정보", description = "애플리케이션의 상세 정보를 제공합니다.")
    public ResponseEntity<AxResponse<Map<String, Object>>> info() {
        log.debug("System info requested");

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();

        Map<String, Object> systemInfo = Map.of(
                "application", Map.of(
                        "name", appName,
                        "version", appVersion,
                        "description", appDescription,
                        "profile", activeProfile,
                        "buildTime", "2025-08-01T00:00:00" // TODO: 빌드 시점 자동화
                ),
                "system", Map.of(
                        "javaVersion", System.getProperty("java.version"),
                        "javaVendor", System.getProperty("java.vendor"),
                        "osName", System.getProperty("os.name"),
                        "osVersion", System.getProperty("os.version"),
                        "osArch", System.getProperty("os.arch"),
                        "timezone", System.getProperty("user.timezone"),
                        "fileEncoding", System.getProperty("file.encoding")
                ),
                "memory", Map.of(
                        "total", formatBytes(totalMemory),
                        "free", formatBytes(freeMemory),
                        "used", formatBytes(usedMemory),
                        "max", formatBytes(maxMemory),
                        "usagePercent", Math.round((double) usedMemory / totalMemory * 100)
                ),
                "timestamp", LocalDateTime.now()
        );

        return ResponseEntity.ok(AxResponse.success(systemInfo, "시스템 정보 조회 완료"));
    }

    /**
     * 바이트를 읽기 쉬운 형태로 변환
     * 
     * @param bytes 바이트 수
     * @return 포맷된 문자열
     */
    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }
}
