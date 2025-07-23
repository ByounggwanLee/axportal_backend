package com.skax.aiportal.service.agent;

import java.util.List;

import com.skax.aiportal.dto.agent.request.AgentAppCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentAppDeployRequest;
import com.skax.aiportal.dto.agent.request.AgentAppUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentAppDeploymentResponse;
import com.skax.aiportal.dto.agent.response.AgentAppListResponse;
import com.skax.aiportal.dto.agent.response.AgentAppResponse;

/**
 * Agent Apps 서비스 인터페이스
 * 
 * <p>Agent 애플리케이션 관련 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public interface AgentAppsService {

    /**
     * Agent App 목록 조회
     * 
     * @param targetType 대상 타입
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Agent App 목록 응답
     */
    AgentAppListResponse getApps(String targetType, Integer page, Integer size, String sort, String filter, String search);

    /**
     * Agent App 상세 조회
     * 
     * @param appId App ID
     * @return Agent App 상세 정보
     */
    AgentAppResponse getAppById(String appId);

    /**
     * Agent App 생성 및 배포
     * 
     * @param request App 생성 요청
     * @return 생성된 Agent App 정보
     */
    AgentAppResponse createAndDeployApp(AgentAppCreateRequest request);

    /**
     * Agent App 수정
     * 
     * @param appId App ID
     * @param request App 수정 요청
     * @return 수정된 Agent App 정보
     */
    AgentAppResponse updateApp(String appId, AgentAppUpdateRequest request);

    /**
     * Agent App 삭제
     * 
     * @param appId App ID
     */
    void deleteApp(String appId);

    /**
     * App 배포 목록 조회
     * 
     * @param appId App ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 배포 목록
     */
    List<AgentAppDeploymentResponse> getDeployments(String appId, Integer page, Integer size, String sort, String filter, String search);

    /**
     * App 배포 추가
     * 
     * @param appId App ID
     * @param request 배포 요청
     * @return 배포 정보
     */
    AgentAppDeploymentResponse addDeployment(String appId, AgentAppDeployRequest request);

    /**
     * 배포 상세 조회
     * 
     * @param deploymentId 배포 ID
     * @return 배포 상세 정보
     */
    AgentAppDeploymentResponse getDeploymentById(String deploymentId);

    /**
     * 배포 중지
     * 
     * @param deploymentId 배포 ID
     */
    void stopDeployment(String deploymentId);

    /**
     * 배포 재시작
     * 
     * @param deploymentId 배포 ID
     */
    void restartDeployment(String deploymentId);

    /**
     * 배포 삭제
     * 
     * @param deploymentId 배포 ID
     */
    void deleteDeployment(String deploymentId);

    /**
     * App API 키 목록 조회
     * 
     * @param appId App ID
     * @return API 키 목록
     */
    List<String> getApiKeys(String appId);

    /**
     * App API 키 생성
     * 
     * @param appId App ID
     * @return 생성된 API 키
     */
    String createApiKey(String appId);

    /**
     * App API 키 재생성
     * 
     * @param appId App ID
     * @param apiKey API 키
     * @return 재생성된 API 키
     */
    String regenerateApiKey(String appId, String apiKey);

    /**
     * App API 키 삭제
     * 
     * @param appId App ID
     * @param apiKey API 키
     */
    void deleteApiKey(String appId, String apiKey);

    /**
     * 모델별 App 목록 조회
     * 
     * @param modelName 모델 이름
     * @return 모델별 App 목록
     */
    List<AgentAppResponse> getAppsByModel(String modelName);

    /**
     * 지식별 App 목록 조회
     * 
     * @param knowledgeId 지식 ID
     * @return 지식별 App 목록
     */
    List<AgentAppResponse> getAppsByKnowledge(String knowledgeId);

    /**
     * Phoenix 프로젝트 ID 조회
     * 
     * @param projectName 프로젝트 이름
     * @return 프로젝트 ID
     */
    String getProjectId(String projectName);

    /**
     * 삭제된 모든 App 완전 삭제
     */
    void hardDeleteApps();
}
