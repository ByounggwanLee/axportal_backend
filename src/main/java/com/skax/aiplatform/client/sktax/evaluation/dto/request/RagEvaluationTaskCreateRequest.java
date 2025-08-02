package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.TaskManagerResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * RAG 평가 태스크 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RagEvaluationTaskCreateRequest {
    
    @JsonProperty("model_id")
    private String modelId;
    
    @JsonProperty("version_id")
    private String versionId;
    
    @JsonProperty("rag_evaluation_id")
    private Integer ragEvaluationId;
    
    @JsonProperty("presence_penalty")
    private Double presencePenalty;
    
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;
    
    @JsonProperty("temperature")
    private Double temperature;
    
    @JsonProperty("dataset_top50")
    private Boolean datasetTop50;
    
    @JsonProperty("judge_model_serving_id")
    private String judgeModelServingId;
    
    @JsonProperty("judge_temperature")
    private Double judgeTemperature;
    
    @JsonProperty("judge_max_concurrency")
    private Integer judgeMaxConcurrency;
    
    @JsonProperty("judge_mock")
    private Boolean judgeMock;
    
    @JsonProperty("judge_top10")
    private Boolean judgeTop10;
    
    @JsonProperty("resource")
    private TaskManagerResource resource;
}
