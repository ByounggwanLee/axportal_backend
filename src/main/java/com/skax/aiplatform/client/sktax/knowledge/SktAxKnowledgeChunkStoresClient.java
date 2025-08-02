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
 * SKT AI Platform Knowledge Chunk Stores API Client
 * 
 * <p>Chunk Store 관리 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-chunk-stores",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeChunkStoresClient {

    /**
     * ChunkStore 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @return ChunkStore 목록
     */
    @GetMapping("/api/v1/knowledge/chunk_stores")
    MultiResponse getChunkStores(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * ChunkStore 신규 등록
     * 
     * @param request ChunkStore 생성 요청
     * @return 생성된 ChunkStore 정보
     */
    @PostMapping("/api/v1/knowledge/chunk_stores")
    Object createChunkStore(@RequestBody Object request);

    /**
     * ChunkStore 정보 조회
     * 
     * @param chunkStoreId ChunkStore ID
     * @return ChunkStore 정보
     */
    @GetMapping("/api/v1/knowledge/chunk_stores/{chunk_store_id}")
    Object getChunkStore(@PathVariable("chunk_store_id") String chunkStoreId);

    /**
     * ChunkStore 정보 수정
     * 
     * @param chunkStoreId ChunkStore ID
     * @param request ChunkStore 수정 요청
     * @return 수정된 ChunkStore 정보
     */
    @PutMapping("/api/v1/knowledge/chunk_stores/{chunk_store_id}")
    Object updateChunkStore(
        @PathVariable("chunk_store_id") String chunkStoreId,
        @RequestBody Object request
    );

    /**
     * ChunkStore 정보 삭제
     * 
     * @param chunkStoreId ChunkStore ID
     */
    @DeleteMapping("/api/v1/knowledge/chunk_stores/{chunk_store_id}")
    void deleteChunkStore(@PathVariable("chunk_store_id") String chunkStoreId);
}
