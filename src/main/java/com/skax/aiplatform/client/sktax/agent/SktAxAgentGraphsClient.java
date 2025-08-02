package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.agent.dto.response.GraphResponse;
import com.skax.aiplatform.client.sktax.agent.dto.request.CreateGraphFromTemplateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.TableAgentGraphRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.UpdateGraphInfoRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.QueryAgentGraphRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.TestAgentGraphRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * SKTAX Agent Graph 관리 Feign Client
 * 
 * <p>Agent Graph의 생성, 조회, 수정, 삭제, 실행을 담당하는 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-graphs", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentGraphsClient {

    /**
     * Agent Graph 템플릿 목록 조회
     */
    @GetMapping("/agents/graphs/templates")
    CommonResponse getAgentGraphTemplates();

    /**
     * Agent Graph 템플릿 상세 조회
     */
    @GetMapping("/agents/graphs/templates/{templateId}")
    CommonResponse getAgentGraphTemplateById(@PathVariable("templateId") String templateId);

    /**
     * 템플릿으로부터 Agent Graph 생성
     */
    @PostMapping("/agents/graphs/templates/{templateId}")
    CommonResponse createAgentGraphFromTemplate(
        @PathVariable("templateId") String templateId,
        @Valid @RequestBody CreateGraphFromTemplateRequest request
    );

    /**
     * Agent Graph 생성
     */
    @PostMapping("/agents/graphs")
    CommonResponse createAgentGraph(@Valid @RequestBody TableAgentGraphRequest request);

    /**
     * Agent Graph 목록 조회
     */
    @GetMapping("/agents/graphs")
    CommonResponse getAgentGraphs(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Agent Graph 상세 조회
     */
    @GetMapping("/agents/graphs/{agentId}")
    CommonResponse getAgentGraph(@PathVariable("agentId") String agentId);

    /**
     * Agent Graph 수정
     */
    @PutMapping("/agents/graphs/{agentId}")
    CommonResponse updateAgentGraph(
        @PathVariable("agentId") String agentId,
        @Valid @RequestBody TableAgentGraphRequest request
    );

    /**
     * Agent Graph 삭제
     */
    @DeleteMapping("/agents/graphs/{agentId}")
    void deleteAgentGraph(@PathVariable("agentId") String agentId);

    /**
     * Agent Graph의 App ID 조회
     */
    @GetMapping("/agents/graphs/{agentId}/app")
    CommonResponse getAgentGraphAppId(@PathVariable("agentId") String agentId);

    /**
     * Agent Graph 정보 수정 (이름, 설명)
     */
    @PutMapping("/agents/graphs/{agentId}/info")
    CommonResponse updateAgentGraphInfo(
        @PathVariable("agentId") String agentId,
        @Valid @RequestBody UpdateGraphInfoRequest request
    );

    /**
     * Agent Graph 실행 (Invoke)
     */
    @PostMapping("/agents/graphs/query")
    GraphResponse queryAgentGraph(
        @RequestParam(value = "_profile_request", defaultValue = "false") Boolean profileRequest,
        @Valid @RequestBody QueryAgentGraphRequest request
    );

    /**
     * Agent Graph 스트리밍 실행
     */
    @PostMapping("/agents/graphs/stream")
    CommonResponse streamAgentGraph(
        @RequestParam(value = "_profile_request", defaultValue = "false") Boolean profileRequest,
        @Valid @RequestBody QueryAgentGraphRequest request
    );

    /**
     * Agent Graph 테스트 실행 (DB 저장 없음)
     */
    @PostMapping("/agents/graphs/test")
    GraphResponse testAgentGraph(@Valid @RequestBody TestAgentGraphRequest request);

    /**
     * Agent Graph 복사
     */
    @PostMapping("/agents/graphs/{agentId}/copy")
    CommonResponse copyAgentGraph(@PathVariable("agentId") String agentId);

    /**
     * 각 노드 정보 조회
     */
    @GetMapping("/agents/graphs/node/info")
    CommonResponse getNodeInfo(@RequestParam(value = "node_type", required = false) String nodeType);

    /**
     * 내부 사용을 위한 제한된 변수명 조회
     */
    @GetMapping("/agents/graphs/node/reserved-variables")
    CommonResponse getReservedVariables();

    /**
     * 모든 마크된 항목 하드 삭제
     */
    @DeleteMapping("/agents/graphs/hard-delete")
    void hardDeleteAgentGraphs();
}
