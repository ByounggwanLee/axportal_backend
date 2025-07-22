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
public class GeneralEvaluationLogResponse {

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
}
