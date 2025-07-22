package com.skax.aiportal.client.sktai.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.serving.dto.ServingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 에이전트 서빙 응답 DTO
 * 
 * 에이전트 서빙 정보에 대한 응답 데이터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingResponse {

    /**
     * 서빙 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 배포 이름
     */
    @JsonProperty("deployment_name")
    private String deploymentName;

    /**
     * 앱 ID
     */
    @JsonProperty("app_id")
    private String appId;

    /**
     * 에이전트 앱 이미지
     */
    @JsonProperty("agent_app_image")
    private String agentAppImage;

    /**
     * 상태
     */
    @JsonProperty("status")
    private ServingStatus status;

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
     * 생성일시
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * 서빙 URL
     */
    @JsonProperty("serving_url")
    private String servingUrl;

    /**
     * 서빙 엔드포인트
     */
    @JsonProperty("serving_endpoint")
    private String servingEndpoint;

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
     * 현재 복제본 수
     */
    @JsonProperty("current_replicas")
    private Integer currentReplicas;

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
     * 생성자 ID
     */
    @JsonProperty("creator_id")
    private String creatorId;

    /**
     * 조직 ID
     */
    @JsonProperty("organization_id")
    private String organizationId;
}
