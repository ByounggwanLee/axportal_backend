package com.skax.aiportal.service.agent;

import com.skax.aiportal.dto.agent.request.AgentToolCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentToolUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentToolListResponse;
import com.skax.aiportal.dto.agent.response.AgentToolResponse;

/**
 * Agent Tools 서비스 인터페이스
 * 
 * <p>Agent Tool 관리 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public interface AgentToolsService {

    /**
     * Tool 목록 조회
     * 
     * @param name Tool 이름 필터
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Tool 목록
     */
    AgentToolListResponse getTools(String name, Integer page, Integer size, 
                                  String sort, String filter, String search);

    /**
     * Tool 상세 조회
     * 
     * @param toolId Tool ID
     * @return Tool 상세 정보
     */
    AgentToolResponse getToolById(String toolId);

    /**
     * Tool 생성
     * 
     * @param request Tool 생성 요청
     * @return 생성된 Tool 정보
     */
    AgentToolResponse createTool(AgentToolCreateRequest request);

    /**
     * Tool 수정
     * 
     * @param toolId Tool ID
     * @param request Tool 수정 요청
     * @return 수정된 Tool 정보
     */
    AgentToolResponse updateTool(String toolId, AgentToolUpdateRequest request);

    /**
     * Tool 삭제 (소프트 삭제)
     * 
     * @param toolId Tool ID
     */
    void deleteTool(String toolId);

    /**
     * 삭제 표시된 모든 Tool 완전 삭제 (하드 삭제)
     */
    void hardDeleteTools();
}
