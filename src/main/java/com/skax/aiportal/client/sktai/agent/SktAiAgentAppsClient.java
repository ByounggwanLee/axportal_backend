package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.client.sktai.agent.dto.request.AppCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.AppDeployRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.AppUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

/**
 * SKT AI Agent Apps 관리 API Feign 클라이언트
 *
 * <p>Agent 애플리케이션의 생성, 배포, 관리 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-apps", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        SktAiClientConfig.class,
        SktAiAuthInterceptor.class,
        SktAiLoggingInterceptor.class
})
public interface SktAiAgentAppsClient {

    /**
     * Agent App 목록 조회
     *
     * @param targetType 대상 타입 (agent_graph, external_graph, all)
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Agent App 목록 응답
     */
    @GetMapping("/agents/apps")
    CommonResponse getApps(
        @RequestParam(name = "target_type", defaultValue = "agent_graph") String targetType,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Agent App 생성 및 배포
     *
     * @param request App 생성 요청
     * @return App 생성 응답
     */
    @PostMapping(value = "/agents/apps", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommonResponse createAndDeployApp(@RequestBody AppCreateRequest request);

    /**
     * Agent App 상세 조회
     *
     * @param appId App ID
     * @return App 상세 정보 응답
     */
    @GetMapping("/agents/apps/{app_id}")
    CommonResponse getAppById(@PathVariable("app_id") String appId);

    /**
     * Agent App 수정
     *
     * @param appId App ID
     * @param request App 수정 요청
     * @return App 수정 응답
     */
    @PutMapping("/agents/apps/{app_id}")
    CommonResponse updateApp(@PathVariable("app_id") String appId, @RequestBody AppUpdateRequest request);

    /**
     * Agent App 삭제
     *
     * @param appId App ID
     */
    @DeleteMapping("/agents/apps/{app_id}")
    void deleteApp(@PathVariable("app_id") String appId);

    /**
     * App 배포 목록 조회
     *
     * @param appId App ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 배포 목록 응답
     */
    @GetMapping("/agents/apps/{app_id}/deployments")
    CommonResponse getDeployments(
        @PathVariable("app_id") String appId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * 커스텀 App 생성 및 배포 (파일 업로드)
     *
     * @param envFile 환경 파일
     * @param name 앱 이름
     * @param description 앱 설명
     * @param versionDescription 버전 설명
     * @param targetType 대상 타입
     * @param modelList 모델 목록
     * @param servingType 서빙 타입
     * @param registryUrl 레지스트리 URL
     * @param imageTag 이미지 태그
     * @param cpuRequest CPU 요청량
     * @param cpuLimit CPU 제한량
     * @param memRequest 메모리 요청량
     * @param memLimit 메모리 제한량
     * @param minReplicas 최소 복제본 수
     * @param maxReplicas 최대 복제본 수
     * @param workersPerCore 코어당 워커 수
     * @return 커스텀 App 생성 응답
     */
    @PostMapping(value = "/agents/apps/custom", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResponse createAndDeployCustomApp(
        @RequestPart(value = "env_file", required = false) MultipartFile envFile,
        @RequestPart("name") String name,
        @RequestPart("description") String description,
        @RequestPart(value = "version_description", required = false) String versionDescription,
        @RequestPart(value = "target_type", required = false) String targetType,
        @RequestPart("model_list") String[] modelList,
        @RequestPart(value = "serving_type", required = false) String servingType,
        @RequestPart("registry_url") String registryUrl,
        @RequestPart("image_tag") String imageTag,
        @RequestPart(value = "cpu_request", required = false) Integer cpuRequest,
        @RequestPart(value = "cpu_limit", required = false) Integer cpuLimit,
        @RequestPart(value = "mem_request", required = false) Integer memRequest,
        @RequestPart(value = "mem_limit", required = false) Integer memLimit,
        @RequestPart(value = "min_replicas", required = false) Integer minReplicas,
        @RequestPart(value = "max_replicas", required = false) Integer maxReplicas,
        @RequestPart(value = "workers_per_core", required = false) Integer workersPerCore
    );

    /**
     * App 배포 추가
     *
     * @param appId App ID
     * @param request 배포 요청
     * @return 배포 추가 응답
     */
    @PostMapping("/agents/apps/deployments")
    CommonResponse addDeployment(@RequestParam("app_id") String appId, @RequestBody AppDeployRequest request);

    /**
     * 커스텀 App 배포 추가 (파일 업로드)
     *
     * @param appId App ID
     * @param envFile 환경 파일
     * @param versionDescription 버전 설명
     * @param targetType 대상 타입
     * @param modelList 모델 목록
     * @param servingType 서빙 타입
     * @param registryUrl 레지스트리 URL
     * @param imageTag 이미지 태그
     * @param cpuRequest CPU 요청량
     * @param cpuLimit CPU 제한량
     * @param memRequest 메모리 요청량
     * @param memLimit 메모리 제한량
     * @param minReplicas 최소 복제본 수
     * @param maxReplicas 최대 복제본 수
     * @param workersPerCore 코어당 워커 수
     * @return 커스텀 배포 추가 응답
     */
    @PostMapping(value = "/agents/apps/deployments/custom", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResponse addCustomDeployment(
        @RequestParam("app_id") String appId,
        @RequestPart(value = "env_file", required = false) MultipartFile envFile,
        @RequestPart(value = "version_description", required = false) String versionDescription,
        @RequestPart(value = "target_type", required = false) String targetType,
        @RequestPart("model_list") String[] modelList,
        @RequestPart(value = "serving_type", required = false) String servingType,
        @RequestPart("registry_url") String registryUrl,
        @RequestPart("image_tag") String imageTag,
        @RequestPart(value = "cpu_request", required = false) Integer cpuRequest,
        @RequestPart(value = "cpu_limit", required = false) Integer cpuLimit,
        @RequestPart(value = "mem_request", required = false) Integer memRequest,
        @RequestPart(value = "mem_limit", required = false) Integer memLimit,
        @RequestPart(value = "min_replicas", required = false) Integer minReplicas,
        @RequestPart(value = "max_replicas", required = false) Integer maxReplicas,
        @RequestPart(value = "workers_per_core", required = false) Integer workersPerCore
    );

    /**
     * 배포 중지
     *
     * @param deploymentId 배포 ID
     * @return 배포 중지 응답
     */
    @PostMapping("/agents/apps/deployments/stop/{deployment_id}")
    CommonResponse stopDeployment(@PathVariable("deployment_id") String deploymentId);

    /**
     * 배포 재시작
     *
     * @param deploymentId 배포 ID
     * @return 배포 재시작 응답
     */
    @PostMapping("/agents/apps/deployments/restart/{deployment_id}")
    CommonResponse restartDeployment(@PathVariable("deployment_id") String deploymentId);

    /**
     * 배포 삭제
     *
     * @param deploymentId 배포 ID
     */
    @DeleteMapping("/agents/apps/deployments/{deployment_id}")
    void deleteDeployment(@PathVariable("deployment_id") String deploymentId);

    /**
     * 배포 상세 조회
     *
     * @param deploymentId 배포 ID
     * @return 배포 상세 정보 응답
     */
    @GetMapping("/agents/apps/deployments/{deployment_id}")
    CommonResponse getDeploymentById(@PathVariable("deployment_id") String deploymentId);

    /**
     * App API 키 목록 조회
     *
     * @param appId App ID
     * @return API 키 목록 응답
     */
    @GetMapping("/agents/apps/{app_id}/apikeys")
    CommonResponse getApiKeys(@PathVariable("app_id") String appId);

    /**
     * App API 키 생성
     *
     * @param appId App ID
     * @return API 키 생성 응답
     */
    @PostMapping("/agents/apps/{app_id}/apikeys")
    CommonResponse createApiKey(@PathVariable("app_id") String appId);

    /**
     * App API 키 재생성
     *
     * @param appId App ID
     * @param apiKey API 키
     * @return API 키 재생성 응답
     */
    @GetMapping("/agents/apps/{app_id}/apikeys/{api_key}/regenerate")
    CommonResponse regenerateApiKey(@PathVariable("app_id") String appId, @PathVariable("api_key") String apiKey);

    /**
     * App API 키 삭제
     *
     * @param appId App ID
     * @param apiKey API 키
     */
    @DeleteMapping("/agents/apps/{app_id}/apikeys/{api_key}")
    void deleteApiKey(@PathVariable("app_id") String appId, @PathVariable("api_key") String apiKey);

    /**
     * 모델별 App 목록 조회
     *
     * @param modelName 모델 이름
     * @param clientSecret 클라이언트 시크릿
     * @return 모델별 App 목록 응답
     */
    @GetMapping("/agents/apps/model/{model_name}")
    CommonResponse getAppsByModel(
        @PathVariable("model_name") String modelName,
        @RequestHeader("Client-Secret") String clientSecret
    );

    /**
     * 지식별 App 목록 조회
     *
     * @param knowledgeId 지식 ID
     * @param clientSecret 클라이언트 시크릿
     * @return 지식별 App 목록 응답
     */
    @GetMapping("/agents/apps/knowledge/{knowledge_id}")
    CommonResponse getAppsByKnowledge(
        @PathVariable("knowledge_id") String knowledgeId,
        @RequestHeader("Client-Secret") String clientSecret
    );

    /**
     * Phoenix 프로젝트 ID 조회
     *
     * @param projectName 프로젝트 이름
     * @return 프로젝트 ID 응답
     */
    @GetMapping("/agents/apps/phoenix/projects/{project_name}")
    String getProjectId(@PathVariable("project_name") String projectName);

    /**
     * 삭제 표시된 모든 App 완전 삭제 (hard delete)
     */
    @DeleteMapping("/agents/apps/hard-delete")
    void hardDeleteApps();
}
