package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 평가 로그 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationLog {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("evaluation_id")
    private Integer evaluationId;
    
    @JsonProperty("model_id")
    private String modelId;
    
    @JsonProperty("version_id")
    private String versionId;
    
    @JsonProperty("workflow_id")
    private String workflowId;
    
    @JsonProperty("dag_id")
    private String dagId;
    
    @JsonProperty("dag_run_id")
    private String dagRunId;
    
    @JsonProperty("status")
    private EvaluationStatus status;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("judge_apikey_id")
    private String judgeApikeyId;
}
