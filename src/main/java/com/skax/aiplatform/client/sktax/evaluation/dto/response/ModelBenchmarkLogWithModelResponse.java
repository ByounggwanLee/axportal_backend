package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.ModelBenchmarkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 모델 정보가 포함된 모델 벤치마크 로그 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelBenchmarkLogWithModelResponse {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("benchmark_id")
    private Integer benchmarkId;
    
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
    private ModelBenchmarkStatus status;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("message")
    private String message;
    
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
    
    @JsonProperty("benchmark_name")
    private String benchmarkName;
    
    @JsonProperty("n_fewshot")
    private Integer nFewshot;
    
    @JsonProperty(value = "status_text", access = JsonProperty.Access.READ_ONLY)
    private String statusText;
}
