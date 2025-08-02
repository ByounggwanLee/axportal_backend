package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 평가 결과 요약 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationResultSummary {
    
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
