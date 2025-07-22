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
import com.skax.aiportal.client.sktai.knowledge.dto.request.ChunkStoreCreateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.ChunkStoreUpdateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge Chunk Store 관리 API Feign 클라이언트
 *
 * <p>Chunk Store의 생성, 수정, 삭제, 조회 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-chunk-stores",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeChunkStoreClient {

    /**
     * ChunkStore 목록 조회
     *
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return ChunkStore 목록 응답
     */
    @GetMapping("/chunk_stores")
    KnowledgeResponse<Object> getChunkStores(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * ChunkStore 신규 등록
     *
     * @param request ChunkStore 생성 요청
     * @return ChunkStore 생성 응답
     */
    @PostMapping("/chunk_stores")
    KnowledgeResponse<Object> createChunkStore(@RequestBody ChunkStoreCreateRequest request);

    /**
     * ChunkStore 정보 조회
     *
     * @param chunkStoreId ChunkStore ID
     * @return ChunkStore 상세 정보 응답
     */
    @GetMapping("/chunk_stores/{chunk_store_id}")
    KnowledgeResponse<Object> getChunkStoreById(@PathVariable("chunk_store_id") String chunkStoreId);

    /**
     * ChunkStore 정보 수정
     *
     * @param chunkStoreId ChunkStore ID
     * @param request ChunkStore 수정 요청
     * @return ChunkStore 수정 응답
     */
    @PutMapping("/chunk_stores/{chunk_store_id}")
    KnowledgeResponse<Object> updateChunkStore(@PathVariable("chunk_store_id") String chunkStoreId, @RequestBody ChunkStoreUpdateRequest request);

    /**
     * ChunkStore 정보 삭제
     *
     * @param chunkStoreId ChunkStore ID
     */
    @DeleteMapping("/chunk_stores/{chunk_store_id}")
    void deleteChunkStore(@PathVariable("chunk_store_id") String chunkStoreId);
}
