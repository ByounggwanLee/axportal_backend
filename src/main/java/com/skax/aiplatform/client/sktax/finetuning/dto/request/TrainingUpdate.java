package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.Progress;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingStatusEnum;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Training 수정 요청 DTO
 * 기존 훈련을 수정하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingUpdate {

    /**
     * 훈련 이름
     */
    @JsonProperty("name")
    @Size(max = 255, message = "훈련 이름은 255자를 초과할 수 없습니다")
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
     * 진행률을 관리하는 필드로, JSON 객체로 구성됩니다.
     */
    @JsonProperty("progress")
    private Progress progress;

    /**
     * 리소스 정보
     * 훈련에 필요한 리소스 정보를 입력합니다.
     */
    @JsonProperty("resource")
    private Object resource;

    /**
     * 데이터셋 ID 목록
     * 훈련에 사용할 데이터셋 ID들을 지정합니다.
     */
    @JsonProperty("dataset_ids")
    private List<String> datasetIds;

    /**
     * 기본 모델 ID
     * 파인튜닝할 모델 ID를 지정합니다.
     */
    @JsonProperty("base_model_id")
    private UUID baseModelId;

    /**
     * 파라미터
     * 훈련 중 트레이너가 사용하는 파라미터 세부 정보입니다.
     */
    @JsonProperty("params")
    private String params;

    /**
     * 환경 변수
     * 훈련 환경을 정의하는 필드입니다.
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
     * 트레이너 ID
     */
    @JsonProperty("trainer_id")
    private UUID trainerId;
}
