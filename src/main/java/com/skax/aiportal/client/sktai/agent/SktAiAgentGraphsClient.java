package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.client.sktai.agent.dto.request.GraphCommentCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.GraphCopyRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.GraphCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.GraphRunRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.GraphUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

/**
 * SKT AI Agent Graphs 관리 API Feign 클라이언트
 *
 * <p>Agent 그래프의 생성, 수정, 실행, 버전 관리 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-graphs", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        SktAiClientConfig.class,
        SktAiAuthInterceptor.class,
        SktAiLoggingInterceptor.class
})
public interface SktAiAgentGraphsClient {

    /**
     * Agent Graph 목록 조회
     *
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Agent Graph 목록 응답
     */
    @GetMapping("/agents/graphs")
    CommonResponse getGraphs(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Agent Graph 생성
     *
     * @param request Graph 생성 요청
     * @return Graph 생성 응답
     */
    @PostMapping("/agents/graphs")
    CommonResponse createGraph(@RequestBody GraphCreateRequest request);

    /**
     * Agent Graph 상세 조회
     *
     * @param graphId Graph ID
     * @return Graph 상세 정보 응답
     */
    @GetMapping("/agents/graphs/{graph_id}")
    CommonResponse getGraphById(@PathVariable("graph_id") String graphId);

    /**
     * Agent Graph 수정
     *
     * @param graphId Graph ID
     * @param request Graph 수정 요청
     * @return Graph 수정 응답
     */
    @PutMapping("/agents/graphs/{graph_id}")
    CommonResponse updateGraph(@PathVariable("graph_id") String graphId, @RequestBody GraphUpdateRequest request);

    /**
     * Agent Graph 삭제
     *
     * @param graphId Graph ID
     */
    @DeleteMapping("/agents/graphs/{graph_id}")
    void deleteGraph(@PathVariable("graph_id") String graphId);

    /**
     * Agent Graph 복사
     *
     * @param graphId Graph ID
     * @param request Graph 복사 요청
     * @return Graph 복사 응답
     */
    @PostMapping("/agents/graphs/{graph_id}/copy")
    CommonResponse copyGraph(@PathVariable("graph_id") String graphId, @RequestBody GraphCopyRequest request);

    /**
     * Agent Graph 실행
     *
     * @param graphId Graph ID
     * @param request Graph 실행 요청
     * @return Graph 실행 응답
     */
    @PostMapping("/agents/graphs/{graph_id}/run")
    CommonResponse runGraph(@PathVariable("graph_id") String graphId, @RequestBody GraphRunRequest request);

    /**
     * Agent Graph 버전 목록 조회
     *
     * @param graphId Graph ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Graph 버전 목록 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/versions")
    CommonResponse getGraphVersions(
        @PathVariable("graph_id") String graphId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Agent Graph 특정 버전 조회
     *
     * @param graphId Graph ID
     * @param versionId 버전 ID
     * @return Graph 버전 상세 정보 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/versions/{version_id}")
    CommonResponse getGraphVersion(@PathVariable("graph_id") String graphId, @PathVariable("version_id") String versionId);

    /**
     * Agent Graph 버전 실행
     *
     * @param graphId Graph ID
     * @param versionId 버전 ID
     * @param request Graph 실행 요청
     * @return Graph 버전 실행 응답
     */
    @PostMapping("/agents/graphs/{graph_id}/versions/{version_id}/run")
    CommonResponse runGraphVersion(@PathVariable("graph_id") String graphId, @PathVariable("version_id") String versionId, @RequestBody GraphRunRequest request);

    /**
     * Agent Graph 버전 삭제
     *
     * @param graphId Graph ID
     * @param versionId 버전 ID
     */
    @DeleteMapping("/agents/graphs/{graph_id}/versions/{version_id}")
    void deleteGraphVersion(@PathVariable("graph_id") String graphId, @PathVariable("version_id") String versionId);

    /**
     * Agent Graph 댓글 목록 조회
     *
     * @param graphId Graph ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Graph 댓글 목록 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/comments")
    CommonResponse getGraphComments(
        @PathVariable("graph_id") String graphId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Agent Graph 댓글 생성
     *
     * @param graphId Graph ID
     * @param request 댓글 생성 요청
     * @return 댓글 생성 응답
     */
    @PostMapping("/agents/graphs/{graph_id}/comments")
    CommonResponse createGraphComment(@PathVariable("graph_id") String graphId, @RequestBody GraphCommentCreateRequest request);

    /**
     * Agent Graph 댓글 삭제
     *
     * @param graphId Graph ID
     * @param commentId 댓글 ID
     */
    @DeleteMapping("/agents/graphs/{graph_id}/comments/{comment_id}")
    void deleteGraphComment(@PathVariable("graph_id") String graphId, @PathVariable("comment_id") String commentId);

    /**
     * Agent Graph 템플릿 임포트
     *
     * @param file 템플릿 파일
     * @param name 그래프 이름
     * @param description 그래프 설명
     * @param category 그래프 카테고리
     * @return 템플릿 임포트 응답
     */
    @PostMapping(value = "/agents/graphs/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResponse importGraphTemplate(
        @RequestPart("file") MultipartFile file,
        @RequestPart("name") String name,
        @RequestPart(value = "description", required = false) String description,
        @RequestPart(value = "category", required = false) String category
    );

    /**
     * Agent Graph 템플릿 익스포트
     *
     * @param graphId Graph ID
     * @return 템플릿 익스포트 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/export")
    CommonResponse exportGraphTemplate(@PathVariable("graph_id") String graphId);

    /**
     * Agent Graph 실행 기록 조회
     *
     * @param graphId Graph ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Graph 실행 기록 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/executions")
    CommonResponse getGraphExecutions(
        @PathVariable("graph_id") String graphId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Agent Graph 실행 기록 상세 조회
     *
     * @param graphId Graph ID
     * @param executionId 실행 ID
     * @return Graph 실행 기록 상세 응답
     */
    @GetMapping("/agents/graphs/{graph_id}/executions/{execution_id}")
    CommonResponse getGraphExecution(@PathVariable("graph_id") String graphId, @PathVariable("execution_id") String executionId);

    /**
     * Agent Graph 실행 중지
     *
     * @param graphId Graph ID
     * @param executionId 실행 ID
     * @return Graph 실행 중지 응답
     */
    @PostMapping("/agents/graphs/{graph_id}/executions/{execution_id}/stop")
    CommonResponse stopGraphExecution(@PathVariable("graph_id") String graphId, @PathVariable("execution_id") String executionId);

    /**
     * 카테고리별 Agent Graph 목록 조회
     *
     * @param category 카테고리
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @return 카테고리별 Graph 목록 응답
     */
    @GetMapping("/agents/graphs/category/{category}")
    CommonResponse getGraphsByCategory(
        @PathVariable("category") String category,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * 삭제 표시된 모든 Graph 완전 삭제 (hard delete)
     */
    @DeleteMapping("/agents/graphs/hard-delete")
    void hardDeleteGraphs();
}
