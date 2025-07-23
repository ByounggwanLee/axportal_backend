package com.skax.aiportal.service.agent.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentFewShotsClient;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotCommentCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.request.AgentFewShotsCommentCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentFewShotsListResponse;
import com.skax.aiportal.dto.agent.response.AgentFewShotsResponse;
import com.skax.aiportal.service.agent.AgentFewShotsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.multipart.MultipartFile;

/**
 * SKT Agent FewShots 서비스 구현 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentFewShotsServiceImpl implements AgentFewShotsService {

    private final SktAiAgentFewShotsClient agentFewShotsClient;

    @Override
    public AgentFewShotsListResponse getFewShots(String projectId, Integer page, Integer size, String sort, String filter, String search) {
        log.info("FewShots 목록 조회 - projectId: {}, page: {}, size: {}", projectId, page, size);
        
        try {
            CommonResponse clientResponse = agentFewShotsClient.getAllFewShots(projectId, page, size, sort, filter, search);
            return convertToFewShotsListResponse(clientResponse);
        } catch (Exception e) {
            log.error("FewShots 목록 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentFewShotsResponse getFewShotById(String fewShotUuid) {
        log.info("FewShots 상세 조회 - fewShotUuid: {}", fewShotUuid);
        
        try {
            CommonResponse clientResponse = agentFewShotsClient.getFewShts(fewShotUuid);
            return convertToFewShotsResponse(clientResponse);
        } catch (Exception e) {
            log.error("FewShots 상세 조회 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentFewShotsResponse createFewShots(AgentFewShotsCreateRequest request) {
        log.info("FewShots 생성 - name: {}", request.getName());
        
        try {
            FewShotsCreateRequest clientRequest = convertToClientCreateRequest(request);
            CommonResponse clientResponse = agentFewShotsClient.createFewShots(clientRequest);
            return convertToFewShotsResponse(clientResponse);
        } catch (Exception e) {
            log.error("FewShots 생성 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentFewShotsResponse updateFewShots(String fewShotUuid, AgentFewShotsUpdateRequest request) {
        log.info("FewShots 수정 - fewShotUuid: {}", fewShotUuid);
        
        try {
            FewShotsUpdateRequest clientRequest = convertToClientUpdateRequest(request);
            CommonResponse clientResponse = agentFewShotsClient.updateFewShots(fewShotUuid, clientRequest);
            return convertToFewShotsResponse(clientResponse);
        } catch (Exception e) {
            log.error("FewShots 수정 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteFewShots(String fewShotUuid) {
        log.info("FewShots 삭제 - fewShotUuid: {}", fewShotUuid);
        
        try {
            agentFewShotsClient.deleteFewShots(fewShotUuid);
        } catch (Exception e) {
            log.error("FewShots 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public byte[] exportTemplate(String fewShotUuid) {
        // 구현 필요
        return new byte[0];
    }

    @Override
    public Map<String, Object> importFewShots(String versionId, MultipartFile file, Boolean overwrite) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> getLatestVersion(String fewShotUuid, Integer page, Integer size, String sort, String filter, String search) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public List<Map<String, Object>> getFewShotItems(String versionId, Integer page, Integer size, String sort, String filter, String search) {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public List<Map<String, Object>> getDependencies(String versionId) {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public List<String> getTags(String versionId) {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public List<String> getAllTags() {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public List<Map<String, Object>> getComments(String versionId, Integer page, Integer size, String sort) {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> createComment(String versionId, AgentFewShotsCommentCreateRequest request) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public List<Map<String, Object>> getVersions(String fewShotUuid) {
        // 구현 필요
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> updateComment(String commentUuid, AgentFewShotsCommentCreateRequest request) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public void deleteComment(String commentUuid) {
        // 구현 필요
    }

    @Override
    public Map<String, Object> getApiInfo(String fewShotUuid) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Object> testFewShots(String fewShotUuid) {
        // 구현 필요
        return Collections.emptyMap();
    }

    @Override
    public void hardDeleteFewShots() {
        log.info("모든 삭제된 FewShots 완전 삭제");
        
        try {
            agentFewShotsClient.hardDeleteFewShots();
        } catch (Exception e) {
            log.error("FewShots 완전 삭제 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 완전 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // ==================== 변환 메서드 ====================

    private FewShotsCreateRequest convertToClientCreateRequest(AgentFewShotsCreateRequest request) {
        return FewShotsCreateRequest.builder()
                .projectId(request.getProjectId())
                .name(request.getName())
                // .description(request.getDescription()) // 해당 필드가 없으므로 주석 처리 또는 올바른 필드명으로 수정
                .tags(convertTags(request.getTags()))
                // .versionDescription(request.getVersionDescription()) // FewShotsCreateRequestBuilder에 해당 메서드가 없음
                // .content(request.getContent()) // FewShotsCreateRequestBuilder에 해당 메서드가 없음
                // .isPublic(request.getIsPublic())
                // .isActive(request.getIsActive())
                .build();
    }

    /**
     * tags 필드를 FewShotsTag 리스트로 변환
     * @param tagsString 콤마로 구분된 태그 문자열
     * @return FewShotsTag 리스트
     */
    private List<FewShotsCreateRequest.FewShotsTag> convertTags(String tagsString) {
        if (tagsString == null || tagsString.isBlank()) {
            return Collections.emptyList();
        }
        // 콤마로 분리하여 FewShotsTag 객체로 변환
        return java.util.Arrays.stream(tagsString.split(","))
                .map(String::trim)
                .filter(tag -> !tag.isEmpty())
                .<FewShotsCreateRequest.FewShotsTag>map(tag -> FewShotsCreateRequest.FewShotsTag.builder().tag(tag).build())
                .toList();
    }

    private FewShotsUpdateRequest convertToClientUpdateRequest(AgentFewShotsUpdateRequest request) {
        return FewShotsUpdateRequest.builder()
                // .name(request.getName()) // 해당 필드가 없으므로 주석 처리 또는 올바른 필드명으로 수정
                // .description(request.getDescription()) // FewShotsUpdateRequestBuilder에 해당 메서드가 없음
                .tags(convertTags(request.getTags()))
                // .versionDescription(request.getVersionDescription()) // 해당 메서드가 없음
                // .content(request.getContent()) // FewShotsUpdateRequestBuilder에 해당 메서드가 없음
                // .isPublic(request.getIsPublic()) // FewShotsUpdateRequestBuilder에 해당 메서드가 없음
                // .isActive(request.getIsActive()) // FewShotsUpdateRequestBuilder에 해당 메서드가 없음
                .build();
    }

    @SuppressWarnings("unchecked")
    private AgentFewShotsResponse convertToFewShotsResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentFewShotsResponse.builder()
                    .uuid(getString(dataMap, "uuid"))
                    .projectId(getString(dataMap, "project_id"))
                    .name(getString(dataMap, "name"))
                    .description(getString(dataMap, "description"))
                    .currentVersionId(getString(dataMap, "current_version_id"))
                    .versionDescription(getString(dataMap, "version_description"))
                    .content(getString(dataMap, "content"))
                    .itemCount(getInteger(dataMap, "item_count"))
                    .isPublic(getBoolean(dataMap, "is_public"))
                    .isActive(getBoolean(dataMap, "is_active"))
                    .status(getString(dataMap, "status"))
                    .createdBy(getString(dataMap, "created_by"))
                    .updatedBy(getString(dataMap, "updated_by"))
                    .isDeleted(getBoolean(dataMap, "is_deleted"))
                    .build();
        } catch (Exception e) {
            log.error("FewShots 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("FewShots 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    private AgentFewShotsListResponse convertToFewShotsListResponse(CommonResponse clientResponse) {
        // 간소화된 구현 - 실제로는 더 상세한 변환 로직 필요
        return AgentFewShotsListResponse.builder()
                .data(Collections.emptyList())
                .totalCount(0L)
                .build();
    }

    // 유틸리티 메서드들
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

    private Boolean getBoolean(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }
}
