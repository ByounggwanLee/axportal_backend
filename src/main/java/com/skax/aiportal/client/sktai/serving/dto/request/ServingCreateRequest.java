package com.skax.aiportal.client.sktai.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.serving.dto.ServingParams;
import com.skax.aiportal.client.sktai.serving.dto.BasePolicyPayload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 서빙 생성 요청 DTO
 * 
 * 새로운 모델 서빙을 생성하기 위한 요청 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingCreateRequest {

    /**
     * 서빙명 (필수)
     */
    @NotBlank(message = "서빙명은 필수입니다")
    @JsonProperty("name")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 모델 ID (필수)
     */
    @NotNull(message = "모델 ID는 필수입니다")
    @JsonProperty("model_id")
    private String modelId;

    /**
     * 버전 ID
     */
    @JsonProperty("version_id")
    private String versionId;

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
     * 타겟값
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
    private Boolean safetyFilterInput;

    /**
     * 출력 안전 필터 사용 여부
     */
    @JsonProperty("safety_filter_output")
    private Boolean safetyFilterOutput;

    /**
     * 정책
     */
    @JsonProperty("policy")
    private List<BasePolicyPayload> policy;
}
