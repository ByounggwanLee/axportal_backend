package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Collection DTO
 * OpenAPI 스키마: Collection
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Collection {

    @JsonProperty("repo_id")
    private String repoId;

    @JsonProperty("embedding_model_id")
    private String embeddingModelId;

    @JsonProperty("vector_db_id")
    private String vectorDbId;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("status")
    @Builder.Default
    private Status status = Status.NONE;

    @JsonProperty("base_loader")
    private String baseLoader;

    @JsonProperty("base_processor")
    private String baseProcessor;

    @JsonProperty("base_splitter")
    private String baseSplitter;

    @JsonProperty("base_chunk_size")
    private Integer baseChunkSize;

    @JsonProperty("base_chunk_overlap")
    private Integer baseChunkOverlap;

    @JsonProperty("base_separator")
    private String baseSeparator;

    @JsonProperty("base_custom_loader_id")
    private String baseCustomLoaderId;

    @JsonProperty("base_custom_splitter_id")
    private String baseCustomSplitterId;

    @JsonProperty("base_tool_id")
    private String baseToolId;

    @JsonProperty("base_processor_ids")
    private List<String> baseProcessorIds;

    @JsonProperty("indexing_config")
    private Object indexingConfig; // RepoIndexingConfig 복잡한 구조이므로 Object로 처리

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
