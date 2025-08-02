package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.request.AppCreateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.AppUpdateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.AppDeployRequest;
import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX Agent Apps 관리 Feign Client
 * 
 * <p>Agent App의 생성, 조회, 수정, 삭제, 배포를 담당하는 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-apps", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentAppsClient {

    /**
     * Agent App 목록 조회
     */
    @GetMapping("/agents/apps")
    CommonResponse getApps(
        @RequestParam(value = "target_type", defaultValue = "agent_graph") String targetType,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Agent App 생성 및 배포
     */
    @PostMapping("/agents/apps")
    CommonResponse createAndDeployApp(@RequestBody AppCreateRequest request);

    /**
     * Agent App 상세 조회
     */
    @GetMapping("/agents/apps/{appId}")
    CommonResponse getAppById(@PathVariable("appId") String appId);

    /**
     * Agent App 정보 수정 (이름, 설명)
     */
    @PutMapping("/agents/apps/{appId}")
    CommonResponse updateApp(
        @PathVariable("appId") String appId,
        @RequestBody AppUpdateRequest request
    );

    /**
     * Agent App 삭제
     */
    @DeleteMapping("/agents/apps/{appId}")
    void deleteApp(@PathVariable("appId") String appId);

    /**
     * Agent App 배포 목록 조회
     */
    @GetMapping("/agents/apps/{appId}/deployments")
    CommonResponse getDeployments(
        @PathVariable("appId") String appId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Agent App 배포 추가
     */
    @PostMapping("/agents/apps/deployments")
    CommonResponse addDeployment(
        @RequestParam("app_id") String appId,
        @RequestBody AppDeployRequest request
    );

    /**
     * 배포 중지
     */
    @PostMapping("/agents/apps/deployments/stop/{deploymentId}")
    CommonResponse stopDeployment(@PathVariable("deploymentId") String deploymentId);

    /**
     * 배포 재시작
     */
    @PostMapping("/agents/apps/deployments/restart/{deploymentId}")
    CommonResponse restartDeployment(@PathVariable("deploymentId") String deploymentId);

    /**
     * 배포 삭제
     */
    @DeleteMapping("/agents/apps/deployments/{deploymentId}")
    void deleteDeployment(@PathVariable("deploymentId") String deploymentId);

    /**
     * 배포 상세 조회
     */
    @GetMapping("/agents/apps/deployments/{deploymentId}")
    CommonResponse getDeploymentById(@PathVariable("deploymentId") String deploymentId);

    /**
     * Agent App API 키 목록 조회
     */
    @GetMapping("/agents/apps/{appId}/apikeys")
    CommonResponse getApiKeys(@PathVariable("appId") String appId);

    /**
     * Agent App API 키 생성
     */
    @PostMapping("/agents/apps/{appId}/apikeys")
    CommonResponse createApiKey(@PathVariable("appId") String appId);

    /**
     * Agent App API 키 재생성
     */
    @GetMapping("/agents/apps/{appId}/apikeys/{apiKey}/regenerate")
    CommonResponse regenerateApiKey(
        @PathVariable("appId") String appId,
        @PathVariable("apiKey") String apiKey
    );

    /**
     * Agent App API 키 삭제
     */
    @DeleteMapping("/agents/apps/{appId}/apikeys/{apiKey}")
    void deleteApiKey(
        @PathVariable("appId") String appId,
        @PathVariable("apiKey") String apiKey
    );

    /**
     * 모델별 App 목록 조회
     */
    @GetMapping("/agents/apps/model/{modelName}")
    CommonResponse getAppsByModelName(
        @PathVariable("modelName") String modelName,
        @RequestHeader("client-secret") String clientSecret
    );

    /**
     * 지식베이스별 App 목록 조회
     */
    @GetMapping("/agents/apps/knowledge/{knowledgeId}")
    CommonResponse getAppsByKnowledgeId(
        @PathVariable("knowledgeId") String knowledgeId,
        @RequestHeader("client-secret") String clientSecret
    );

    /**
     * Phoenix 프로젝트 ID 조회
     */
    @GetMapping("/agents/apps/phoenix/projects/{projectName}")
    String getPhoenixProjectId(@PathVariable("projectName") String projectName);

    /**
     * 삭제 표시된 모든 Agent App 완전 삭제
     */
    @DeleteMapping("/agents/apps/hard-delete")
    void hardDeleteApps();
}
