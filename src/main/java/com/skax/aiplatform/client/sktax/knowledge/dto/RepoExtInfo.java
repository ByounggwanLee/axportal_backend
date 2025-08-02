package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * External Knowledge Repository 정보 DTO
 * OpenAPI 스키마: RepoExtInfo
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoExtInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    @JsonProperty("embedding_model_id")
    private String embeddingModelId;

    @JsonProperty("vector_db_id")
    private String vectorDbId;

    @JsonProperty("index_name")
    private String indexName;

    @JsonProperty("script")
    private String script;

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("is_active")
    @Builder.Default
    private Boolean isActive = false;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("vector_db_type")
    private VectorDatabaseType vectorDbType;

    @JsonProperty("vector_db_name")
    private String vectorDbName;

    @JsonProperty("embedding_model_name")
    private String embeddingModelName;
}
