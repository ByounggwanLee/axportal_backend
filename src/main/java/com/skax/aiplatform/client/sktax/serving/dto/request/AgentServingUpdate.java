package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.ServingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Agent Serving 업데이트 요청 DTO
 * 기존 에이전트 서빙을 수정하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingUpdate {

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private ServingTypeEnum servingType;

    /**
     * 서빙 이름
     */
    @JsonProperty("serving_name")
    private String servingName;

    /**
     * 에이전트 파라미터
     */
    @JsonProperty("agent_params")
    private Object agentParams;

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
     * CPU 요청량
     */
    @JsonProperty("cpu_request")
    private Double cpuRequest;

    /**
     * CPU 제한량
     */
    @JsonProperty("cpu_limit")
    private Double cpuLimit;

    /**
     * 메모리 요청량
     */
    @JsonProperty("mem_request")
    private String memRequest;

    /**
     * 메모리 제한량
     */
    @JsonProperty("mem_limit")
    private String memLimit;

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
     * 상태
     */
    @JsonProperty("status")
    private ServingStatus status;
}
