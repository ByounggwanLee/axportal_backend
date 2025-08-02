package com.skax.aiplatform.client.sktax.knowledge;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.knowledge.dto.response.MultiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SKT AI Platform Knowledge Tools API Client
 * 
 * <p>Data Ingestion Tool 관리 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-tools",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeToolsClient {

    /**
     * Data Ingestion Tool 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @return Tool 목록
     */
    @GetMapping("/api/v1/knowledge/tools")
    MultiResponse getTools(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 신규 Tool 등록
     * 
     * @param request Tool 생성 요청
     * @return 생성된 Tool 정보
     */
    @PostMapping("/api/v1/knowledge/tools")
    Object createTool(@RequestBody Object request);

    /**
     * Tool 상세 조회
     * 
     * @param toolId Tool ID
     * @return Tool 상세 정보
     */
    @GetMapping("/api/v1/knowledge/tools/{tool_id}")
    Object getTool(@PathVariable("tool_id") String toolId);

    /**
     * Tool 수정
     * 
     * @param toolId Tool ID
     * @param request Tool 수정 요청
     * @return 수정된 Tool 정보
     */
    @PutMapping("/api/v1/knowledge/tools/{tool_id}")
    Object updateTool(
        @PathVariable("tool_id") String toolId,
        @RequestBody Object request
    );

    /**
     * Tool 삭제
     * 
     * @param toolId Tool ID
     */
    @DeleteMapping("/api/v1/knowledge/tools/{tool_id}")
    void deleteTool(@PathVariable("tool_id") String toolId);
}
