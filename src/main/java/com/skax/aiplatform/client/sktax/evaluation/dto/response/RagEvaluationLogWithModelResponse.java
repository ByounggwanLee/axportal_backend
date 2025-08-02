package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.RagEvaluationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 모델 정보가 포함된 RAG 평가 로그 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RagEvaluationLogWithModelResponse {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("rag_evaluation_id")
    private Integer ragEvaluationId;
    
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
    private RagEvaluationStatus status;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("judge_apikey_id")
    private String judgeApikeyId;
    
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
    
    @JsonProperty(value = "status_text", access = JsonProperty.Access.READ_ONLY)
    private String statusText;
}
