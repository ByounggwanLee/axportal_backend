package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Agent Serving Info Response DTO
 * 에이전트 서빙 상세 정보를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingInfo {

    /**
     * 에이전트 서빙 ID
     */
    @JsonProperty("agent_serving_id")
    private UUID agentServingId;

    /**
     * 앱 ID
     */
    @JsonProperty("app_id")
    private UUID appId;

    /**
     * 배포 이름
     */
    @JsonProperty("deployment_name")
    private String deploymentName = "default_deployment";

    /**
     * Inference Service 이름
     */
    @JsonProperty("isvc_name")
    private String isvcName = "default_isvc_name";

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
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId = "default_project_id";

    /**
     * 네임스페이스
     */
    @JsonProperty("namespace")
    private String namespace;

    /**
     * 앱 버전
     */
    @JsonProperty("app_version")
    private Integer appVersion = 1;

    /**
     * 상태
     */
    @JsonProperty("status")
    private String status = "Deploying";

    /**
     * 오류 메시지
     */
    @JsonProperty("error_message")
    private String errorMessage;

    /**
     * GPU 타입
     */
    @JsonProperty("gpu_type")
    private String gpuType;

    /**
     * CPU 요청량
     */
    @JsonProperty("cpu_request")
    private Integer cpuRequest = 0;

    /**
     * CPU 제한량
     */
    @JsonProperty("cpu_limit")
    private Integer cpuLimit = 0;

    /**
     * GPU 요청량
     */
    @JsonProperty("gpu_request")
    private Integer gpuRequest = 0;

    /**
     * GPU 제한량
     */
    @JsonProperty("gpu_limit")
    private Integer gpuLimit = 0;

    /**
     * 메모리 요청량
     */
    @JsonProperty("mem_request")
    private Integer memRequest = 0;

    /**
     * 메모리 제한량
     */
    @JsonProperty("mem_limit")
    private Integer memLimit = 0;

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
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted = false;

    /**
     * 입력 안전 필터 사용 여부
     */
    @JsonProperty("safety_filter_input")
    private Boolean safetyFilterInput = false;

    /**
     * 출력 안전 필터 사용 여부
     */
    @JsonProperty("safety_filter_output")
    private Boolean safetyFilterOutput = false;

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
     * 모델 목록
     */
    @JsonProperty("model_list")
    private List<String> modelList;

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
     * 엔드포인트 URL
     */
    @JsonProperty("endpoint")
    private String endpoint;

    /**
     * 에이전트 파라미터
     */
    @JsonProperty("agent_params")
    private String agentParams;

    /**
     * 에이전트 앱 이미지
     */
    @JsonProperty("agent_app_image")
    private String agentAppImage;

    /**
     * 앱 설정 파일 경로
     */
    @JsonProperty("app_config_file_path")
    private String appConfigFilePath;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private String servingType;

    /**
     * 공유 백엔드 ID
     */
    @JsonProperty("shared_backend_id")
    private UUID sharedBackendId;
}
