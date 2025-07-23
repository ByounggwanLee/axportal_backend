package com.skax.aiportal.service.agent;

import java.util.List;
import java.util.Map;
import com.skax.aiportal.dto.agent.request.AgentPromptsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentPromptsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentPromptsResponse;

/**
 * Agent Prompts 서비스 인터페이스
 */
public interface AgentPromptsService {

    List<AgentPromptsResponse> getPrompts(String projectId, Integer page, Integer size, String sort, String filter, String search);
    AgentPromptsResponse getPromptById(String promptUuid);
    AgentPromptsResponse createPrompt(AgentPromptsCreateRequest request);
    AgentPromptsResponse updatePrompt(String promptUuid, AgentPromptsUpdateRequest request);
    void deletePrompt(String promptUuid);
    Map<String, Object> getLatestVersion(String promptUuid, Integer page, Integer size, String sort, String filter, String search);
    List<Map<String, Object>> getVersions(String promptUuid);
    Map<String, Object> testPrompt(String promptUuid);
    void hardDeletePrompts();
}
