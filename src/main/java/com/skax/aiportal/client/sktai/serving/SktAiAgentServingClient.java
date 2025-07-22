package com.skax.aiportal.client.sktai.serving;

import com.skax.aiportal.client.sktai.serving.dto.request.AgentServingCreateRequest;
import com.skax.aiportal.client.sktai.serving.dto.request.AgentServingUpdateRequest;
import com.skax.aiportal.client.sktai.serving.dto.request.ServingScaleRequest;
import com.skax.aiportal.client.sktai.serving.dto.response.AgentServingResponse;
import com.skax.aiportal.client.sktai.serving.dto.response.AgentServingListResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI 에이전트 서빙 API Feign 클라이언트
 * 
 * 에이전트 서빙 관련 API 엔드포인트를 담당합니다.
 * - 에이전트 서빙 생성, 조회, 수정, 삭제
 * - 에이전트 서빙 시작, 중지, 스케일링
 */
@FeignClient(
    name = "sktai-agent-serving-client",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = SktAiClientConfig.class,
    path = "/api/v1"
)
public interface SktAiAgentServingClient {

    /**
     * 에이전트 서빙 목록 조회
     * 
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기
     * @param search 검색어
     * @param status 상태 필터
     * @return 에이전트 서빙 목록 응답
     */
    @GetMapping("/agent_servings")
    AgentServingListResponse getAgentServings(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "20") Integer size,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "status", required = false) String status
    );

    /**
     * 에이전트 서빙 생성
     * 
     * @param request 에이전트 서빙 생성 요청
     * @return 생성된 에이전트 서빙 정보
     */
    @PostMapping("/agent_servings")
    AgentServingResponse createAgentServing(@RequestBody AgentServingCreateRequest request);

    /**
     * 에이전트 서빙 상세 조회
     * 
     * @param agentServingId 에이전트 서빙 ID
     * @return 에이전트 서빙 상세 정보
     */
    @GetMapping("/agent_servings/{agentServingId}")
    AgentServingResponse getAgentServing(@PathVariable("agentServingId") String agentServingId);

    /**
     * 에이전트 서빙 수정
     * 
     * @param agentServingId 에이전트 서빙 ID
     * @param request 에이전트 서빙 수정 요청
     * @return 수정된 에이전트 서빙 정보
     */
    @PutMapping("/agent_servings/{agentServingId}")
    AgentServingResponse updateAgentServing(
        @PathVariable("agentServingId") String agentServingId,
        @RequestBody AgentServingUpdateRequest request
    );

    /**
     * 에이전트 서빙 삭제
     * 
     * @param agentServingId 에이전트 서빙 ID
     */
    @DeleteMapping("/agent_servings/{agentServingId}")
    void deleteAgentServing(@PathVariable("agentServingId") String agentServingId);

    /**
     * 에이전트 서빙 시작
     * 
     * @param agentServingId 에이전트 서빙 ID
     * @return 에이전트 서빙 정보
     */
    @PostMapping("/agent_servings/{agentServingId}/start")
    AgentServingResponse startAgentServing(@PathVariable("agentServingId") String agentServingId);

    /**
     * 에이전트 서빙 중지
     * 
     * @param agentServingId 에이전트 서빙 ID
     * @return 에이전트 서빙 정보
     */
    @PostMapping("/agent_servings/{agentServingId}/stop")
    AgentServingResponse stopAgentServing(@PathVariable("agentServingId") String agentServingId);

    /**
     * 에이전트 서빙 스케일링
     * 
     * @param agentServingId 에이전트 서빙 ID
     * @param request 스케일링 요청
     * @return 에이전트 서빙 정보
     */
    @PostMapping("/agent_servings/{agentServingId}/autoscale")
    AgentServingResponse scaleAgentServing(
        @PathVariable("agentServingId") String agentServingId,
        @RequestBody ServingScaleRequest request
    );
}
