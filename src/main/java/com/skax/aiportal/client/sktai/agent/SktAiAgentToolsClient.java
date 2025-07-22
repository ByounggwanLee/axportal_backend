package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.agent.dto.request.ToolRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;

/**
 * SKT AI Agent Tool 관리 API Feign 클라이언트
 *
 * <p>Agent 도구(Tool) 생성, 조회, 수정, 삭제 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-tools",
    url = "${skt.ai.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAiClientConfig.class
)
public interface SktAiAgentToolsClient {

    /**
     * Tool 목록 조회
     *
     * @param name Tool 이름 필터
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Tool 목록 응답
     */
    @GetMapping("/tools")
    CommonResponse getTools(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Tool 생성
     *
     * @param request Tool 생성 요청
     * @return Tool 생성 응답
     */
    @PostMapping("/tools")
    CommonResponse addTool(@RequestBody ToolRequest request);

    /**
     * Tool 상세 조회
     *
     * @param toolId Tool ID
     * @return Tool 상세 정보 응답
     */
    @GetMapping("/tools/{tool_id}")
    CommonResponse getToolById(@PathVariable("tool_id") String toolId);

    /**
     * Tool 수정
     *
     * @param toolId Tool ID
     * @param request Tool 수정 요청
     * @return Tool 수정 응답
     */
    @PutMapping("/tools/{tool_id}")
    CommonResponse updateTool(@PathVariable("tool_id") String toolId, @RequestBody ToolRequest request);

    /**
     * Tool 삭제 (soft delete)
     *
     * @param toolId Tool ID
     */
    @DeleteMapping("/tools/{tool_id}")
    void deleteTool(@PathVariable("tool_id") String toolId);

    /**
     * 삭제 표시된 모든 Tool 완전 삭제 (hard delete)
     */
    @DeleteMapping("/tools/hard-delete")
    void hardDeleteTools();
}
