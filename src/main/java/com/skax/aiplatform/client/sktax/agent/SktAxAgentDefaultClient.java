package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX Agent 기본 API Feign Client
 * 
 * <p>Agent 플랫폼의 기본적인 API들을 제공합니다.
 * 일반적으로 자주 사용되는 Agent 관련 기본 기능들을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-default-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentDefaultClient {

    /**
     * Agent 플랫폼 정보 조회
     * 
     * <p>Agent 플랫폼의 기본 정보와 상태를 조회합니다.</p>
     * 
     * @return 플랫폼 정보
     */
    @GetMapping("/api/v1/agent")
    CommonResponse getAgentPlatformInfo();

    /**
     * Agent 노드 타입 정보 조회
     * 
     * <p>사용 가능한 Agent 노드 타입들의 정보를 조회합니다.</p>
     * 
     * @param nodeType 노드 타입 (선택사항)
     * @return 노드 타입 정보
     */
    @GetMapping("/api/v1/agent/graphs/node/info")
    CommonResponse getNodeInfo(@RequestParam(value = "node_type", required = false) String nodeType);

    /**
     * Agent Graph 예약 변수명 조회
     * 
     * <p>Agent Graph에서 내부적으로 사용하는 예약된 변수명들을 조회합니다.</p>
     * 
     * @return 예약 변수명 목록
     */
    @GetMapping("/api/v1/agent/graphs/node/reserved-variables")
    CommonResponse getReservedVariables();

    /**
     * Agent Graph 템플릿 목록 조회
     * 
     * <p>사용 가능한 Agent Graph 템플릿 목록을 조회합니다.</p>
     * 
     * @return Agent Graph 템플릿 목록
     */
    @GetMapping("/api/v1/agent/graphs/templates")
    CommonResponse getAgentGraphTemplates();

    /**
     * 특정 Agent Graph 템플릿 조회
     * 
     * <p>특정 ID의 Agent Graph 템플릿 상세 정보를 조회합니다.</p>
     * 
     * @param templateId 템플릿 ID
     * @return Agent Graph 템플릿 상세 정보
     */
    @GetMapping("/api/v1/agent/graphs/templates/{templateId}")
    CommonResponse getAgentGraphTemplateById(@PathVariable("templateId") String templateId);

    /**
     * 프로파일링 요청 파일 목록 조회
     * 
     * <p>코드 프로파일링 요청 파일들의 목록을 조회합니다.</p>
     * 
     * @return 프로파일 파일 목록 (HTML 형식)
     */
    @GetMapping("/profile_requests")
    String listProfileFiles();

    /**
     * 프로파일링 파일 삭제
     * 
     * <p>특정 프로파일링 파일을 삭제합니다.</p>
     * 
     * @param filename 삭제할 파일명
     */
    @DeleteMapping("/profile_requests/{filename}")
    void deleteProfileFile(@PathVariable("filename") String filename);

    /**
     * 트레이싱 테스트
     * 
     * <p>클라이언트와 앱 ID를 사용하여 트레이싱 기능을 테스트합니다.</p>
     * 
     * @param clientId 클라이언트 ID
     * @param appId 앱 ID
     * @return 트레이싱 테스트 결과 (HTML 형식)
     */
    @GetMapping("/test-tracing/{clientId}/{appId}")
    String testTracing(
            @PathVariable("clientId") String clientId, 
            @PathVariable("appId") String appId
    );
}
