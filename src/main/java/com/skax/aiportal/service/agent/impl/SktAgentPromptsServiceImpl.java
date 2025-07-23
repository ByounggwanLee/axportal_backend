package com.skax.aiportal.service.agent.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentPromptsClient;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.request.AgentPromptsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentPromptsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentPromptsResponse;
import com.skax.aiportal.service.agent.AgentPromptsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT Agent Prompts 서비스 구현 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentPromptsServiceImpl implements AgentPromptsService {

    private final SktAiAgentPromptsClient agentPromptsClient;

    @Override
    public List<AgentPromptsResponse> getPrompts(String projectId, Integer page, Integer size, String sort, String filter, String search) {
        log.info("Prompts 목록 조회 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        try {
            CommonResponse clientResponse = agentPromptsClient.getPrompts(page, size, sort, filter, search);
            return convertToPromptsResponseList(clientResponse);
        } catch (Exception e) {
            log.error("Prompts 목록 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompts 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentPromptsResponse getPromptById(String promptUuid) {
        log.info("Prompt 상세 조회 - promptUuid: {}", promptUuid);
        
        try {
            CommonResponse clientResponse = agentPromptsClient.getPromptById(promptUuid);
            return convertToPromptsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Prompt 상세 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompt 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentPromptsResponse createPrompt(AgentPromptsCreateRequest request) {
        log.info("Prompt 생성 - name: {}", request.getName());
        
        try {
            CommonResponse clientResponse = agentPromptsClient.createPrompts(null);
            return convertToPromptsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Prompt 생성 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompt 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentPromptsResponse updatePrompt(String promptUuid, AgentPromptsUpdateRequest request) {
        log.info("Prompt 수정 - promptUuid: {}", promptUuid);
        
        try {
            CommonResponse clientResponse = agentPromptsClient.updatePrompts(promptUuid, null);
            return convertToPromptsResponse(clientResponse);
        } catch (Exception e) {
            log.error("Prompt 수정 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompt 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletePrompt(String promptUuid) {
        log.info("Prompt 삭제 - promptUuid: {}", promptUuid);
        
        try {
            agentPromptsClient.deletePrompts(promptUuid);
        } catch (Exception e) {
            log.error("Prompt 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompt 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> getLatestVersion(String promptUuid, Integer page, Integer size, String sort, String filter, String search) {
        return Collections.emptyMap();
    }

    @Override
    public List<Map<String, Object>> getVersions(String promptUuid) {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> testPrompt(String promptUuid) {
        return Collections.emptyMap();
    }

    @Override
    public void hardDeletePrompts() {
        log.info("모든 삭제된 Prompts 완전 삭제");
        
        try {
            agentPromptsClient.hardDeletePrompts();
        } catch (Exception e) {
            log.error("Prompts 완전 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompts 완전 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // 변환 메서드들 (간소화된 구현)
    @SuppressWarnings("unchecked")
    private AgentPromptsResponse convertToPromptsResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentPromptsResponse.builder()
                    .uuid(getString(dataMap, "uuid"))
                    .projectId(getString(dataMap, "project_id"))
                    .name(getString(dataMap, "name"))
                    .description(getString(dataMap, "description"))
                    .promptContent(getString(dataMap, "prompt_content"))
                    .promptType(getString(dataMap, "prompt_type"))
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
            log.error("Prompts 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Prompts 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    private List<AgentPromptsResponse> convertToPromptsResponseList(CommonResponse clientResponse) {
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
