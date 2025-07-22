package com.skax.aiportal.client.sktai.agentgateway;

import com.skax.aiportal.client.sktai.agentgateway.dto.request.AgentGatewayExecuteRequest;
import com.skax.aiportal.client.sktai.agentgateway.dto.response.AgentGatewayExecuteResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Agent Gateway API - 에이전트 게이트웨이 실행 Feign 클라이언트
 * 에이전트 게이트웨이를 통한 에이전트 실행 및 대화 관리 기능
 */
@FeignClient(
    name = "skt-ai-agent-gateway-execute",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiAgentGatewayExecuteClient {

    /**
     * 에이전트 게이트웨이를 통한 에이전트 실행
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/execute")
    AgentGatewayExecuteResponse executeAgent(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody AgentGatewayExecuteRequest request
    );

    /**
     * 에이전트 게이트웨이를 통한 스트리밍 실행
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/execute-stream")
    AgentGatewayExecuteResponse executeAgentStream(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody AgentGatewayExecuteRequest request
    );

    /**
     * 에이전트 게이트웨이를 통한 비동기 실행
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/execute-async")
    AgentGatewayExecuteResponse executeAgentAsync(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody AgentGatewayExecuteRequest request
    );

    /**
     * 비동기 실행 결과 조회
     */
    @GetMapping("/api/v1/agent-gateway/execute/{executionId}")
    AgentGatewayExecuteResponse getExecutionResult(@PathVariable("executionId") String executionId);

    /**
     * 대화 세션 종료
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/conversations/{conversationId}/close")
    void closeConversation(
        @PathVariable("gatewayId") String gatewayId,
        @PathVariable("conversationId") String conversationId
    );

    /**
     * 대화 히스토리 조회
     */
    @GetMapping("/api/v1/agent-gateway/{gatewayId}/conversations/{conversationId}/history")
    List<AgentGatewayExecuteResponse> getConversationHistory(
        @PathVariable("gatewayId") String gatewayId,
        @PathVariable("conversationId") String conversationId,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    );

    /**
     * 실행 히스토리 조회
     */
    @GetMapping("/api/v1/agent-gateway/{gatewayId}/execute-history")
    List<AgentGatewayExecuteResponse> getExecuteHistory(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String userId
    );

    /**
     * 활성 세션 조회
     */
    @GetMapping("/api/v1/agent-gateway/{gatewayId}/active-sessions")
    Object getActiveSessions(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) String userId
    );
}
