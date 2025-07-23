package com.skax.aiportal.service.agent;

import java.util.List;
import java.util.Map;
import com.skax.aiportal.dto.agent.request.AgentGraphsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentGraphsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentGraphsResponse;

/**
 * Agent Graphs 서비스 인터페이스
 */
public interface AgentGraphsService {

    List<AgentGraphsResponse> getGraphs(String projectId, Integer page, Integer size, String sort, String filter, String search);
    AgentGraphsResponse getGraphById(String graphUuid);
    AgentGraphsResponse createGraph(AgentGraphsCreateRequest request);
    AgentGraphsResponse updateGraph(String graphUuid, AgentGraphsUpdateRequest request);
    void deleteGraph(String graphUuid);
    Map<String, Object> getLatestVersion(String graphUuid, Integer page, Integer size, String sort, String filter, String search);
    List<Map<String, Object>> getVersions(String graphUuid);
    Map<String, Object> testGraph(String graphUuid);
    void hardDeleteGraphs();
}
