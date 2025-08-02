package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.PolicyPayload;
import com.skax.aiplatform.client.sktax.finetuning.dto.Progress;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Training 생성 요청 DTO
 * 새로운 파인튜닝 훈련을 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCreate {

    /**
     * 훈련 이름
     */
    @JsonProperty("name")
    @NotBlank(message = "훈련 이름은 필수입니다")
    @Size(max = 255, message = "훈련 이름은 255자를 초과할 수 없습니다")
    private String name;

    /**
     * 훈련 상태
     */
    @JsonProperty("status")
    @Builder.Default
    private TrainingStatusEnum status = TrainingStatusEnum.INITIALIZED;

    /**
     * 이전 상태
     */
    @JsonProperty("prev_status")
    private TrainingStatusEnum prevStatus;

    /**
     * 진행 상황
     * 진행률을 관리하는 필드로, JSON 객체로 구성됩니다. 현재는 percentage만 포함하지만 향후 추가 필드가 포함될 수 있습니다.
     */
    @JsonProperty("progress")
    private Progress progress;

    /**
     * 리소스 정보
     * 훈련에 필요한 리소스 정보를 입력합니다. cpu_quota, mem_quota, gpu_quota를 JSON 객체 형식으로 지정합니다.
     */
    @JsonProperty("resource")
    @NotNull(message = "리소스 정보는 필수입니다")
    private Object resource;

    /**
     * 데이터셋 ID 목록
     * 훈련에 사용할 데이터셋 ID들을 지정합니다. 스키마에서는 Dataset ID 타입을 문자열로 정의하지만, Dataset ID 형식은 UUID여야 합니다.
     */
    @JsonProperty("dataset_ids")
    @NotEmpty(message = "데이터셋 ID 목록은 필수입니다")
    private List<String> datasetIds;

    /**
     * 기본 모델 ID
     * 파인튜닝할 모델 ID를 지정합니다.
     */
    @JsonProperty("base_model_id")
    @NotNull(message = "기본 모델 ID는 필수입니다")
    private UUID baseModelId;

    /**
     * 파라미터
     * 훈련 중 트레이너가 사용하는 파라미터 세부 정보입니다. 트레이너 유형에 따라 정의됩니다.
     */
    @JsonProperty("params")
    @NotBlank(message = "파라미터는 필수입니다")
    private String params;

    /**
     * 환경 변수
     * 훈련 환경을 정의하는 필드입니다. 지정하지 않으면 기본 환경에서 작동합니다.
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
     * 프로젝트 ID를 직접 지정할 수 있습니다. 지정하지 않으면 인증 토큰에 포함된 프로젝트 ID로 설정됩니다.
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
    @NotNull(message = "트레이너 ID는 필수입니다")
    private UUID trainerId;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
