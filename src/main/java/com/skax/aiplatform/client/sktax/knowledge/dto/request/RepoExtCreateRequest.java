package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * External Knowledge Repo 생성 요청 DTO
 * OpenAPI 스키마: RepoExtCreateRequst
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoExtCreateRequest {

    @NotBlank(message = "name은 필수입니다")
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    @NotBlank(message = "embedding_model_name은 필수입니다")
    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    @NotNull(message = "vector_db_id는 필수입니다")
    @JsonProperty("vector_db_id")
    private String vectorDbId;

    @NotBlank(message = "index_name은 필수입니다")
    @JsonProperty("index_name")
    private String indexName;

    @NotBlank(message = "script는 필수입니다")
    @JsonProperty("script")
    private String script;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("policy")
    private Object policy; // PolicyPayload 타입 - 복잡한 구조이므로 Object로 처리
}
