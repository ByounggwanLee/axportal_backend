package com.skax.aiportal.service.agent.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skax.aiportal.client.sktai.agent.SktAiAgentToolsClient;
import com.skax.aiportal.client.sktai.agent.dto.request.ToolRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.dto.agent.request.AgentToolCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentToolUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentToolListResponse;
import com.skax.aiportal.dto.agent.response.AgentToolResponse;
import com.skax.aiportal.service.agent.AgentToolsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT Agent Tool 서비스 구현 클래스
 * 
 * <p>SKT AI 플랫폼의 Agent Tool 관련 비즈니스 로직을 구현합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktAgentToolsServiceImpl implements AgentToolsService {

    private final SktAiAgentToolsClient agentToolsClient;

    @Override
    public AgentToolListResponse getTools(String name, Integer page, Integer size, String sort, String filter, String search) {
        log.info("Tool 목록 조회 - name: {}, page: {}, size: {}, sort: {}, filter: {}, search: {}", 
                name, page, size, sort, filter, search);
        
        try {
            CommonResponse clientResponse = agentToolsClient.getTools(name, page, size, sort, filter, search);
            
            AgentToolListResponse response = convertToToolListResponse(clientResponse);
            
            log.info("Tool 목록 조회 성공 - 조회된 Tool 수: {}", 
                    response.getData() != null ? response.getData().size() : 0);
            return response;
            
        } catch (Exception e) {
            log.error("Tool 목록 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("Tool 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentToolResponse getToolById(String toolId) {
        log.info("Tool 상세 조회 - toolId: {}", toolId);
        
        try {
            CommonResponse clientResponse = agentToolsClient.getToolById(toolId);
            
            AgentToolResponse response = convertToToolResponse(clientResponse);
            
            log.info("Tool 상세 조회 성공 - toolId: {}, name: {}", toolId, response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("Tool 상세 조회 실패: toolId={}, 오류={}", toolId, e.getMessage(), e);
            throw new RuntimeException("Tool 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentToolResponse createTool(AgentToolCreateRequest request) {
        log.info("Tool 생성 - name: {}, toolType: {}", request.getName(), request.getToolType());
        
        try {
            ToolRequest clientRequest = convertToClientCreateRequest(request);
            
            CommonResponse clientResponse = agentToolsClient.addTool(clientRequest);
            
            AgentToolResponse response = convertToToolResponse(clientResponse);
            
            log.info("Tool 생성 성공 - id: {}, name: {}", response.getId(), response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("Tool 생성 실패: name={}, 오류={}", request.getName(), e.getMessage(), e);
            throw new RuntimeException("Tool 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public AgentToolResponse updateTool(String toolId, AgentToolUpdateRequest request) {
        log.info("Tool 수정 - toolId: {}", toolId);
        
        try {
            ToolRequest clientRequest = convertToClientUpdateRequest(request);
            
            CommonResponse clientResponse = agentToolsClient.updateTool(toolId, clientRequest);
            
            AgentToolResponse response = convertToToolResponse(clientResponse);
            
            log.info("Tool 수정 성공 - toolId: {}", toolId);
            return response;
            
        } catch (Exception e) {
            log.error("Tool 수정 실패: toolId={}, 오류={}", toolId, e.getMessage(), e);
            throw new RuntimeException("Tool 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteTool(String toolId) {
        log.info("Tool 삭제 - toolId: {}", toolId);
        
        try {
            agentToolsClient.deleteTool(toolId);
            
            log.info("Tool 삭제 성공 - toolId: {}", toolId);
            
        } catch (Exception e) {
            log.error("Tool 삭제 실패: toolId={}, 오류={}", toolId, e.getMessage(), e);
            throw new RuntimeException("Tool 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void hardDeleteTools() {
        log.info("모든 삭제된 Tool 완전 삭제");
        
        try {
            agentToolsClient.hardDeleteTools();
            
            log.info("모든 삭제된 Tool 완전 삭제 완료");
            
        } catch (Exception e) {
            log.error("모든 삭제된 Tool 완전 삭제 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("모든 삭제된 Tool 완전 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // ==================== 변환 메서드 ====================

    /**
     * 클라이언트 생성 요청으로 변환
     */
    private ToolRequest convertToClientCreateRequest(AgentToolCreateRequest request) {
        return ToolRequest.builder()
                .name(request.getName())
                .description(request.getDescription())
                .toolType(request.getToolType())
                //--lbg .code(request.getCode())
                //--lbg .serverUrl(request.getServerUrl())
                //--lbg .method(request.getMethod())
                //--lbg .apiParam(request.getApiParam())
                .build();
    }

    /**
     * 클라이언트 수정 요청으로 변환
     */
    private ToolRequest convertToClientUpdateRequest(AgentToolUpdateRequest request) {
        return ToolRequest.builder()
                .name(request.getName())
                .description(request.getDescription())
                .toolType(request.getToolType())
                //--lbg .code(request.getCode())
                //--lbg .serverUrl(request.getServerUrl())
                //--lbg .method(request.getMethod())
                //--lbg .apiParam(request.getApiParam())
                .build();
    }

    /**
     * 클라이언트 응답을 Tool 응답으로 변환
     */
    private AgentToolResponse convertToToolResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                throw new RuntimeException("응답 데이터가 없습니다");
            }

            // CommonResponse의 data를 Map으로 변환
            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            return AgentToolResponse.builder()
                    .id(getString(dataMap, "id"))
                    .name(getString(dataMap, "name"))
                    .description(getString(dataMap, "description"))
                    .toolType(getString(dataMap, "tool_type"))
                    //--lbg .code(getString(dataMap, "code"))
                    //--lbg .serverUrl(getString(dataMap, "server_url"))
                    //--lbg .method(getString(dataMap, "method"))
                    //--lbg apiParam(getString(dataMap, "api_param"))
                    .createdBy(getString(dataMap, "created_by"))
                    .updatedBy(getString(dataMap, "updated_by"))
                    //--lbg .isDeleted(getBoolean(dataMap, "is_deleted"))
                    .version(getString(dataMap, "version"))
                    .status(getString(dataMap, "status"))
                    .build();
                    
        } catch (Exception e) {
            log.error("Tool 응답 변환 실패: {}", e.getMessage(), e);
            throw new RuntimeException("Tool 응답 변환에 실패했습니다: " + e.getMessage(), e);
        }
    }

    /**
     * 클라이언트 응답을 Tool 목록 응답으로 변환
     */
    private AgentToolListResponse convertToToolListResponse(CommonResponse clientResponse) {
        try {
            if (clientResponse.getData() == null) {
                return AgentToolListResponse.builder()
                        .data(Collections.emptyList())
                        .totalCount(0L)
                        .build();
            }

            // CommonResponse의 data를 처리
            @SuppressWarnings("unchecked")
            Map<String, Object> dataMap = (Map<String, Object>) clientResponse.getData();
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> toolList = (List<Map<String, Object>>) dataMap.get("tools");
            
            List<AgentToolResponse> tools = Collections.emptyList();
            if (toolList != null) {
                tools = toolList.stream()
                        .map(this::convertMapToToolResponse)
                        .toList();
            }

            return AgentToolListResponse.builder()
                    .data(tools)
                    .totalCount(getLong(dataMap, "total_count"))
                    .searchCriteria(getString(dataMap, "search_criteria"))
                    .pagination(createPagination(dataMap))
                    .build();
                    
        } catch (Exception e) {
            log.error("Tool 목록 응답 변환 실패: {}", e.getMessage(), e);
            return AgentToolListResponse.builder()
                    .data(Collections.emptyList())
                    .totalCount(0L)
                    .build();
        }
    }

    /**
     * Map을 AgentToolResponse로 변환
     */
    private AgentToolResponse convertMapToToolResponse(Map<String, Object> dataMap) {
        return AgentToolResponse.builder()
                .id(getString(dataMap, "id"))
                .name(getString(dataMap, "name"))
                .description(getString(dataMap, "description"))
                .toolType(getString(dataMap, "tool_type"))
                //--lbg .code(getString(dataMap, "code"))
                //--lbg .serverUrl(getString(dataMap, "server_url"))
                //--lbg method(getString(dataMap, "method"))
                //--lbg .apiParam(getString(dataMap, "api_param"))
                .createdBy(getString(dataMap, "created_by"))
                .updatedBy(getString(dataMap, "updated_by"))
                //--lbg .isDeleted(getBoolean(dataMap, "is_deleted"))
                .version(getString(dataMap, "version"))
                .status(getString(dataMap, "status"))
                .build();
    }

    /**
     * 페이지네이션 정보 생성
     */
    private AgentToolListResponse.Pagination createPagination(Map<String, Object> dataMap) {
        return AgentToolListResponse.Pagination.builder()
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
}
