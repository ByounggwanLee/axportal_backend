package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Embedding Model 정보 DTO
 * OpenAPI 스키마: EmbeddingModelInfo
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddingModelInfo {

    @JsonProperty("serving_name")
    private String servingName;

    @JsonProperty("dimensions")
    private Integer dimensions;
}
