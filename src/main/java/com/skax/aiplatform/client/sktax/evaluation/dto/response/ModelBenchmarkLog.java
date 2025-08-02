package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.ModelBenchmarkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 모델 벤치마크 로그 정보
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkLog {

    /**
     * 로그 ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 벤치마크 ID
     */
    @JsonProperty("benchmark_id")
    private Integer benchmarkId;

    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
    private String modelId;

    /**
     * 버전 ID
     */
    @JsonProperty("version_id")
    private String versionId;

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

    /**
     * 상태
     */
    @JsonProperty("status")
    private ModelBenchmarkStatus status;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 메시지
     */
    @JsonProperty("message")
    private String message;
}
