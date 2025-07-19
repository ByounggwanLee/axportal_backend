package com.skax.aiportal.client.sktai.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skax.aiportal.client.sktai.data.dto.request.GenerationCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.GenerationResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * SKT AI 데이터 생성 API 클라이언트
 * 
 * <p>SKT AI 플랫폼의 데이터 생성 API를 호출합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "SKT AI 데이터 생성 API", description = "SKT AI 플랫폼 데이터 생성 서비스 연동")
@FeignClient(
    name = "sktAiGenerationClient",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiGenerationClient {

    /**
     * 데이터 생성 작업 목록 조회
     * 
     * @return 생성 작업 목록 응답
     */
    @Operation(summary = "데이터 생성 목록 조회", description = "모든 데이터 생성 작업을 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성 목록 조회 성공")
    })
    @GetMapping("/api/v1/generations")
    Object getGenerations();

    /**
     * 데이터 생성 작업 생성
     * 
     * @param createRequest 생성 작업 생성 요청
     * @return 생성된 작업 정보
     */
    @Operation(summary = "데이터 생성 작업 생성", description = "새로운 데이터 생성 작업을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "생성 작업 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/generations")
    GenerationResponse createGeneration(@RequestBody GenerationCreateRequest createRequest);

    /**
     * 특정 데이터 생성 작업 조회
     * 
     * @param generationId 생성 작업 ID
     * @return 생성 작업 상세 정보
     */
    @Operation(summary = "데이터 생성 작업 조회", description = "생성 작업 ID로 특정 생성 작업 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성 작업 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/generations/{generation_id}")
    GenerationResponse getGenerationById(
            @Parameter(description = "생성 작업 ID", required = true)
            @PathVariable("generation_id") String generationId
    );

    /**
     * 데이터 생성 작업 수정
     * 
     * @param generationId 생성 작업 ID
     * @param updateRequest 생성 작업 수정 요청
     * @return 수정된 생성 작업 정보
     */
    @Operation(summary = "데이터 생성 작업 수정", description = "생성 작업 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성 작업 수정 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/generations/{generation_id}")
    Object updateGeneration(
            @Parameter(description = "생성 작업 ID", required = true)
            @PathVariable("generation_id") String generationId,
            
            @RequestBody Object updateRequest
    );

    /**
     * 데이터 생성 작업 삭제
     * 
     * @param generationId 생성 작업 ID
     */
    @Operation(summary = "데이터 생성 작업 삭제", description = "데이터 생성 작업을 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "생성 작업 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/generations/{generation_id}")
    void deleteGeneration(
            @Parameter(description = "생성 작업 ID", required = true)
            @PathVariable("generation_id") String generationId
    );
}
