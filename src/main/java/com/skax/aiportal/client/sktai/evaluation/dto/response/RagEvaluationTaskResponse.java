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
public class RagEvaluationTaskResponse {

    @JsonProperty("rag_evaluation_log_id")
    private Integer ragEvaluationLogId;

    @JsonProperty("workflow_id")
    private String workflowId;

    @JsonProperty("dag_id")
    private String dagId;

    @JsonProperty("dag_run_id")
    private String dagRunId;
}
