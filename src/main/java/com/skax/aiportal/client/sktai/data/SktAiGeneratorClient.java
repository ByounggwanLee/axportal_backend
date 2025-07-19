package com.skax.aiportal.client.sktai.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skax.aiportal.client.sktai.data.dto.request.GeneratorCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.GeneratorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * SKT AI 데이터 생성기 API 클라이언트
 * 
 * <p>SKT AI 플랫폼의 데이터 생성기 API를 호출합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "SKT AI 데이터 생성기 API", description = "SKT AI 플랫폼 데이터 생성기 서비스 연동")
@FeignClient(
    name = "sktAiGeneratorClient",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiGeneratorClient {

    /**
     * 데이터 생성기 목록 조회
     * 
     * @return 생성기 목록 응답
     */
    @Operation(summary = "데이터 생성기 목록 조회", description = "모든 데이터 생성기를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성기 목록 조회 성공")
    })
    @GetMapping("/api/v1/generators")
    Object getGenerators();

    /**
     * 데이터 생성기 생성
     * 
     * @param createRequest 생성기 생성 요청
     * @return 생성된 생성기 정보
     */
    @Operation(summary = "데이터 생성기 생성", description = "새로운 데이터 생성기를 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "생성기 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/generators")
    GeneratorResponse createGenerator(@RequestBody GeneratorCreateRequest createRequest);

    /**
     * 특정 데이터 생성기 조회
     * 
     * @param generatorId 생성기 ID
     * @return 생성기 상세 정보
     */
    @Operation(summary = "데이터 생성기 조회", description = "생성기 ID로 특정 생성기 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성기 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/generators/{generator_id}")
    GeneratorResponse getGeneratorById(
            @Parameter(description = "생성기 ID", required = true)
            @PathVariable("generator_id") String generatorId
    );

    /**
     * 데이터 생성기 수정
     * 
     * @param generatorId 생성기 ID
     * @param updateRequest 생성기 수정 요청
     * @return 수정된 생성기 정보
     */
    @Operation(summary = "데이터 생성기 수정", description = "생성기 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "생성기 수정 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/generators/{generator_id}")
    Object updateGenerator(
            @Parameter(description = "생성기 ID", required = true)
            @PathVariable("generator_id") String generatorId,
            
            @RequestBody Object updateRequest
    );

    /**
     * 데이터 생성기 삭제
     * 
     * @param generatorId 생성기 ID
     */
    @Operation(summary = "데이터 생성기 삭제", description = "데이터 생성기를 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "생성기 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/generators/{generator_id}")
    void deleteGenerator(
            @Parameter(description = "생성기 ID", required = true)
            @PathVariable("generator_id") String generatorId
    );
}
