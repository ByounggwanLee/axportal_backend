package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Repo Retrieval 정보 DTO
 * OpenAPI 스키마: RepoRetrievalInfo
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoRetrievalInfo {

    @JsonProperty("repo_id")
    private String repoId;

    @JsonProperty("active_collection_id")
    private String activeCollectionId;

    @JsonProperty("vectordb")
    private VectorDBInfo vectordb;

    @JsonProperty("embedding_model")
    private EmbeddingModelInfo embeddingModel;
}
