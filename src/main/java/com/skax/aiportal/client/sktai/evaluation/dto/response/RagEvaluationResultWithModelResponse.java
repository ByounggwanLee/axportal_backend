package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RagEvaluationResultWithModelResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("version_id")
    private String versionId;

    @JsonProperty("rag_evaluation_id")
    private Integer ragEvaluationId;

    @JsonProperty("task")
    private String task;

    @JsonProperty("metric")
    private String metric;

    @JsonProperty("metric_result")
    private Double metricResult;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    // Model info fields
    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("model_description")
    private String modelDescription;

    @JsonProperty("type")
    private String type;

    @JsonProperty("serving_type")
    private String servingType;

    @JsonProperty("is_private")
    private Boolean isPrivate;

    @JsonProperty("is_valid")
    private Boolean isValid;

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("model_version")
    private Integer modelVersion;

    @JsonProperty("rag_evaluation_name")
    private String ragEvaluationName;
}
