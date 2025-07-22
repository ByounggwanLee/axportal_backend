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
public class RagEvaluationResultResponse {

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
}
