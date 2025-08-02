package com.skax.aiplatform.client.sktax.history;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.history.dto.response.AgentHistoryRes;
import com.skax.aiplatform.client.sktax.history.dto.response.AgentStatsRes;
import com.skax.aiplatform.client.sktax.history.dto.response.DocIntelligenceStatsRes;
import com.skax.aiplatform.client.sktax.history.dto.response.ModelHistoryRes;
import com.skax.aiplatform.client.sktax.history.dto.response.ModelStatsRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * History Management API Feign Client
 * 
 * <p>SKTAX History Management 서비스와의 통신을 위한 Feign Client 인터페이스입니다.
 * 모델 및 에이전트 사용 히스토리 조회, 통계 조회 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "history-management-client",
    url = "${sktax.history.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
@Tag(name = "History Management", description = "히스토리 관리 API")
public interface HistoryManagementClient {

    /**
     * 모델 사용 히스토리 조회
     * 
     * @param fields 응답에 포함할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param page 페이지 번호
     * @param size 페이지당 아이템 수
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @param sort 정렬 조건 (field,order 형식)
     * @return 모델 히스토리 목록
     */
    @GetMapping("/api/v1/history/model/list")
    @Operation(summary = "모델 사용 히스토리 조회", description = "모델 사용 히스토리를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = ModelHistoryRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    ModelHistoryRes getModelHistoryList(
        @Parameter(description = "응답에 포함할 필드 목록")
        @RequestParam(required = false) String fields,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "페이지 번호", example = "1", required = true)
        @RequestParam Integer page,
        
        @Parameter(description = "페이지당 아이템 수", example = "10", required = true)
        @RequestParam Integer size,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search,
        
        @Parameter(description = "정렬 조건 (field,order)")
        @RequestParam(required = false) String sort
    );

    /**
     * 모델 통계 테스트 조회
     * 
     * @param groupBy 그룹화 및 집계할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @return 모델 통계 정보
     */
    @GetMapping("/api/v1/history/model/stats/test")
    @Operation(summary = "모델 통계 테스트 조회", description = "모델 사용 통계 테스트를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = ModelStatsRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    ModelStatsRes getModelStatsTest(
        @Parameter(description = "그룹화 및 집계할 필드 목록", 
                  example = "project_id,app_id,model_type,model_id,model_serving_id,agent_app_serving_id,api_key,company,department,user", 
                  required = true)
        @RequestParam("group_by") String groupBy,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search
    );

    /**
     * 모델 통계 조회
     * 
     * @param groupBy 그룹화 및 집계할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @return 모델 통계 정보
     */
    @GetMapping("/api/v1/history/model/stats")
    @Operation(summary = "모델 통계 조회", description = "모델 사용 통계를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = ModelStatsRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    ModelStatsRes getModelStats(
        @Parameter(description = "그룹화 및 집계할 필드 목록", 
                  example = "project_id,app_id,model_type,model_id,model_serving_id,agent_app_serving_id,api_key,company,department,user", 
                  required = true)
        @RequestParam("group_by") String groupBy,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search
    );

    /**
     * 에이전트 사용 히스토리 조회
     * 
     * @param fields 응답에 포함할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param page 페이지 번호
     * @param size 페이지당 아이템 수
     * @param includeModelGateway 모델 게이트웨이 히스토리 포함 여부
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @param sort 정렬 조건 (field,order 형식)
     * @return 에이전트 히스토리 목록
     */
    @GetMapping("/api/v1/history/agent/list")
    @Operation(summary = "에이전트 사용 히스토리 조회", description = "에이전트 사용 히스토리를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = AgentHistoryRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    AgentHistoryRes getAgentHistoryList(
        @Parameter(description = "응답에 포함할 필드 목록")
        @RequestParam(required = false) String fields,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "페이지 번호", example = "1", required = true)
        @RequestParam Integer page,
        
        @Parameter(description = "페이지당 아이템 수", example = "10", required = true)
        @RequestParam Integer size,
        
        @Parameter(description = "모델 게이트웨이 히스토리 포함 여부", example = "false")
        @RequestParam(value = "include_model_gateway", required = false, defaultValue = "false") Boolean includeModelGateway,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search,
        
        @Parameter(description = "정렬 조건 (field,order)")
        @RequestParam(required = false) String sort
    );

    /**
     * 에이전트 통계 테스트 조회
     * 
     * @param groupBy 그룹화 및 집계할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @return 에이전트 통계 정보
     */
    @GetMapping("/api/v1/history/agent/stats/test")
    @Operation(summary = "에이전트 통계 테스트 조회", description = "에이전트 사용 통계 테스트를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = AgentStatsRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    AgentStatsRes getAgentStatsTest(
        @Parameter(description = "그룹화 및 집계할 필드 목록", 
                  example = "project_id,app_id,agent_app_id,agent_app_version,agent_app_serving_id,serving_type,api_key,company,department,user", 
                  required = true)
        @RequestParam("group_by") String groupBy,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search
    );

    /**
     * 에이전트 통계 조회
     * 
     * @param groupBy 그룹화 및 집계할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @return 에이전트 통계 정보
     */
    @GetMapping("/api/v1/history/agent/stats")
    @Operation(summary = "에이전트 통계 조회", description = "에이전트 사용 통계를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = AgentStatsRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    AgentStatsRes getAgentStats(
        @Parameter(description = "그룹화 및 집계할 필드 목록", 
                  example = "project_id,app_id,agent_app_id,agent_app_version,agent_app_serving_id,serving_type,api_key,company,department,user", 
                  required = true)
        @RequestParam("group_by") String groupBy,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "2025-03-01", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "2025-03-03", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search
    );

    /**
     * 문서 인텔리전스 통계 조회
     * 
     * @param groupBy 그룹화 및 집계할 필드 목록 (콤마로 구분)
     * @param fromDate 조회 시작 날짜 (YYYY-MM-DD 형식)
     * @param toDate 조회 종료 날짜 (YYYY-MM-DD 형식)
     * @param filter 필터 조건 (key:value,... 형식)
     * @param search 검색 조건 (key:*value*,... 형식)
     * @return 문서 인텔리전스 통계 정보
     */
    @GetMapping("/api/v1/history/doc-intelligence/stats")
    @Operation(summary = "문서 인텔리전스 통계 조회", description = "문서 인텔리전스 사용 통계를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = DocIntelligenceStatsRes.class))),
        @ApiResponse(responseCode = "422", description = "입력값 검증 오류")
    })
    DocIntelligenceStatsRes getDocIntelligenceStats(
        @Parameter(description = "그룹화 및 집계할 필드 목록", 
                  example = "project_id,tool_id,model_type,user")
        @RequestParam(value = "group_by", required = false, defaultValue = "project_id,tool_id,model_type,user") String groupBy,
        
        @Parameter(description = "조회 시작 날짜 (YYYY-MM-DD)", example = "yyyy-mm-dd", required = true)
        @RequestParam("from_date") String fromDate,
        
        @Parameter(description = "조회 종료 날짜 (YYYY-MM-DD)", example = "yyyy-mm-dd", required = true)
        @RequestParam("to_date") String toDate,
        
        @Parameter(description = "필터 조건 (key:value,...)")
        @RequestParam(required = false) String filter,
        
        @Parameter(description = "검색 조건 (key:*value*,...)")
        @RequestParam(required = false) String search
    );
}
