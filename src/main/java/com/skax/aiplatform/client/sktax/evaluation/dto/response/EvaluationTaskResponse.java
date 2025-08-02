package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 평가 태스크 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationTaskResponse {
    
    @JsonProperty("evaluation_log_id")
    private Integer evaluationLogId;
    
    @JsonProperty("workflow_id")
    private String workflowId;
    
    @JsonProperty("dag_id")
    private String dagId;
    
    @JsonProperty("dag_run_id")
    private String dagRunId;
}
