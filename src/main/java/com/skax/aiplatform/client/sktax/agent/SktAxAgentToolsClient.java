package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.request.ToolRequest;
import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX Agent Tool 관리 Feign Client
 * 
 * <p>Agent에서 사용하는 Tool의 생성, 조회, 수정, 삭제를 담당하는 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-tools", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentToolsClient {

    /**
     * Tool 목록 조회
     * 
     * @param name 툴 이름 필터
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Tool 목록 응답
     */
    @GetMapping("/tools")
    CommonResponse getTools(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Tool 생성
     * 
     * @param toolRequest Tool 생성 요청 데이터
     * @return Tool 생성 응답
     */
    @PostMapping("/tools")
    CommonResponse addTool(@RequestBody ToolRequest toolRequest);

    /**
     * Tool 상세 조회
     * 
     * @param toolId Tool ID
     * @return Tool 상세 정보 응답
     */
    @GetMapping("/tools/{toolId}")
    CommonResponse getToolById(@PathVariable("toolId") String toolId);

    /**
     * Tool 수정
     * 
     * @param toolId Tool ID
     * @param toolRequest Tool 수정 요청 데이터
     * @return Tool 수정 응답
     */
    @PutMapping("/tools/{toolId}")
    CommonResponse updateTool(
        @PathVariable("toolId") String toolId, 
        @RequestBody ToolRequest toolRequest
    );

    /**
     * Tool 삭제
     * 
     * @param toolId Tool ID
     */
    @DeleteMapping("/tools/{toolId}")
    void deleteTool(@PathVariable("toolId") String toolId);

    /**
     * 삭제 표시된 모든 Tool 완전 삭제
     */
    @DeleteMapping("/tools/hard-delete")
    void hardDeleteTools();
}
