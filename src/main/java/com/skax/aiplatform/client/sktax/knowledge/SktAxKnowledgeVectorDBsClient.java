package com.skax.aiplatform.client.sktax.knowledge;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.VectorDBCreateRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.VectorDBUpdateRequest;
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
 * SKT AI Platform Knowledge Vector DB API Client
 * 
 * <p>Vector Database 관리 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-vectordbs",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeVectorDBsClient {

    /**
     * Vector DB 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @return Vector DB 목록
     */
    @GetMapping("/api/v1/knowledge/vectordbs")
    MultiResponse getVectorDbs(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Vector DB 정보 신규 등록
     * 
     * @param request Vector DB 생성 요청
     * @return 생성된 Vector DB 정보
     */
    @PostMapping("/api/v1/knowledge/vectordbs")
    Object createVectorDb(@RequestBody VectorDBCreateRequest request);

    /**
     * Vector DB 정보 조회
     * 
     * @param vectorDbId Vector DB ID
     * @return Vector DB 정보
     */
    @GetMapping("/api/v1/knowledge/vectordbs/{vector_db_id}")
    Object getVectorDb(@PathVariable("vector_db_id") String vectorDbId);

    /**
     * Vector DB 정보 수정
     * 
     * @param vectorDbId Vector DB ID
     * @param request Vector DB 수정 요청
     * @return 수정된 Vector DB 정보
     */
    @PutMapping("/api/v1/knowledge/vectordbs/{vector_db_id}")
    Object updateVectorDb(
        @PathVariable("vector_db_id") String vectorDbId,
        @RequestBody VectorDBUpdateRequest request
    );

    /**
     * Vector DB 정보 삭제
     * 
     * @param vectorDbId Vector DB ID
     */
    @DeleteMapping("/api/v1/knowledge/vectordbs/{vector_db_id}")
    void deleteVectorDb(@PathVariable("vector_db_id") String vectorDbId);
}
