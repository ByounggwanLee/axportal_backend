package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Serving Model View Response DTO
 * 서빙 모델 상세 정보를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServingModelView {

    /**
     * 서빙 ID
     */
    @JsonProperty("serving_id")
    private UUID servingId;

    /**
     * 서빙 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * KServe YAML 설정
     */
    @JsonProperty("kserve_yaml")
    private String kserveYaml;

    /**
     * Inference Service 이름
     */
    @JsonProperty("isvc_name")
    private String isvcName;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 네임스페이스
     */
    @JsonProperty("namespace")
    private String namespace;

    /**
     * 상태
     */
    @JsonProperty("status")
    private String status;

    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
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
    private String servingParams;

    /**
     * 오류 메시지
     */
    @JsonProperty("error_message")
    private String errorMessage;

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
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

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

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

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

    /**
     * 모델 이름
     */
    @JsonProperty("model_name")
    private String modelName;

    /**
     * 표시 이름
     */
    @JsonProperty("display_name")
    private String displayName;

    /**
     * 모델 설명
     */
    @JsonProperty("model_description")
    private String modelDescription;

    /**
     * 모델 타입
     */
    @JsonProperty("type")
    private String type;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private String servingType;

    /**
     * 비공개 여부
     */
    @JsonProperty("is_private")
    private Boolean isPrivate;

    /**
     * 유효성 여부
     */
    @JsonProperty("is_valid")
    private Boolean isValid;

    /**
     * 추론 파라미터
     */
    @JsonProperty("inference_param")
    private Object inferenceParam;

    /**
     * 양자화 설정
     */
    @JsonProperty("quantization")
    private Object quantization;

    /**
     * 제공자 이름
     */
    @JsonProperty("provider_name")
    private String providerName;

    /**
     * 모델 버전
     */
    @JsonProperty("model_version")
    private Integer modelVersion;

    /**
     * 모델 경로
     */
    @JsonProperty("path")
    private String path;

    /**
     * 버전 경로
     */
    @JsonProperty("version_path")
    private String versionPath;

    /**
     * 파인튜닝 ID
     */
    @JsonProperty("fine_tuning_id")
    private UUID fineTuningId;

    /**
     * 버전 유효성 여부
     */
    @JsonProperty("version_is_valid")
    private Boolean versionIsValid;

    /**
     * 버전 삭제 여부
     */
    @JsonProperty("version_is_deleted")
    private Boolean versionIsDeleted;

    /**
     * GPU 타입
     */
    @JsonProperty("gpu_type")
    private String gpuType;
}
