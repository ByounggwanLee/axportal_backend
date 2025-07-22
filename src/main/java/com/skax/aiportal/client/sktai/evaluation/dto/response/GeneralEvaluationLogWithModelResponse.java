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
public class GeneralEvaluationLogWithModelResponse {

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
    private Integer status;

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

    @JsonProperty("evaluation_name")
    private String evaluationName;

    @JsonProperty("status_text")
    private String statusText;
}
