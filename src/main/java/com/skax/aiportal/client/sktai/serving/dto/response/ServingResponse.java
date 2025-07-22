package com.skax.aiportal.client.sktai.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.serving.dto.ServingStatus;
import com.skax.aiportal.client.sktai.serving.dto.ServingParams;
import com.skax.aiportal.client.sktai.serving.dto.BasePolicy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 서빙 응답 DTO
 * 
 * 서빙 정보에 대한 응답 데이터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingResponse {

    /**
     * 서빙 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 서빙 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
    private String modelId;

    /**
     * 버전 ID
     */
    @JsonProperty("version_id")
    private String versionId;

    /**
     * 모델 이름
     */
    @JsonProperty("model_name")
    private String modelName;

    /**
     * 모델 타입
     */
    @JsonProperty("model_type")
    private String modelType;

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
     * 서빙 매개변수
     */
    @JsonProperty("serving_params")
    private ServingParams servingParams;

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
     * 세이프티 필터 정책
     */
    @JsonProperty("safety_filter_policy")
    private BasePolicy safetyFilterPolicy;

    /**
     * 접근 정책
     */
    @JsonProperty("access_policy")
    private BasePolicy accessPolicy;

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
