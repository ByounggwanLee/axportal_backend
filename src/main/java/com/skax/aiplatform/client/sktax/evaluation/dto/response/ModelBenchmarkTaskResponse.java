package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 태스크 응답
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkTaskResponse {

    /**
     * 모델 벤치마크 로그 ID
     */
    @JsonProperty("model_benchmark_log_id")
    private Integer modelBenchmarkLogId;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;

    /**
     * DAG ID
     */
    @JsonProperty("dag_id")
    private String dagId;

    /**
     * DAG 실행 ID
     */
    @JsonProperty("dag_run_id")
    private String dagRunId;
}
