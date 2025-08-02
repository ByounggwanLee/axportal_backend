package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * External Knowledge Repo 테스트 요청 DTO
 * OpenAPI 스키마: RepoExtTestRequst
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoExtTestRequest {

    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    @JsonProperty("vector_db_id")
    private String vectorDbId;

    @JsonProperty("index_name")
    private String indexName;

    @JsonProperty("script")
    private String script;

    @JsonProperty("query")
    @Builder.Default
    private String query = "test_query";

    @JsonProperty("retrieval_options")
    private Map<String, Object> retrievalOptions;

    @JsonProperty("request_by")
    private String requestBy;

    @JsonProperty("project_id")
    private String projectId;
}
