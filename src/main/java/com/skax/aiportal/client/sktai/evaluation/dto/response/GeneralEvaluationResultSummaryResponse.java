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
public class GeneralEvaluationResultSummaryResponse {

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("evaluation_id")
    private Integer evaluationId;

    @JsonProperty("evaluation_name")
    private String evaluationName;

    @JsonProperty("metric")
    private String metric;

    @JsonProperty("avg_metric_result")
    private Double avgMetricResult;
}
