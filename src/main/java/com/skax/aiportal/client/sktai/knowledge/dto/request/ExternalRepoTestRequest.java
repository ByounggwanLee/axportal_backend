package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * External Knowledge Repository 테스트 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalRepoTestRequest {

    /**
     * 임베딩 모델 이름
     */
    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    /**
     * Vector DB ID
     */
    @JsonProperty("vector_db_id")
    private String vectorDbId;

    /**
     * 인덱스 이름
     */
    @JsonProperty("index_name")
    private String indexName;

    /**
     * 스크립트
     */
    @JsonProperty("script")
    private String script;

    /**
     * 질의
     */
    @JsonProperty("query")
    private String query;

    /**
     * 검색 옵션
     */
    @JsonProperty("retrieval_options")
    private Map<String, Object> retrievalOptions;

    /**
     * 요청자
     */
    @JsonProperty("request_by")
    private String requestBy;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;
}
