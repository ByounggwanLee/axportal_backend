package com.skax.aiportal.client.sktai.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge 테스트 검색 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestRetrievalRequest {

    /**
     * 사용자 질의
     */
    @JsonProperty("query_text")
    private String queryText;

    /**
     * 지식저장소 ID
     */
    @JsonProperty("repo_id")
    private String repoId;

    /**
     * Repository collection ID
     */
    @JsonProperty("collection_id")
    private String collectionId;
}
