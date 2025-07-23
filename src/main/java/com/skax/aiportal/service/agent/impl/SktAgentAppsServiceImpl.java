package com.skax.aiportal.service.agent.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentAppsClient;
import com.skax.aiportal.client.sktai.agent.dto.request.AppCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.AppDeployRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.AppUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.request.AgentAppCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentAppDeployRequest;
import com.skax.aiportal.dto.agent.request.AgentAppUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentAppDeploymentResponse;
import com.skax.aiportal.dto.agent.response.AgentAppListResponse;
import com.skax.aiportal.dto.agent.response.AgentAppResponse;
import com.skax.aiportal.service.agent.AgentAppsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT Agent Apps 서비스 구현 클래스
 * 
 * <p>SKT AI 플랫폼의 Agent Apps 관련 비즈니스 로직을 구현합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentAppsServiceImpl implements AgentAppsService {

    private final SktAiAgentAppsClient agentAppsClient;

    @Override
    public AgentAppListResponse getApps(String targetType, Integer page, Integer size, String sort, String filter, String search) {
        log.info("Agent App 목록 조회 - targetType: {}, page: {}, size: {}, sort: {}, filter: {}, search: {}", 
                targetType, page, size, sort, filter, search);
        
        try {
            CommonResponse clientResponse = agentAppsClient.getApps(targetType, page, size, sort, filter, search);
            
            AgentAppListResponse response = convertToAppListResponse(clientResponse);
            
            log.info("Agent App 목록 조회 성공 - 조회된 App 수: {}", 
                    response.getData() != null ? response.getData().size() : 0);
            return response;
            
        } catch (Exception e) {
            log.error("Agent App 목록 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("Agent App 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentAppResponse getAppById(String appId) {
        log.info("Agent App 상세 조회 - appId: {}", appId);
        
        try {
            CommonResponse clientResponse = agentAppsClient.getAppById(appId);
            
            AgentAppResponse response = convertToAppResponse(clientResponse);
            
            log.info("Agent App 상세 조회 성공 - appId: {}, name: {}", appId, response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("Agent App 상세 조회 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("Agent App 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentAppResponse createAndDeployApp(AgentAppCreateRequest request) {
        log.info("Agent App 생성 및 배포 - name: {}", request.getName());
        
        try {
            AppCreateRequest clientRequest = convertToClientCreateRequest(request);
            
            CommonResponse clientResponse = agentAppsClient.createAndDeployApp(clientRequest);
            
            AgentAppResponse response = convertToAppResponse(clientResponse);
            
            log.info("Agent App 생성 및 배포 성공 - id: {}, name: {}", response.getId(), response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("Agent App 생성 및 배포 실패: name={}, 오류={}", request.getName(), e.getMessage(), e);
            throw new RuntimeException("Agent App 생성 및 배포에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentAppResponse updateApp(String appId, AgentAppUpdateRequest request) {
        log.info("Agent App 수정 - appId: {}", appId);
        
        try {
            AppUpdateRequest clientRequest = convertToClientUpdateRequest(request);
            
            CommonResponse clientResponse = agentAppsClient.updateApp(appId, clientRequest);
            
            AgentAppResponse response = convertToAppResponse(clientResponse);
            
            log.info("Agent App 수정 성공 - appId: {}", appId);
            return response;
            
        } catch (Exception e) {
            log.error("Agent App 수정 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("Agent App 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteApp(String appId) {
        log.info("Agent App 삭제 - appId: {}", appId);
        
        try {
            agentAppsClient.deleteApp(appId);
            
            log.info("Agent App 삭제 성공 - appId: {}", appId);
            
        } catch (Exception e) {
            log.error("Agent App 삭제 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("Agent App 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AgentAppDeploymentResponse> getDeployments(String appId, Integer page, Integer size, String sort, String filter, String search) {
        log.info("App 배포 목록 조회 - appId: {}, page: {}, size: {}", appId, page, size);
        
        try {
            CommonResponse clientResponse = agentAppsClient.getDeployments(appId, page, size, sort, filter, search);
            
            List<AgentAppDeploymentResponse> deployments = convertToDeploymentListResponse(clientResponse);
            
            log.info("App 배포 목록 조회 성공 - appId: {}, 조회된 배포 수: {}", appId, deployments.size());
            return deployments;
            
        } catch (Exception e) {
            log.error("App 배포 목록 조회 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("App 배포 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentAppDeploymentResponse addDeployment(String appId, AgentAppDeployRequest request) {
        log.info("App 배포 추가 - appId: {}", appId);
        
        try {
            AppDeployRequest clientRequest = convertToClientDeployRequest(request);
            
            CommonResponse clientResponse = agentAppsClient.addDeployment(appId, clientRequest);
            
            AgentAppDeploymentResponse response = convertToDeploymentResponse(clientResponse);
            
            log.info("App 배포 추가 성공 - appId: {}, deploymentId: {}", appId, response.getId());
            return response;
            
        } catch (Exception e) {
            log.error("App 배포 추가 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("App 배포 추가에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentAppDeploymentResponse getDeploymentById(String deploymentId) {
        log.info("배포 상세 조회 - deploymentId: {}", deploymentId);
        
        try {
            CommonResponse clientResponse = agentAppsClient.getDeploymentById(deploymentId);
            
            AgentAppDeploymentResponse response = convertToDeploymentResponse(clientResponse);
            
            log.info("배포 상세 조회 성공 - deploymentId: {}", deploymentId);
            return response;
            
        } catch (Exception e) {
            log.error("배포 상세 조회 실패: deploymentId={}, 오류={}", deploymentId, e.getMessage(), e);
            throw new RuntimeException("배포 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void stopDeployment(String deploymentId) {
        log.info("배포 중지 - deploymentId: {}", deploymentId);
        
        try {
            agentAppsClient.stopDeployment(deploymentId);
            
            log.info("배포 중지 성공 - deploymentId: {}", deploymentId);
            
        } catch (Exception e) {
            log.error("배포 중지 실패: deploymentId={}, 오류={}", deploymentId, e.getMessage(), e);
            throw new RuntimeException("배포 중지에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void restartDeployment(String deploymentId) {
        log.info("배포 재시작 - deploymentId: {}", deploymentId);
        
        try {
            agentAppsClient.restartDeployment(deploymentId);
            
            log.info("배포 재시작 성공 - deploymentId: {}", deploymentId);
            
        } catch (Exception e) {
            log.error("배포 재시작 실패: deploymentId={}, 오류={}", deploymentId, e.getMessage(), e);
            throw new RuntimeException("배포 재시작에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteDeployment(String deploymentId) {
        log.info("배포 삭제 - deploymentId: {}", deploymentId);
        
        try {
            agentAppsClient.deleteDeployment(deploymentId);
            
            log.info("배포 삭제 성공 - deploymentId: {}", deploymentId);
            
        } catch (Exception e) {
            log.error("배포 삭제 실패: deploymentId={}, 오류={}", deploymentId, e.getMessage(), e);
            throw new RuntimeException("배포 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String> getApiKeys(String appId) {
        log.info("App API 키 목록 조회 - appId: {}", appId);
        
        try {
            CommonResponse clientResponse = agentAppsClient.getApiKeys(appId);
            
            List<String> apiKeys = convertToApiKeyList(clientResponse);
            
            log.info("App API 키 목록 조회 성공 - appId: {}, 키 개수: {}", appId, apiKeys.size());
            return apiKeys;
            
        } catch (Exception e) {
            log.error("App API 키 목록 조회 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("App API 키 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public String createApiKey(String appId) {
        log.info("App API 키 생성 - appId: {}", appId);
        
        try {
            CommonResponse clientResponse = agentAppsClient.createApiKey(appId);
            
            String apiKey = extractApiKey(clientResponse);
            
            log.info("App API 키 생성 성공 - appId: {}", appId);
            return apiKey;
            
        } catch (Exception e) {
            log.error("App API 키 생성 실패: appId={}, 오류={}", appId, e.getMessage(), e);
            throw new RuntimeException("App API 키 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public String regenerateApiKey(String appId, String apiKey) {
        log.info("App API 키 재생성 - appId: {}, apiKey: {}", appId, apiKey);
        
        try {
            CommonResponse clientResponse = agentAppsClient.regenerateApiKey(appId, apiKey);
            
            String newApiKey = extractApiKey(clientResponse);
            
            log.info("App API 키 재생성 성공 - appId: {}", appId);
            return newApiKey;
            
        } catch (Exception e) {
            log.error("App API 키 재생성 실패: appId={}, apiKey={}, 오류={}", appId, apiKey, e.getMessage(), e);
            throw new RuntimeException("App API 키 재생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteApiKey(String appId, String apiKey) {
        log.info("App API 키 삭제 - appId: {}, apiKey: {}", appId, apiKey);
        
        try {
            agentAppsClient.deleteApiKey(appId, apiKey);
            
            log.info("App API 키 삭제 성공 - appId: {}, apiKey: {}", appId, apiKey);
            
        } catch (Exception e) {
            log.error("App API 키 삭제 실패: appId={}, apiKey={}, 오류={}", appId, apiKey, e.getMessage(), e);
            throw new RuntimeException("App API 키 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AgentAppResponse> getAppsByModel(String modelName) {
        log.info("모델별 App 목록 조회 - modelName: {}", modelName);
        
        try {
            // 클라이언트 시크릿은 실제 구현에서는 설정에서 가져와야 함
            String clientSecret = "YOUR_CLIENT_SECRET";
            CommonResponse clientResponse = agentAppsClient.getAppsByModel(modelName, clientSecret);
            
            List<AgentAppResponse> apps = convertToAppResponseList(clientResponse);
            
            log.info("모델별 App 목록 조회 성공 - modelName: {}, 조회된 App 수: {}", modelName, apps.size());
            return apps;
            
        } catch (Exception e) {
            log.error("모델별 App 목록 조회 실패: modelName={}, 오류={}", modelName, e.getMessage(), e);
            throw new RuntimeException("모델별 App 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AgentAppResponse> getAppsByKnowledge(String knowledgeId) {
        log.info("지식별 App 목록 조회 - knowledgeId: {}", knowledgeId);
        
        try {
            // 클라이언트 시크릿은 실제 구현에서는 설정에서 가져와야 함
            String clientSecret = "YOUR_CLIENT_SECRET";
            CommonResponse clientResponse = agentAppsClient.getAppsByKnowledge(knowledgeId, clientSecret);
            
            List<AgentAppResponse> apps = convertToAppResponseList(clientResponse);
            
            log.info("지식별 App 목록 조회 성공 - knowledgeId: {}, 조회된 App 수: {}", knowledgeId, apps.size());
            return apps;
            
        } catch (Exception e) {
            log.error("지식별 App 목록 조회 실패: knowledgeId={}, 오류={}", knowledgeId, e.getMessage(), e);
            throw new RuntimeException("지식별 App 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public String getProjectId(String projectName) {
        log.info("Phoenix 프로젝트 ID 조회 - projectName: {}", projectName);
        
        try {
            String projectId = agentAppsClient.getProjectId(projectName);
            
            log.info("Phoenix 프로젝트 ID 조회 성공 - projectName: {}, projectId: {}", projectName, projectId);
            return projectId;
            
        } catch (Exception e) {
            log.error("Phoenix 프로젝트 ID 조회 실패: projectName={}, 오류={}", projectName, e.getMessage(), e);
            throw new RuntimeException("Phoenix 프로젝트 ID 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void hardDeleteApps() {
        log.info("모든 삭제된 Agent App 완전 삭제");
        
        try {
            agentAppsClient.hardDeleteApps();
            
            log.info("모든 삭제된 Agent App 완전 삭제 완료");
            
        } catch (Exception e) {
            log.error("모든 삭제된 Agent App 완전 삭제 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("모든 삭제된 Agent App 완전 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // ==================== 변환 메서드 ====================

    /**
     * 클라이언트 생성 요청으로 변환
     */
    private AppCreateRequest convertToClientCreateRequest(AgentAppCreateRequest request) {
        return AppCreateRequest.builder()
                .name(request.getName())
                .description(request.getDescription())
                .versionDescription(request.getVersionDescription())
                .targetType(request.getTargetType())
                .servingType(request.getServingType())
                .cpuRequest(request.getCpuRequest())
                .cpuLimit(request.getCpuLimit())
                .memRequest(request.getMemRequest())
                .memLimit(request.getMemLimit())
                .minReplicas(request.getMinReplicas())
                .maxReplicas(request.getMaxReplicas())
                .workersPerCore(request.getWorkersPerCore())
                .build();
    }

    /**
     * 클라이언트 수정 요청으로 변환
     */
    private AppUpdateRequest convertToClientUpdateRequest(AgentAppUpdateRequest request) {
        return AppUpdateRequest.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    /**
     * 클라이언트 배포 요청으로 변환
     */
    private AppDeployRequest convertToClientDeployRequest(AgentAppDeployRequest request) {
        return AppDeployRequest.builder()
                .versionDescription(request.getVersionDescription())
                .targetType(request.getTargetType())
                .servingType(request.getServingType())
                .cpuRequest(request.getCpuRequest())
                .cpuLimit(request.getCpuLimit())
                .memRequest(request.getMemRequest())
                .memLimit(request.getMemLimit())
                .minReplicas(request.getMinReplicas())
                .maxReplicas(request.getMaxReplicas())
                .workersPerCore(request.getWorkersPerCore())
                .build();
    }

    /**
     * 클라이언트 응답을 App 응답으로 변환
     */
    private AgentAppResponse convertToAppResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentAppResponse.builder()
                    .id(getString(dataMap, "id"))
                    .name(getString(dataMap, "name"))
                    .description(getString(dataMap, "description"))
                    .targetType(getString(dataMap, "target_type"))
                    .modelList(getStringList(dataMap, "model_list"))
                    .servingType(getString(dataMap, "serving_type"))
                    .registryUrl(getString(dataMap, "registry_url"))
                    .imageTag(getString(dataMap, "image_tag"))
                    .cpuRequest(getInteger(dataMap, "cpu_request"))
                    .cpuLimit(getInteger(dataMap, "cpu_limit"))
                    .memRequest(getInteger(dataMap, "mem_request"))
                    .memLimit(getInteger(dataMap, "mem_limit"))
                    .minReplicas(getInteger(dataMap, "min_replicas"))
                    .maxReplicas(getInteger(dataMap, "max_replicas"))
                    .workersPerCore(getInteger(dataMap, "workers_per_core"))
                    .status(getString(dataMap, "status"))
                    .version(getString(dataMap, "version"))
                    .createdBy(getString(dataMap, "created_by"))
                    .updatedBy(getString(dataMap, "updated_by"))
                    .createdAt(getLocalDateTime(dataMap, "created_at"))
                    .updatedAt(getLocalDateTime(dataMap, "updated_at"))
                    .isDeleted(getBoolean(dataMap, "is_deleted"))
                    .build();
                    
        } catch (Exception e) {
            log.error("Agent App 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Agent App 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    /**
     * 클라이언트 응답을 App 목록 응답으로 변환
     */
    private AgentAppListResponse convertToAppListResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return AgentAppListResponse.builder()
                        .data(Collections.emptyList())
                        .totalCount(0L)
                        .build();
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> appList = (List<Map<String, Object>>) dataMap.get("apps");
            
            List<AgentAppResponse> apps = Collections.emptyList();
            if (appList != null) {
                apps = appList.stream()
                        .map(this::convertMapToAppResponse)
                        .toList();
            }

            return AgentAppListResponse.builder()
                    .data(apps)
                    .totalCount(getLong(dataMap, "total_count"))
                    .searchCriteria(getString(dataMap, "search_criteria"))
                    .pagination(createPagination(dataMap))
                    .build();
                    
        } catch (Exception e) {
            log.error("Agent App 목록 응답 변환 실패: {}", e.getMessage(), e);
            return AgentAppListResponse.builder()
                    .data(Collections.emptyList())
                    .totalCount(0L)
                    .build();
        }
    }

    /**
     * Map을 AgentAppResponse로 변환
     */
    private AgentAppResponse convertMapToAppResponse(Map<String, Object> dataMap) {
        return AgentAppResponse.builder()
                .id(getString(dataMap, "id"))
                .name(getString(dataMap, "name"))
                .description(getString(dataMap, "description"))
                .targetType(getString(dataMap, "target_type"))
                .modelList(getStringList(dataMap, "model_list"))
                .servingType(getString(dataMap, "serving_type"))
                .registryUrl(getString(dataMap, "registry_url"))
                .imageTag(getString(dataMap, "image_tag"))
                .cpuRequest(getInteger(dataMap, "cpu_request"))
                .cpuLimit(getInteger(dataMap, "cpu_limit"))
                .memRequest(getInteger(dataMap, "mem_request"))
                .memLimit(getInteger(dataMap, "mem_limit"))
                .minReplicas(getInteger(dataMap, "min_replicas"))
                .maxReplicas(getInteger(dataMap, "max_replicas"))
                .workersPerCore(getInteger(dataMap, "workers_per_core"))
                .status(getString(dataMap, "status"))
                .version(getString(dataMap, "version"))
                .createdBy(getString(dataMap, "created_by"))
                .updatedBy(getString(dataMap, "updated_by"))
                .createdAt(getLocalDateTime(dataMap, "created_at"))
                .updatedAt(getLocalDateTime(dataMap, "updated_at"))
                .isDeleted(getBoolean(dataMap, "is_deleted"))
                .build();
    }

    /**
     * 배포 목록 응답 변환
     */
    private List<AgentAppDeploymentResponse> convertToDeploymentListResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return Collections.emptyList();
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> deploymentList = (List<Map<String, Object>>) dataMap.get("deployments");
            
            if (deploymentList != null) {
                return deploymentList.stream()
                        .map(this::convertMapToDeploymentResponse)
                        .toList();
            }

            return Collections.emptyList();
                    
        } catch (Exception e) {
            log.error("배포 목록 응답 변환 실패: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    /**
     * 배포 응답 변환
     */
    private AgentAppDeploymentResponse convertToDeploymentResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return convertMapToDeploymentResponse(dataMap);
                    
        } catch (Exception e) {
            log.error("배포 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("배포 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    /**
     * Map을 AgentAppDeploymentResponse로 변환
     */
    private AgentAppDeploymentResponse convertMapToDeploymentResponse(Map<String, Object> dataMap) {
        return AgentAppDeploymentResponse.builder()
                .id(getString(dataMap, "id"))
                .appId(getString(dataMap, "app_id"))
                .version(getString(dataMap, "version"))
                .versionDescription(getString(dataMap, "version_description"))
                .status(getString(dataMap, "status"))
                .targetType(getString(dataMap, "target_type"))
                .imageTag(getString(dataMap, "image_tag"))
                .cpuRequest(getInteger(dataMap, "cpu_request"))
                .cpuLimit(getInteger(dataMap, "cpu_limit"))
                .memRequest(getInteger(dataMap, "mem_request"))
                .memLimit(getInteger(dataMap, "mem_limit"))
                .minReplicas(getInteger(dataMap, "min_replicas"))
                .maxReplicas(getInteger(dataMap, "max_replicas"))
                .currentReplicas(getInteger(dataMap, "current_replicas"))
                .createdBy(getString(dataMap, "created_by"))
                .createdAt(getLocalDateTime(dataMap, "created_at"))
                .updatedAt(getLocalDateTime(dataMap, "updated_at"))
                .build();
    }

    /**
     * API 키 목록 변환
     */
    private List<String> convertToApiKeyList(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return Collections.emptyList();
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            @SuppressWarnings("unchecked")
            List<String> apiKeys = (List<String>) dataMap.get("api_keys");
            
            return apiKeys != null ? apiKeys : Collections.emptyList();
                    
        } catch (Exception e) {
            log.error("API 키 목록 변환 실패: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    /**
     * API 키 추출
     */
    private String extractApiKey(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return getString(dataMap, "api_key");
                    
        } catch (Exception e) {
            log.error("API 키 추출 실패: {}", e.getMessage(), e);
            throw new RuntimeException("API 키 추출에 실패했습니다: " + e.getMessage(), e);
        }
    }

    /**
     * App 응답 목록 변환
     */
    private List<AgentAppResponse> convertToAppResponseList(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return Collections.emptyList();
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> appList = (List<Map<String, Object>>) dataMap.get("apps");
            
            if (appList != null) {
                return appList.stream()
                        .map(this::convertMapToAppResponse)
                        .toList();
            }

            return Collections.emptyList();
                    
        } catch (Exception e) {
            log.error("App 응답 목록 변환 실패: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    /**
     * 페이지네이션 정보 생성
     */
    private AgentAppListResponse.Pagination createPagination(Map<String, Object> dataMap) {
        return AgentAppListResponse.Pagination.builder()
                .currentPage(getInteger(dataMap, "current_page"))
                .pageSize(getInteger(dataMap, "page_size"))
                .totalElements(getLong(dataMap, "total_elements"))
                .totalPages(getInteger(dataMap, "total_pages"))
                .first(getBoolean(dataMap, "first"))
                .last(getBoolean(dataMap, "last"))
                .build();
    }

    // ==================== 유틸리티 메서드 ====================

    private String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value != null ? value.toString() : null;
    }

    private Integer getInteger(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return null;
    }

    private Long getLong(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return null;
    }

    private Boolean getBoolean(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }

    private LocalDateTime getLocalDateTime(Map<String, Object> map, String key) {
        String value = getString(map, key);
        if (value != null) {
            try {
                return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (Exception e) {
                log.warn("날짜 파싱 실패 - key: {}, value: {}", key, value);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<String> getStringList(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof List) {
            List<?> list = (List<?>) value;
            return list.stream()
                    .filter(item -> item != null)
                    .map(Object::toString)
                    .toList();
        }
        return new ArrayList<>();
    }
}
