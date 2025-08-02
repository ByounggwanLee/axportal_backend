package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.ServingParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Serving 수정 요청 DTO
 * 기존 서빙을 수정하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingUpdate {

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

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
}
