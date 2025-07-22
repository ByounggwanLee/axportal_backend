package com.skax.aiportal.client.sktai.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 에이전트 서빙 생성 요청 DTO
 * 
 * 에이전트 서빙을 생성하기 위한 요청 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingCreateRequest {

    /**
     * 배포 이름
     */
    @NotBlank(message = "배포 이름은 필수입니다")
    @JsonProperty("deployment_name")
    private String deploymentName;

    /**
     * 앱 ID
     */
    @NotBlank(message = "앱 ID는 필수입니다")
    @JsonProperty("app_id")
    private String appId;

    /**
     * 에이전트 앱 이미지
     */
    @NotBlank(message = "에이전트 앱 이미지는 필수입니다")
    @JsonProperty("agent_app_image")
    private String agentAppImage;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 라벨
     */
    @JsonProperty("labels")
    private Object labels;

    /**
     * GPU 타입
     */
    @JsonProperty("gpu_type")
    private String gpuType;

    /**
     * GPU 개수
     */
    @JsonProperty("gpu_count")
    private Integer gpuCount;

    /**
     * CPU 개수
     */
    @JsonProperty("cpu_count")
    private Integer cpuCount;

    /**
     * 메모리 (GB)
     */
    @JsonProperty("memory_gb")
    private Integer memoryGb;

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
}
