package com.skax.aiportal.client.sktai.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.data.dto.request.ProcessorCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.ProcessorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * SKT AI 데이터 프로세서 API 클라이언트
 * 
 * <p>SKT AI 플랫폼의 데이터 프로세서 API를 호출합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "SKT AI 데이터 프로세서 API", description = "SKT AI 플랫폼 데이터 프로세서 서비스 연동")
@FeignClient(
    name = "sktAiProcessorClient",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiProcessorClient {

    /**
     * 데이터 프로세서 목록 조회
     * 
     * @param dataType 데이터 타입 필터 (dataframe, text, all)
     * @return 프로세서 목록 응답
     */
    @Operation(summary = "데이터 프로세서 목록 조회", description = "모든 데이터 프로세서를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "프로세서 목록 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/processors")
    Object getProcessors(
            @Parameter(description = "데이터 타입 필터")
            @RequestParam(value = "data_type", required = false) String dataType
    );

    /**
     * 데이터 프로세서 생성
     * 
     * @param createRequest 프로세서 생성 요청
     * @return 생성된 프로세서 정보
     */
    @Operation(summary = "데이터 프로세서 생성", description = "새로운 데이터 프로세서를 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "프로세서 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/processors")
    ProcessorResponse createProcessor(@RequestBody ProcessorCreateRequest createRequest);

    /**
     * 특정 데이터 프로세서 조회
     * 
     * @param processorId 프로세서 ID
     * @return 프로세서 상세 정보
     */
    @Operation(summary = "데이터 프로세서 조회", description = "프로세서 ID로 특정 프로세서 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "프로세서 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/processors/{processor_id}")
    ProcessorResponse getProcessorById(
            @Parameter(description = "프로세서 ID", required = true)
            @PathVariable("processor_id") String processorId
    );

    /**
     * 데이터 프로세서 수정
     * 
     * @param processorId 프로세서 ID
     * @param updateRequest 프로세서 수정 요청
     * @return 수정된 프로세서 정보
     */
    @Operation(summary = "데이터 프로세서 수정", description = "프로세서 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "프로세서 수정 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/processors/{processor_id}")
    Object updateProcessor(
            @Parameter(description = "프로세서 ID", required = true)
            @PathVariable("processor_id") String processorId,
            
            @RequestBody Object updateRequest
    );

    /**
     * 데이터 프로세서 삭제
     * 
     * @param processorId 프로세서 ID
     */
    @Operation(summary = "데이터 프로세서 삭제", description = "데이터 프로세서를 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "프로세서 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/processors/{processor_id}")
    void deleteProcessor(
            @Parameter(description = "프로세서 ID", required = true)
            @PathVariable("processor_id") String processorId
    );

    /**
     * 데이터 프로세서 실행
     * 
     * @param executeRequest 프로세서 실행 요청
     * @return 실행 결과
     */
    @Operation(summary = "데이터 프로세서 실행", description = "지정된 데이터 프로세서를 실행합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "프로세서 실행 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/processors/execute")
    Object executeProcessor(@RequestBody Object executeRequest);
}
