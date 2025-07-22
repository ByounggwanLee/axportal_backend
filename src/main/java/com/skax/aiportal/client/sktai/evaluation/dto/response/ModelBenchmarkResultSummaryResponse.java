package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 결과 요약 응답 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkResultSummaryResponse {
    
    @JsonProperty("model_id")
    private String modelId;
    
    @JsonProperty("display_name")
    private String displayName;
    
    @JsonProperty("model_name")
    private String modelName;
    
    @JsonProperty("benchmark_id")
    private Integer benchmarkId;
    
    @JsonProperty("benchmark_name")
    private String benchmarkName;
    
    @JsonProperty("metric")
    private String metric;
    
    @JsonProperty("avg_metric_result")
    private Double avgMetricResult;
}
