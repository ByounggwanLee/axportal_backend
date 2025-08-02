package com.skax.aiplatform.client.sktax.serving;

import com.skax.aiplatform.client.sktax.serving.dto.request.AgentServingCreate;
import com.skax.aiplatform.client.sktax.serving.dto.request.AgentServingScale;
import com.skax.aiplatform.client.sktax.serving.dto.request.AgentServingUpdate;
import com.skax.aiplatform.client.sktax.serving.dto.response.AgentServingInfo;
import com.skax.aiplatform.client.sktax.serving.dto.response.AgentServingResponse;
import com.skax.aiplatform.client.sktax.serving.dto.response.AgentServingsRead;
import com.skax.aiplatform.client.sktax.serving.dto.response.ApiKeyRead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Agent Serving API Client
 * 에이전트 서빙 관련 API를 호출하기 위한 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-serving-client",
    url = "${skta.api.serving.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface AgentServingClient {

    /**
     * 새로운 에이전트 서빙 생성
     *
     * @param request 에이전트 서빙 생성 요청 데이터
     * @return 생성된 에이전트 서빙 정보
     */
    @PostMapping("/api/v1/agent_servings")
    AgentServingResponse createAgentServing(@RequestBody AgentServingCreate request);

    /**
     * 에이전트 서빙 목록 조회
     *
     * @param page   페이지 번호 (기본값: 1)
     * @param size   페이지 크기 (기본값: 10)
     * @param sort   정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 에이전트 서빙 목록
     */
    @GetMapping("/api/v1/agent_servings")
    AgentServingsRead getAgentServings(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 특정 에이전트 서빙 조회
     *
     * @param agentServingId 에이전트 서빙 ID
     * @return 에이전트 서빙 상세 정보
     */
    @GetMapping("/api/v1/agent_servings/{agent_serving_id}")
    AgentServingInfo getAgentServing(@PathVariable("agent_serving_id") UUID agentServingId);

    /**
     * 에이전트 서빙 정보 수정
     *
     * @param agentServingId 에이전트 서빙 ID
     * @param request        수정할 에이전트 서빙 정보
     * @return 수정된 에이전트 서빙 정보
     */
    @PutMapping("/api/v1/agent_servings/{agent_serving_id}")
    AgentServingResponse updateAgentServing(
        @PathVariable("agent_serving_id") UUID agentServingId,
        @RequestBody AgentServingUpdate request
    );

    /**
     * 에이전트 서빙 삭제 (소프트 삭제)
     *
     * @param agentServingId 에이전트 서빙 ID
     * @return 빈 응답
     */
    @DeleteMapping("/api/v1/agent_servings/{agent_serving_id}")
    Void deleteAgentServing(@PathVariable("agent_serving_id") UUID agentServingId);

    /**
     * 에이전트 서빙 중지
     *
     * @param agentServingId 에이전트 서빙 ID
     * @return 빈 응답
     */
    @PostMapping("/api/v1/agent_servings/{agent_serving_id}/stop")
    Void stopAgentServing(@PathVariable("agent_serving_id") UUID agentServingId);

    /**
     * 에이전트 서빙 시작
     *
     * @param agentServingId 에이전트 서빙 ID
     * @return 빈 응답
     */
    @PostMapping("/api/v1/agent_servings/{agent_serving_id}/start")
    Void startAgentServing(@PathVariable("agent_serving_id") UUID agentServingId);

    /**
     * 에이전트 서빙 오토스케일 설정
     *
     * @param agentServingId 에이전트 서빙 ID
     * @param request        스케일 설정 정보
     * @return 빈 응답
     */
    @PutMapping("/api/v1/agent_servings/{agent_serving_id}/autoscale")
    Void scaleAgentServing(
        @PathVariable("agent_serving_id") UUID agentServingId,
        @RequestBody AgentServingScale request
    );

    /**
     * 에이전트 서빙에 사용 가능한 API 키 목록 조회
     *
     * @param agentServingId 에이전트 서빙 ID
     * @param page           페이지 번호 (기본값: 1)
     * @param size           페이지 크기 (기본값: 10)
     * @param sort           정렬 기준
     * @param filter         필터 조건
     * @param search         검색어
     * @return API 키 목록
     */
    @GetMapping("/api/v1/agent_servings/{agent_serving_id}/apikeys")
    ApiKeyRead getAvailableApikeys(
        @PathVariable("agent_serving_id") UUID agentServingId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 하드 삭제 (DB에서 완전 삭제)
     *
     * @return 빈 응답
     */
    @PostMapping("/api/v1/agent_servings/hard-delete")
    Void hardDeleteAgentServings();
}
