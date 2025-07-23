package com.skax.aiportal.client.sktai.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 파인튜닝 학습 응답 DTO
 * 
 * <p>SKT AI 파인튜닝 학습 작업의 상세 정보를 반환하는 응답 객체입니다.
 * 학습 상태, 진행률, 리소스 사용량, 데이터셋 정보 등을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "파인튜닝 학습 응답",
    description = "SKT AI 파인튜닝 학습 작업의 상세 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingResponse {

    /**
     * 학습 작업 이름
     */
    @Schema(
        description = "파인튜닝 학습 작업 이름",
        example = "고객상담봇-v1.0-training",
        maxLength = 100
    )
    @JsonProperty("name")
    private String name;

    /**
     * 학습 상태
     */
    @Schema(
        description = "현재 학습 상태",
        example = "TRAINING",
        allowableValues = {"PENDING", "TRAINING", "COMPLETED", "FAILED", "CANCELLED"}
    )
    @JsonProperty("status")
    private String status;

    /**
     * 이전 상태
     */
    @Schema(
        description = "이전 학습 상태",
        example = "PENDING",
        allowableValues = {"PENDING", "TRAINING", "COMPLETED", "FAILED", "CANCELLED"}
    )
    @JsonProperty("prev_status")
    private String prevStatus;

    /**
     * 학습 진행률 정보
     */
    @Schema(
        description = "학습 진행률 및 상세 정보",
        example = "{\"epoch\": 3, \"step\": 1500, \"total_steps\": 5000, \"loss\": 0.25}"
    )
    @JsonProperty("progress")
    private Map<String, Object> progress;

    /**
     * 리소스 사용량 정보
     */
    @Schema(
        description = "학습에 사용된 리소스 정보",
        example = "{\"gpu_count\": 2, \"memory_gb\": 16, \"cpu_cores\": 8}"
    )
    @JsonProperty("resource")
    private Map<String, Object> resource;

    /**
     * 학습 데이터셋 ID 목록
     */
    @Schema(
        description = "학습에 사용된 데이터셋 ID 목록",
        example = "[\"dataset-12345\", \"dataset-67890\"]"
    )
    @JsonProperty("dataset_ids")
    private List<String> datasetIds;

    /**
     * 기본 모델 ID
     */
    @Schema(
        description = "파인튜닝의 기반이 되는 모델 ID",
        example = "gpt-3.5-turbo",
        maxLength = 100
    )
    @JsonProperty("base_model_id")
    private String baseModelId;

    /**
     * 학습 파라미터
     */
    @Schema(
        description = "학습 하이퍼파라미터 설정 (JSON 형태)",
        example = "{\"learning_rate\": 0.001, \"batch_size\": 32, \"epochs\": 10}"
    )
    @JsonProperty("params")
    private String params;

    /**
     * 환경 변수
     */
    @Schema(
        description = "학습 환경 변수 설정",
        example = "{\"CUDA_VISIBLE_DEVICES\": \"0,1\", \"TOKENIZERS_PARALLELISM\": \"false\"}"
    )
    @JsonProperty("envs")
    private Map<String, Object> envs;

    /**
     * 학습 작업 설명
     */
    @Schema(
        description = "파인튜닝 학습 작업에 대한 설명",
        example = "고객 상담 대화 데이터를 사용한 파인튜닝",
        maxLength = 500
    )
    @JsonProperty("description")
    private String description;

    /**
     * 프로젝트 ID
     */
    @Schema(
        description = "학습 작업이 속한 프로젝트 ID",
        example = "project-12345",
        maxLength = 50
    )
    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("task_id")
    private String taskId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("trainer_id")
    private String trainerId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
