package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * RAG 평가 결과 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RagEvaluationResultCreateRequest {
    
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
    
    @JsonProperty("policy")
    private PolicyPayload policy;
}
