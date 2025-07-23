package com.skax.aiportal.service.agent.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentGraphsClient;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.request.AgentGraphsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentGraphsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentGraphsResponse;
import com.skax.aiportal.service.agent.AgentGraphsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT Agent Graphs 서비스 구현 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentGraphsServiceImpl implements AgentGraphsService {

    private final SktAiAgentGraphsClient agentGraphsClient;

    @Override
    public List<AgentGraphsResponse> getGraphs(String projectId, Integer page, Integer size, String sort, String filter, String search) {
        log.info("Graphs 목록 조회 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        try {
            CommonResponse clientResponse = agentGraphsClient.getGraphs(page, size, sort, filter, search);
            return convertToGraphsResponseList(clientResponse);
        } catch (Exception e) {
            log.error("Graphs 목록 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graphs 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentGraphsResponse getGraphById(String graphUuid) {
        log.info("Graph 상세 조회 - graphUuid: {}", graphUuid);
        
        try {
            CommonResponse clientResponse = agentGraphsClient.getGraphById(graphUuid);
            return convertToGraphsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Graph 상세 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graph 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentGraphsResponse createGraph(AgentGraphsCreateRequest request) {
        log.info("Graph 생성 - name: {}", request.getName());
        
        try {
            // 클라이언트 요청 객체로 변환 필요
            CommonResponse clientResponse = agentGraphsClient.createGraph(null);
            return convertToGraphsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Graph 생성 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graph 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentGraphsResponse updateGraph(String graphUuid, AgentGraphsUpdateRequest request) {
        log.info("Graph 수정 - graphUuid: {}", graphUuid);
        
        try {
            // 클라이언트 요청 객체로 변환 필요
            CommonResponse clientResponse = agentGraphsClient.updateGraph(graphUuid, null);
            return convertToGraphsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Graph 수정 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graph 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteGraph(String graphUuid) {
        log.info("Graph 삭제 - graphUuid: {}", graphUuid);
        
        try {
            agentGraphsClient.deleteGraph(graphUuid);
        } catch (Exception e) {
            log.error("Graph 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graph 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> getLatestVersion(String graphUuid, Integer page, Integer size, String sort, String filter, String search) {
        return Collections.emptyMap();
    }

    @Override
    public List<Map<String, Object>> getVersions(String graphUuid) {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> testGraph(String graphUuid) {
        return Collections.emptyMap();
    }

    @Override
    public void hardDeleteGraphs() {
        log.info("모든 삭제된 Graphs 완전 삭제");
        
        try {
            agentGraphsClient.hardDeleteGraphs();
        } catch (Exception e) {
            log.error("Graphs 완전 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graphs 완전 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // 변환 메서드들 (간소화된 구현)
    @SuppressWarnings("unchecked")
    private AgentGraphsResponse convertToGraphsResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentGraphsResponse.builder()
                    .uuid(getString(dataMap, "uuid"))
                    .projectId(getString(dataMap, "project_id"))
                    .name(getString(dataMap, "name"))
                    .description(getString(dataMap, "description"))
                    .graphData(getString(dataMap, "graph_data"))
                    .currentVersionId(getString(dataMap, "current_version_id"))
                    .versionDescription(getString(dataMap, "version_description"))
                    .isPublic(getBoolean(dataMap, "is_public"))
                    .isActive(getBoolean(dataMap, "is_active"))
                    .status(getString(dataMap, "status"))
                    .createdBy(getString(dataMap, "created_by"))
                    .updatedBy(getString(dataMap, "updated_by"))
                    .isDeleted(getBoolean(dataMap, "is_deleted"))
                    .build();
        } catch (Exception e) {
            log.error("Graphs 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Graphs 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    private List<AgentGraphsResponse> convertToGraphsResponseList(CommonResponse clientResponse) {
        return Collections.emptyList();
    }

    private String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value != null ? value.toString() : null;
    }

    private Boolean getBoolean(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }
}
