package com.skax.aiplatform.client.sktax.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.PolicyPayload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Agent Serving 생성 요청 DTO
 * 새로운 에이전트 서빙을 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingCreate {

    /**
     * 배포 이름
     */
    @JsonProperty("deployment_name")
    @NotBlank(message = "배포 이름은 필수입니다")
    private String deploymentName;

    /**
     * 앱 버전
     */
    @JsonProperty("app_version")
    private Integer appVersion;

    /**
     * 앱 ID
     */
    @JsonProperty("app_id")
    @NotNull(message = "앱 ID는 필수입니다")
    private UUID appId;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

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
     * 모델 목록
     */
    @JsonProperty("model_list")
    private List<String> modelList;

    /**
     * 에이전트 파라미터
     */
    @JsonProperty("agent_params")
    private Object agentParams;

    /**
     * 에이전트 앱 이미지
     */
    @JsonProperty("agent_app_image")
    @NotBlank(message = "에이전트 앱 이미지는 필수입니다")
    private String agentAppImage;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private String servingType;

    /**
     * 앱 설정 파일 경로
     */
    @JsonProperty("app_config_file_path")
    private String appConfigFilePath;

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
}
