package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.PolicyPayload;
import com.skax.aiplatform.client.sktax.serving.dto.ServingParams;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Serving 생성 요청 DTO
 * 새로운 서빙을 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingCreate {

    /**
     * 서빙 이름
     */
    @JsonProperty("name")
    @NotBlank(message = "서빙 이름은 필수입니다")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
    @NotNull(message = "모델 ID는 필수입니다")
    private UUID modelId;

    /**
     * 버전 ID
     */
    @JsonProperty("version_id")
    private UUID versionId;

    /**
     * 서빙 파라미터
     */
    @JsonProperty("serving_params")
    private ServingParams servingParams;

    /**
     * CPU 요청량
     */
    @JsonProperty("cpu_request")
    private Integer cpuRequest;

    /**
     * CPU 제한량
     */
    @JsonProperty("cpu_limit")
    private Integer cpuLimit;

    /**
     * GPU 요청량
     */
    @JsonProperty("gpu_request")
    private Integer gpuRequest;

    /**
     * GPU 제한량
     */
    @JsonProperty("gpu_limit")
    private Integer gpuLimit;

    /**
     * 메모리 요청량
     */
    @JsonProperty("mem_request")
    private Integer memRequest;

    /**
     * 메모리 제한량
     */
    @JsonProperty("mem_limit")
    private Integer memLimit;

    /**
     * 최소 복제본 수
     */
    @JsonProperty("min_replicas")
    private Integer minReplicas;

    /**
     * 최대 복제본 수
     */
    @JsonProperty("max_replicas")
    private Integer maxReplicas;

    /**
     * 오토스케일링 클래스
     */
    @JsonProperty("autoscaling_class")
    private String autoscalingClass;

    /**
     * 오토스케일링 메트릭
     */
    @JsonProperty("autoscaling_metric")
    private String autoscalingMetric;

    /**
     * 오토스케일링 타겟
     */
    @JsonProperty("target")
    private Integer target;

    /**
     * GPU 타입
     */
    @JsonProperty("gpu_type")
    private String gpuType;

    /**
     * 입력 안전 필터 사용 여부
     */
    @JsonProperty("safety_filter_input")
    @Builder.Default
    private Boolean safetyFilterInput = false;

    /**
     * 출력 안전 필터 사용 여부
     */
    @JsonProperty("safety_filter_output")
    @Builder.Default
    private Boolean safetyFilterOutput = false;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
