package com.skax.aiplatform.controller.common;

import com.skax.aiplatform.common.response.AxResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * CORS 테스트 컨트롤러
 * 
 * <p>CORS 설정이 제대로 작동하는지 테스트하기 위한 컨트롤러입니다.
 * 다양한 HTTP 메서드와 헤더를 테스트할 수 있는 엔드포인트를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/cors")
@Tag(name = "CORS Test", description = "CORS 설정 테스트 API")
public class CorsTestController {

    /**
     * CORS GET 테스트
     * 
     * @return CORS 테스트 결과
     */
    @GetMapping("/test")
    @Operation(summary = "CORS GET 테스트", description = "GET 메서드 CORS 테스트")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "CORS 테스트 성공"),
            @ApiResponse(responseCode = "403", description = "CORS 정책 위반")
    })
    public ResponseEntity<AxResponse<Map<String, Object>>> testGet() {
        log.info("CORS GET 테스트 요청");

        Map<String, Object> testData = Map.of(
                "method", "GET",
                "message", "CORS GET 테스트 성공",
                "timestamp", LocalDateTime.now(),
                "headers", "모든 헤더 허용됨"
        );

        return ResponseEntity.ok(AxResponse.success(testData, "CORS GET 테스트 성공"));
    }

    /**
     * CORS POST 테스트
     * 
     * @param request 요청 데이터
     * @return CORS 테스트 결과
     */
    @PostMapping("/test")
    @Operation(summary = "CORS POST 테스트", description = "POST 메서드 CORS 테스트")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "CORS 테스트 성공"),
            @ApiResponse(responseCode = "403", description = "CORS 정책 위반")
    })
    public ResponseEntity<AxResponse<Map<String, Object>>> testPost(@RequestBody Map<String, Object> request) {
        log.info("CORS POST 테스트 요청: {}", request);

        Map<String, Object> testData = Map.of(
                "method", "POST",
                "message", "CORS POST 테스트 성공",
                "timestamp", LocalDateTime.now(),
                "receivedData", request,
                "headers", "모든 헤더 허용됨"
        );

        return ResponseEntity.ok(AxResponse.success(testData, "CORS POST 테스트 성공"));
    }

    /**
     * CORS PUT 테스트
     * 
     * @param request 요청 데이터
     * @return CORS 테스트 결과
     */
    @PutMapping("/test")
    @Operation(summary = "CORS PUT 테스트", description = "PUT 메서드 CORS 테스트")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "CORS 테스트 성공"),
            @ApiResponse(responseCode = "403", description = "CORS 정책 위반")
    })
    public ResponseEntity<AxResponse<Map<String, Object>>> testPut(@RequestBody Map<String, Object> request) {
        log.info("CORS PUT 테스트 요청: {}", request);

        Map<String, Object> testData = Map.of(
                "method", "PUT",
                "message", "CORS PUT 테스트 성공",
                "timestamp", LocalDateTime.now(),
                "receivedData", request
        );

        return ResponseEntity.ok(AxResponse.success(testData, "CORS PUT 테스트 성공"));
    }

    /**
     * CORS DELETE 테스트
     * 
     * @return CORS 테스트 결과
     */
    @DeleteMapping("/test")
    @Operation(summary = "CORS DELETE 테스트", description = "DELETE 메서드 CORS 테스트")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "CORS 테스트 성공"),
            @ApiResponse(responseCode = "403", description = "CORS 정책 위반")
    })
    public ResponseEntity<AxResponse<Map<String, Object>>> testDelete() {
        log.info("CORS DELETE 테스트 요청");

        Map<String, Object> testData = Map.of(
                "method", "DELETE",
                "message", "CORS DELETE 테스트 성공",
                "timestamp", LocalDateTime.now()
        );

        return ResponseEntity.ok(AxResponse.success(testData, "CORS DELETE 테스트 성공"));
    }

    /**
     * CORS 커스텀 헤더 테스트
     * 
     * @param customHeader 커스텀 헤더 값
     * @param anotherHeader 또 다른 커스텀 헤더 값
     * @return CORS 테스트 결과
     */
    @GetMapping("/headers")
    @Operation(summary = "CORS 커스텀 헤더 테스트", description = "커스텀 헤더 CORS 테스트")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "CORS 헤더 테스트 성공"),
            @ApiResponse(responseCode = "403", description = "CORS 정책 위반")
    })
    public ResponseEntity<AxResponse<Map<String, Object>>> testHeaders(
            @RequestHeader(value = "X-Custom-Header", required = false) String customHeader,
            @RequestHeader(value = "X-Another-Header", required = false) String anotherHeader) {
        
        log.info("CORS 헤더 테스트 요청 - X-Custom-Header: {}, X-Another-Header: {}", 
                customHeader, anotherHeader);

        Map<String, Object> testData = Map.of(
                "method", "GET",
                "message", "CORS 커스텀 헤더 테스트 성공",
                "timestamp", LocalDateTime.now(),
                "customHeader", customHeader != null ? customHeader : "없음",
                "anotherHeader", anotherHeader != null ? anotherHeader : "없음"
        );

        return ResponseEntity.ok()
                .header("X-Response-Header", "CORS 테스트 응답 헤더")
                .header("X-User-Id", "test-user-123")
                .body(AxResponse.success(testData, "CORS 커스텀 헤더 테스트 성공"));
    }

    /**
     * CORS Preflight 테스트용 OPTIONS 핸들러
     * 
     * @return 빈 응답 (브라우저가 자동으로 처리)
     */
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    @Operation(summary = "CORS Preflight", description = "CORS Preflight 요청 처리")
    public ResponseEntity<Void> handlePreflight() {
        log.info("CORS Preflight 요청 처리");
        return ResponseEntity.ok().build();
    }
}
