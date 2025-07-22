package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RagEvaluationResultSummaryResponse {

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("rag_evaluation_id")
    private Integer ragEvaluationId;

    @JsonProperty("rag_evaluation_name")
    private String ragEvaluationName;

    @JsonProperty("metric")
    private String metric;

    @JsonProperty("avg_metric_result")
    private Double avgMetricResult;
}
