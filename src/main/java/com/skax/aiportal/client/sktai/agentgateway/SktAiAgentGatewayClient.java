package com.skax.aiportal.client.sktai.agentgateway;

import com.skax.aiportal.client.sktai.agentgateway.dto.request.AgentGatewayCreateRequest;
import com.skax.aiportal.client.sktai.agentgateway.dto.request.AgentGatewayUpdateRequest;
import com.skax.aiportal.client.sktai.agentgateway.dto.response.AgentGatewayResponse;
import com.skax.aiportal.client.sktai.agentgateway.dto.response.AgentGatewayListResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI Agent Gateway API - 에이전트 게이트웨이 관리 Feign 클라이언트
 * 에이전트 게이트웨이 생성, 조회, 수정, 삭제 및 관리 기능
 */
@FeignClient(
    name = "skt-ai-agent-gateway",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiAgentGatewayClient {

    /**
     * 에이전트 게이트웨이 생성
     */
    @PostMapping("/api/v1/agent-gateway")
    AgentGatewayResponse createAgentGateway(@RequestBody AgentGatewayCreateRequest request);

    /**
     * 에이전트 게이트웨이 목록 조회
     */
    @GetMapping("/api/v1/agent-gateway")
    AgentGatewayListResponse getAgentGateways(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String gatewayType,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String sort
    );

    /**
     * 에이전트 게이트웨이 상세 조회
     */
    @GetMapping("/api/v1/agent-gateway/{gatewayId}")
    AgentGatewayResponse getAgentGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 에이전트 게이트웨이 수정
     */
    @PutMapping("/api/v1/agent-gateway/{gatewayId}")
    AgentGatewayResponse updateAgentGateway(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody AgentGatewayUpdateRequest request
    );

    /**
     * 에이전트 게이트웨이 삭제
     */
    @DeleteMapping("/api/v1/agent-gateway/{gatewayId}")
    void deleteAgentGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 에이전트 게이트웨이 시작
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/start")
    AgentGatewayResponse startGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 에이전트 게이트웨이 중지
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/stop")
    AgentGatewayResponse stopGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 에이전트 게이트웨이 재시작
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/restart")
    AgentGatewayResponse restartGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 에이전트 게이트웨이 활성화/비활성화
     */
    @PostMapping("/api/v1/agent-gateway/{gatewayId}/toggle")
    AgentGatewayResponse toggleGateway(@PathVariable("gatewayId") String gatewayId);
}
