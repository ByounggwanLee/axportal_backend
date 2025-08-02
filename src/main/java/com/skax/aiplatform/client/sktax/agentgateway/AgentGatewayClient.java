package com.skax.aiplatform.client.sktax.agentgateway;

import com.skax.aiplatform.client.sktax.agentgateway.dto.request.BatchRequestSchema;
import com.skax.aiplatform.client.sktax.agentgateway.dto.request.InvokeRequestSchema;
import com.skax.aiplatform.client.sktax.agentgateway.dto.request.StreamRequestSchema;
import com.skax.aiplatform.client.sktax.agentgateway.dto.response.AgentBatchResponse;
import com.skax.aiplatform.client.sktax.agentgateway.dto.response.AgentInvokeResponse;
import com.skax.aiplatform.client.sktax.agentgateway.dto.response.AgentStreamResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Agent Gateway API Feign Client
 * 
 * <p>SKTAX Agent Gateway 서비스와의 통신을 위한 Feign Client 인터페이스입니다.
 * Agent 실행, 일괄 처리, 스트리밍 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "agent-gateway-client",
    url = "${sktax.agent-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
@Tag(name = "Agent Gateway", description = "Agent Gateway API")
public interface AgentGatewayClient {

    /**
     * Agent 실행 엔드포인트
     * 
     * <p>지정된 Agent를 실행하고 결과를 반환합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @param request 실행 요청 정보
     * @return Agent 실행 결과
     */
    @PostMapping(
        value = "/api/v1/agent_gateway/{agent_id}/invoke",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 실행",
        description = "지정된 Agent를 실행하고 결과를 반환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 실행 성공",
            content = @Content(schema = @Schema(implementation = AgentInvokeResponse.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    AgentInvokeResponse invokeAgent(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath,
        
        @Parameter(description = "Agent 실행 요청 정보", required = true)
        @Valid @RequestBody InvokeRequestSchema request
    );

    /**
     * Agent 일괄 처리 엔드포인트
     * 
     * <p>지정된 Agent를 여러 입력에 대해 일괄 실행하고 결과를 반환합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @param request 일괄 처리 요청 정보
     * @return Agent 일괄 처리 결과
     */
    @PostMapping(
        value = "/api/v1/agent_gateway/{agent_id}/batch",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 일괄 처리",
        description = "지정된 Agent를 여러 입력에 대해 일괄 실행하고 결과를 반환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 일괄 처리 성공",
            content = @Content(schema = @Schema(implementation = AgentBatchResponse.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    AgentBatchResponse batchAgent(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath,
        
        @Parameter(description = "Agent 일괄 처리 요청 정보", required = true)
        @Valid @RequestBody BatchRequestSchema request
    );

    /**
     * Agent 스트리밍 엔드포인트
     * 
     * <p>지정된 Agent를 스트리밍 방식으로 실행하고 결과를 반환합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @param request 스트리밍 요청 정보
     * @return Agent 스트리밍 결과
     */
    @PostMapping(
        value = "/api/v1/agent_gateway/{agent_id}/stream",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 스트리밍",
        description = "지정된 Agent를 스트리밍 방식으로 실행하고 결과를 반환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 스트리밍 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<AgentStreamResponse> streamAgent(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath,
        
        @Parameter(description = "Agent 스트리밍 요청 정보", required = true)
        @Valid @RequestBody StreamRequestSchema request
    );

    /**
     * Agent 스트림 로그 엔드포인트
     * 
     * <p>지정된 Agent를 스트리밍 로그 방식으로 실행하고 결과를 반환합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @param request 스트리밍 요청 정보
     * @return Agent 스트림 로그 결과
     */
    @PostMapping(
        value = "/api/v1/agent_gateway/{agent_id}/stream_log",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 스트림 로그",
        description = "지정된 Agent를 스트리밍 로그 방식으로 실행하고 결과를 반환합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 스트림 로그 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<AgentStreamResponse> streamLogAgent(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath,
        
        @Parameter(description = "Agent 스트리밍 요청 정보", required = true)
        @Valid @RequestBody StreamRequestSchema request
    );

    /**
     * Agent 입력 스키마 조회 엔드포인트
     * 
     * <p>지정된 Agent의 입력 스키마 정보를 조회합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @return Agent 입력 스키마 정보
     */
    @GetMapping(
        value = "/api/v1/agent_gateway/{agent_id}/input_schema",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 입력 스키마 조회",
        description = "지정된 Agent의 입력 스키마 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 입력 스키마 조회 성공",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    Map<String, Object> getInputSchema(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath
    );

    /**
     * Agent 출력 스키마 조회 엔드포인트
     * 
     * <p>지정된 Agent의 출력 스키마 정보를 조회합니다.</p>
     * 
     * @param agentId Agent ID
     * @param routerPath 라우터 경로 (선택사항)
     * @return Agent 출력 스키마 정보
     */
    @GetMapping(
        value = "/api/v1/agent_gateway/{agent_id}/output_schema",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Agent 출력 스키마 조회",
        description = "지정된 Agent의 출력 스키마 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Agent 출력 스키마 조회 성공",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    Map<String, Object> getOutputSchema(
        @Parameter(description = "Agent ID", required = true)
        @PathVariable("agent_id") String agentId,
        
        @Parameter(description = "라우터 경로")
        @RequestParam(value = "router_path", required = false, defaultValue = "") String routerPath
    );
}
