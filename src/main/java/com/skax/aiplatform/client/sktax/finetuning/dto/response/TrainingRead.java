package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.Progress;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Training 조회 응답 DTO
 * 훈련 정보 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRead {

    /**
     * 훈련 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 훈련 상태
     */
    @JsonProperty("status")
    private TrainingStatusEnum status;

    /**
     * 이전 상태
     */
    @JsonProperty("prev_status")
    private TrainingStatusEnum prevStatus;

    /**
     * 진행 상황
     */
    @JsonProperty("progress")
    private Progress progress;

    /**
     * 리소스 정보
     */
    @JsonProperty("resource")
    private Object resource;

    /**
     * 데이터셋 ID 목록
     */
    @JsonProperty("dataset_ids")
    private List<String> datasetIds;

    /**
     * 기본 모델 ID
     */
    @JsonProperty("base_model_id")
    private UUID baseModelId;

    /**
     * 파라미터
     */
    @JsonProperty("params")
    private String params;

    /**
     * 환경 변수
     */
    @JsonProperty("envs")
    private Object envs;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private UUID projectId;

    /**
     * 태스크 ID
     */
    @JsonProperty("task_id")
    private UUID taskId;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 트레이너 ID
     */
    @JsonProperty("trainer_id")
    private UUID trainerId;

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
}
