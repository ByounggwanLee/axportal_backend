package com.skax.aiportal.client.sktai.serving.service;

import com.skax.aiportal.client.sktai.serving.SktAiServingClient;
import com.skax.aiportal.client.sktai.serving.SktAiAgentServingClient;
import com.skax.aiportal.client.sktai.serving.SktAiApiKeyClient;
import com.skax.aiportal.client.sktai.serving.dto.request.*;
import com.skax.aiportal.client.sktai.serving.dto.response.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SKT AI 서빙 서비스
 * 
 * SKT AI 서빙 관련 API 호출을 담당하는 서비스 클래스입니다.
 * 모델 서빙, 에이전트 서빙, API 키 관리 기능을 제공합니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAiServingService {

    private final SktAiServingClient servingClient;
    private final SktAiAgentServingClient agentServingClient;
    private final SktAiApiKeyClient apiKeyClient;

    // ==================== 모델 서빙 관련 메서드 ====================

    /**
     * 서빙 목록 조회
     */
    public ServingListResponse getServings(Integer page, Integer size, String search, String status, String modelType) {
        log.info("서빙 목록 조회 - page: {}, size: {}, search: {}, status: {}, modelType: {}", 
                page, size, search, status, modelType);
        return servingClient.getServings(page, size, search, status, modelType);
    }

    /**
     * 서빙 생성
     */
    public ServingResponse createServing(ServingCreateRequest request) {
        log.info("서빙 생성 - name: {}, modelId: {}", request.getName(), request.getModelId());
        return servingClient.createServing(request);
    }

    /**
     * 서빙 상세 조회
     */
    public ServingResponse getServing(String servingId) {
        log.info("서빙 상세 조회 - servingId: {}", servingId);
        return servingClient.getServing(servingId);
    }

    /**
     * 서빙 수정
     */
    public ServingResponse updateServing(String servingId, ServingUpdateRequest request) {
        log.info("서빙 수정 - servingId: {}", servingId);
        return servingClient.updateServing(servingId, request);
    }

    /**
     * 서빙 삭제
     */
    public void deleteServing(String servingId) {
        log.info("서빙 삭제 - servingId: {}", servingId);
        servingClient.deleteServing(servingId);
    }

    /**
     * 서빙 시작
     */
    public ServingResponse startServing(String servingId) {
        log.info("서빙 시작 - servingId: {}", servingId);
        return servingClient.startServing(servingId);
    }

    /**
     * 서빙 중지
     */
    public ServingResponse stopServing(String servingId) {
        log.info("서빙 중지 - servingId: {}", servingId);
        return servingClient.stopServing(servingId);
    }

    /**
     * 서빙 스케일링
     */
    public ServingResponse scaleServing(String servingId, ServingScaleRequest request) {
        log.info("서빙 스케일링 - servingId: {}, minReplicas: {}, maxReplicas: {}", 
                servingId, request.getMinReplicas(), request.getMaxReplicas());
        return servingClient.scaleServing(servingId, request);
    }

    /**
     * 서빙 가능한 모델 조회
     */
    public List<ServingModelViewResponse> getServingModels(Integer page, Integer size, String search, String modelType) {
        log.info("서빙 가능한 모델 조회 - page: {}, size: {}, search: {}, modelType: {}", 
                page, size, search, modelType);
        return servingClient.getServingModels(page, size, search, modelType);
    }

    // ==================== 에이전트 서빙 관련 메서드 ====================

    /**
     * 에이전트 서빙 목록 조회
     */
    public AgentServingListResponse getAgentServings(Integer page, Integer size, String search, String status) {
        log.info("에이전트 서빙 목록 조회 - page: {}, size: {}, search: {}, status: {}", 
                page, size, search, status);
        return agentServingClient.getAgentServings(page, size, search, status);
    }

    /**
     * 에이전트 서빙 생성
     */
    public AgentServingResponse createAgentServing(AgentServingCreateRequest request) {
        log.info("에이전트 서빙 생성 - deploymentName: {}, appId: {}", 
                request.getDeploymentName(), request.getAppId());
        return agentServingClient.createAgentServing(request);
    }

    /**
     * 에이전트 서빙 상세 조회
     */
    public AgentServingResponse getAgentServing(String agentServingId) {
        log.info("에이전트 서빙 상세 조회 - agentServingId: {}", agentServingId);
        return agentServingClient.getAgentServing(agentServingId);
    }

    /**
     * 에이전트 서빙 수정
     */
    public AgentServingResponse updateAgentServing(String agentServingId, AgentServingUpdateRequest request) {
        log.info("에이전트 서빙 수정 - agentServingId: {}", agentServingId);
        return agentServingClient.updateAgentServing(agentServingId, request);
    }

    /**
     * 에이전트 서빙 삭제
     */
    public void deleteAgentServing(String agentServingId) {
        log.info("에이전트 서빙 삭제 - agentServingId: {}", agentServingId);
        agentServingClient.deleteAgentServing(agentServingId);
    }

    /**
     * 에이전트 서빙 시작
     */
    public AgentServingResponse startAgentServing(String agentServingId) {
        log.info("에이전트 서빙 시작 - agentServingId: {}", agentServingId);
        return agentServingClient.startAgentServing(agentServingId);
    }

    /**
     * 에이전트 서빙 중지
     */
    public AgentServingResponse stopAgentServing(String agentServingId) {
        log.info("에이전트 서빙 중지 - agentServingId: {}", agentServingId);
        return agentServingClient.stopAgentServing(agentServingId);
    }

    /**
     * 에이전트 서빙 스케일링
     */
    public AgentServingResponse scaleAgentServing(String agentServingId, ServingScaleRequest request) {
        log.info("에이전트 서빙 스케일링 - agentServingId: {}, minReplicas: {}, maxReplicas: {}", 
                agentServingId, request.getMinReplicas(), request.getMaxReplicas());
        return agentServingClient.scaleAgentServing(agentServingId, request);
    }

    // ==================== API 키 관리 관련 메서드 ====================

    /**
     * API 키 목록 조회
     */
    public ApiKeyListResponse getApiKeys(Integer page, Integer size, String search, Boolean isActive) {
        log.info("API 키 목록 조회 - page: {}, size: {}, search: {}, isActive: {}", 
                page, size, search, isActive);
        return apiKeyClient.getApiKeys(page, size, search, isActive);
    }

    /**
     * API 키 생성
     */
    public ApiKeyResponse createApiKey(ApiKeyCreateRequest request) {
        log.info("API 키 생성 - name: {}", request.getName());
        return apiKeyClient.createApiKey(request);
    }

    /**
     * API 키 상세 조회
     */
    public ApiKeyResponse getApiKey(String apiKeyId) {
        log.info("API 키 상세 조회 - apiKeyId: {}", apiKeyId);
        return apiKeyClient.getApiKey(apiKeyId);
    }

    /**
     * API 키 수정
     */
    public ApiKeyResponse updateApiKey(String apiKeyId, ApiKeyUpdateRequest request) {
        log.info("API 키 수정 - apiKeyId: {}", apiKeyId);
        return apiKeyClient.updateApiKey(apiKeyId, request);
    }

    /**
     * API 키 삭제
     */
    public void deleteApiKey(String apiKeyId) {
        log.info("API 키 삭제 - apiKeyId: {}", apiKeyId);
        apiKeyClient.deleteApiKey(apiKeyId);
    }

    /**
     * API 키 활성화
     */
    public ApiKeyResponse activateApiKey(String apiKeyId) {
        log.info("API 키 활성화 - apiKeyId: {}", apiKeyId);
        return apiKeyClient.activateApiKey(apiKeyId);
    }

    /**
     * API 키 비활성화
     */
    public ApiKeyResponse deactivateApiKey(String apiKeyId) {
        log.info("API 키 비활성화 - apiKeyId: {}", apiKeyId);
        return apiKeyClient.deactivateApiKey(apiKeyId);
    }

    /**
     * API 키 새로고침
     */
    public ApiKeyResponse refreshApiKey(String apiKeyId) {
        log.info("API 키 새로고침 - apiKeyId: {}", apiKeyId);
        return apiKeyClient.refreshApiKey(apiKeyId);
    }
}
