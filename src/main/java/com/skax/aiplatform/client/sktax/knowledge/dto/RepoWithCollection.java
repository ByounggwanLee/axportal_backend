package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository와 Collection 정보를 포함한 DTO
 * OpenAPI 스키마: RepoWithCollection
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoWithCollection {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    @JsonProperty("datasource_id")
    private String datasourceId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("active_collection_id")
    private String activeCollectionId;

    @JsonProperty("active_collection")
    private Collection activeCollection;

    @JsonProperty("latest_collection")
    private Collection latestCollection;

    @JsonProperty("latest_task")
    private RepoTask latestTask;

    @JsonProperty("vector_db_type")
    private VectorDatabaseType vectorDbType;

    @JsonProperty("vector_db_name")
    private String vectorDbName;

    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    @JsonProperty("embedding_model_serving_name")
    private String embeddingModelServingName;

    @JsonProperty("loader")
    private String loader;

    @JsonProperty("splitter")
    private String splitter;

    @JsonProperty("is_active")
    private Boolean isActive;
}
