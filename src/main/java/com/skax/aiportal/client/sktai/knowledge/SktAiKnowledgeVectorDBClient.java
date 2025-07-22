package com.skax.aiportal.client.sktai.knowledge;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.knowledge.dto.request.VectorDBCreateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.VectorDBUpdateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge Vector DB 관리 API Feign 클라이언트
 *
 * <p>Vector Database의 생성, 수정, 삭제, 조회 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-vectordbs",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeVectorDBClient {

    /**
     * Vector DB 목록 조회
     *
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Vector DB 목록 응답
     */
    @GetMapping("/vectordbs")
    KnowledgeResponse<Object> getVectorDBs(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Vector DB 신규 등록
     *
     * @param request Vector DB 생성 요청
     * @return Vector DB 생성 응답
     */
    @PostMapping("/vectordbs")
    KnowledgeResponse<Object> createVectorDB(@RequestBody VectorDBCreateRequest request);

    /**
     * Vector DB 정보 조회
     *
     * @param vectorDbId Vector DB ID
     * @return Vector DB 상세 정보 응답
     */
    @GetMapping("/vectordbs/{vector_db_id}")
    KnowledgeResponse<Object> getVectorDBById(@PathVariable("vector_db_id") String vectorDbId);

    /**
     * Vector DB 정보 수정
     *
     * @param vectorDbId Vector DB ID
     * @param request Vector DB 수정 요청
     * @return Vector DB 수정 응답
     */
    @PutMapping("/vectordbs/{vector_db_id}")
    KnowledgeResponse<Object> updateVectorDB(@PathVariable("vector_db_id") String vectorDbId, @RequestBody VectorDBUpdateRequest request);

    /**
     * Vector DB 정보 삭제
     *
     * @param vectorDbId Vector DB ID
     */
    @DeleteMapping("/vectordbs/{vector_db_id}")
    void deleteVectorDB(@PathVariable("vector_db_id") String vectorDbId);
}
