package com.skax.aiportal.controller.agent;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skax.aiportal.dto.agent.request.AgentAppCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentAppDeployRequest;
import com.skax.aiportal.dto.agent.request.AgentAppUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentAppDeploymentResponse;
import com.skax.aiportal.dto.agent.response.AgentAppListResponse;
import com.skax.aiportal.dto.agent.response.AgentAppResponse;
import com.skax.aiportal.service.agent.AgentAppsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Agent Apps 관리 컨트롤러
 * 
 * <p>Agent 애플리케이션의 생성, 조회, 수정, 삭제 및 배포 관리 REST API를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/agent/apps")
@RequiredArgsConstructor
@Tag(name = "Agent Apps", description = "Agent 애플리케이션 관리 API")
public class AgentAppsController {

    private final AgentAppsService agentAppsService;

    @Operation(
        summary = "Agent App 목록 조회",
        description = "조건에 따라 Agent 애플리케이션 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 파라미터"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping
    public ResponseEntity<AgentAppListResponse> getApps(
            @Parameter(description = "대상 타입 (agent_graph, external_graph, all)")
            @RequestParam(value = "target_type", defaultValue = "agent_graph") String targetType,
            @Parameter(description = "페이지 번호 (1부터 시작)")
            @RequestParam(defaultValue = "1") Integer page,
            @Parameter(description = "페이지 크기")
            @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "정렬 기준")
            @RequestParam(required = false) String sort,
            @Parameter(description = "필터 조건")
            @RequestParam(required = false) String filter,
            @Parameter(description = "검색어")
            @RequestParam(required = false) String search) {
        
        log.info("Agent App 목록 조회 요청 - targetType: {}, page: {}, size: {}", targetType, page, size);
        
        AgentAppListResponse response = agentAppsService.getApps(targetType, page, size, sort, filter, search);
        
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "Agent App 상세 조회",
        description = "특정 Agent 애플리케이션의 상세 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "App을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/{appId}")
    public ResponseEntity<AgentAppResponse> getAppById(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId) {
        
        log.info("Agent App 상세 조회 요청 - appId: {}", appId);
        
        AgentAppResponse response = agentAppsService.getAppById(appId);
        
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "Agent App 생성 및 배포",
        description = "새로운 Agent 애플리케이션을 생성하고 배포합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "생성 및 배포 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping
    public ResponseEntity<AgentAppResponse> createAndDeployApp(
            @Valid @RequestBody AgentAppCreateRequest request) {
        
        log.info("Agent App 생성 및 배포 요청 - name: {}", request.getName());
        
        AgentAppResponse response = agentAppsService.createAndDeployApp(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "Agent App 수정",
        description = "기존 Agent 애플리케이션의 정보를 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "수정 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "404", description = "App을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PutMapping("/{appId}")
    public ResponseEntity<AgentAppResponse> updateApp(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId,
            @Valid @RequestBody AgentAppUpdateRequest request) {
        
        log.info("Agent App 수정 요청 - appId: {}", appId);
        
        AgentAppResponse response = agentAppsService.updateApp(appId, request);
        
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "Agent App 삭제",
        description = "특정 Agent 애플리케이션을 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "삭제 성공"),
        @ApiResponse(responseCode = "404", description = "App을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApp(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId) {
        
        log.info("Agent App 삭제 요청 - appId: {}", appId);
        
        agentAppsService.deleteApp(appId);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "App 배포 목록 조회",
        description = "특정 Agent 애플리케이션의 배포 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "App을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/{appId}/deployments")
    public ResponseEntity<List<AgentAppDeploymentResponse>> getDeployments(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId,
            @Parameter(description = "페이지 번호")
            @RequestParam(defaultValue = "1") Integer page,
            @Parameter(description = "페이지 크기")
            @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "정렬 기준")
            @RequestParam(required = false) String sort,
            @Parameter(description = "필터 조건")
            @RequestParam(required = false) String filter,
            @Parameter(description = "검색어")
            @RequestParam(required = false) String search) {
        
        log.info("App 배포 목록 조회 요청 - appId: {}, page: {}, size: {}", appId, page, size);
        
        List<AgentAppDeploymentResponse> deployments = agentAppsService.getDeployments(appId, page, size, sort, filter, search);
        
        return ResponseEntity.ok(deployments);
    }

    @Operation(
        summary = "App 배포 추가",
        description = "특정 Agent 애플리케이션에 새로운 배포를 추가합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "배포 추가 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "404", description = "App을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/{appId}/deployments")
    public ResponseEntity<AgentAppDeploymentResponse> addDeployment(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId,
            @Valid @RequestBody AgentAppDeployRequest request) {
        
        log.info("App 배포 추가 요청 - appId: {}", appId);
        
        AgentAppDeploymentResponse response = agentAppsService.addDeployment(appId, request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "배포 상세 조회",
        description = "특정 배포의 상세 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "배포를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/deployments/{deploymentId}")
    public ResponseEntity<AgentAppDeploymentResponse> getDeploymentById(
            @Parameter(description = "배포 ID", required = true)
            @PathVariable String deploymentId) {
        
        log.info("배포 상세 조회 요청 - deploymentId: {}", deploymentId);
        
        AgentAppDeploymentResponse response = agentAppsService.getDeploymentById(deploymentId);
        
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "배포 중지",
        description = "특정 배포를 중지합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "중지 성공"),
        @ApiResponse(responseCode = "404", description = "배포를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/deployments/{deploymentId}/stop")
    public ResponseEntity<Void> stopDeployment(
            @Parameter(description = "배포 ID", required = true)
            @PathVariable String deploymentId) {
        
        log.info("배포 중지 요청 - deploymentId: {}", deploymentId);
        
        agentAppsService.stopDeployment(deploymentId);
        
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "배포 재시작",
        description = "특정 배포를 재시작합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "재시작 성공"),
        @ApiResponse(responseCode = "404", description = "배포를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/deployments/{deploymentId}/restart")
    public ResponseEntity<Void> restartDeployment(
            @Parameter(description = "배포 ID", required = true)
            @PathVariable String deploymentId) {
        
        log.info("배포 재시작 요청 - deploymentId: {}", deploymentId);
        
        agentAppsService.restartDeployment(deploymentId);
        
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "배포 삭제",
        description = "특정 배포를 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "삭제 성공"),
        @ApiResponse(responseCode = "404", description = "배포를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @DeleteMapping("/deployments/{deploymentId}")
    public ResponseEntity<Void> deleteDeployment(
            @Parameter(description = "배포 ID", required = true)
            @PathVariable String deploymentId) {
        
        log.info("배포 삭제 요청 - deploymentId: {}", deploymentId);
        
        agentAppsService.deleteDeployment(deploymentId);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "App API 키 목록 조회",
        description = "특정 Agent 애플리케이션의 API 키 목록을 조회합니다."
    )
    @GetMapping("/{appId}/apikeys")
    public ResponseEntity<List<String>> getApiKeys(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId) {
        
        log.info("App API 키 목록 조회 요청 - appId: {}", appId);
        
        List<String> apiKeys = agentAppsService.getApiKeys(appId);
        
        return ResponseEntity.ok(apiKeys);
    }

    @Operation(
        summary = "App API 키 생성",
        description = "특정 Agent 애플리케이션의 새로운 API 키를 생성합니다."
    )
    @PostMapping("/{appId}/apikeys")
    public ResponseEntity<String> createApiKey(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId) {
        
        log.info("App API 키 생성 요청 - appId: {}", appId);
        
        String apiKey = agentAppsService.createApiKey(appId);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(apiKey);
    }

    @Operation(
        summary = "App API 키 재생성",
        description = "특정 Agent 애플리케이션의 API 키를 재생성합니다."
    )
    @PostMapping("/{appId}/apikeys/{apiKey}/regenerate")
    public ResponseEntity<String> regenerateApiKey(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId,
            @Parameter(description = "API Key", required = true)
            @PathVariable String apiKey) {
        
        log.info("App API 키 재생성 요청 - appId: {}, apiKey: {}", appId, apiKey);
        
        String newApiKey = agentAppsService.regenerateApiKey(appId, apiKey);
        
        return ResponseEntity.ok(newApiKey);
    }

    @Operation(
        summary = "App API 키 삭제",
        description = "특정 Agent 애플리케이션의 API 키를 삭제합니다."
    )
    @DeleteMapping("/{appId}/apikeys/{apiKey}")
    public ResponseEntity<Void> deleteApiKey(
            @Parameter(description = "App ID", required = true)
            @PathVariable String appId,
            @Parameter(description = "API Key", required = true)
            @PathVariable String apiKey) {
        
        log.info("App API 키 삭제 요청 - appId: {}, apiKey: {}", appId, apiKey);
        
        agentAppsService.deleteApiKey(appId, apiKey);
        
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "모델별 App 목록 조회",
        description = "특정 모델에 연결된 Agent 애플리케이션 목록을 조회합니다."
    )
    @GetMapping("/by-model/{modelName}")
    public ResponseEntity<List<AgentAppResponse>> getAppsByModel(
            @Parameter(description = "모델 이름", required = true)
            @PathVariable String modelName) {
        
        log.info("모델별 App 목록 조회 요청 - modelName: {}", modelName);
        
        List<AgentAppResponse> apps = agentAppsService.getAppsByModel(modelName);
        
        return ResponseEntity.ok(apps);
    }

    @Operation(
        summary = "지식별 App 목록 조회",
        description = "특정 지식에 연결된 Agent 애플리케이션 목록을 조회합니다."
    )
    @GetMapping("/by-knowledge/{knowledgeId}")
    public ResponseEntity<List<AgentAppResponse>> getAppsByKnowledge(
            @Parameter(description = "지식 ID", required = true)
            @PathVariable String knowledgeId) {
        
        log.info("지식별 App 목록 조회 요청 - knowledgeId: {}", knowledgeId);
        
        List<AgentAppResponse> apps = agentAppsService.getAppsByKnowledge(knowledgeId);
        
        return ResponseEntity.ok(apps);
    }

    @Operation(
        summary = "Phoenix 프로젝트 ID 조회",
        description = "프로젝트 이름으로 Phoenix 프로젝트 ID를 조회합니다."
    )
    @GetMapping("/phoenix/projects/{projectName}")
    public ResponseEntity<String> getProjectId(
            @Parameter(description = "프로젝트 이름", required = true)
            @PathVariable String projectName) {
        
        log.info("Phoenix 프로젝트 ID 조회 요청 - projectName: {}", projectName);
        
        String projectId = agentAppsService.getProjectId(projectName);
        
        return ResponseEntity.ok(projectId);
    }

    @Operation(
        summary = "삭제된 모든 App 완전 삭제",
        description = "소프트 삭제된 모든 Agent 애플리케이션을 완전히 삭제합니다."
    )
    @DeleteMapping("/hard-delete")
    public ResponseEntity<Void> hardDeleteApps() {
        
        log.info("모든 삭제된 Agent App 완전 삭제 요청");
        
        agentAppsService.hardDeleteApps();
        
        return ResponseEntity.noContent().build();
    }
}
