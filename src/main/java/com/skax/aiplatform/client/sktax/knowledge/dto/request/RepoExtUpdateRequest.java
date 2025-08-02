package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * External Knowledge Repo 수정 요청 DTO
 * OpenAPI 스키마: RepoExtUpdateRequest
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoExtUpdateRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    @JsonProperty("index_name")
    private String indexName;

    @JsonProperty("script")
    private String script;
}
