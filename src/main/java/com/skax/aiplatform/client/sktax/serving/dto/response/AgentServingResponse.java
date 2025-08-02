package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.serving.dto.ServingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Agent Serving 응답 DTO
 * 에이전트 서빙 생성/수정 결과를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingResponse {

    /**
     * 에이전트 서빙 ID
     */
    @JsonProperty("agent_serving_id")
    private UUID agentServingId;

    /**
     * 배포 이름
     */
    @JsonProperty("deployment_name")
    private String deploymentName;

    /**
     * Inference Service 이름
     */
    @JsonProperty("isvc_name")
    private String isvcName;

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
    private String projectId;

    /**
     * 네임스페이스
     */
    @JsonProperty("namespace")
    private String namespace;

    /**
     * 앱 ID
     */
    @JsonProperty("app_id")
    private UUID appId;

    /**
     * 앱 버전
     */
    @JsonProperty("app_version")
    private Integer appVersion;

    /**
     * 상태
     */
    @JsonProperty("status")
    private ServingStatus status;

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
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

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
     * 모델 목록
     */
    @JsonProperty("model_list")
    private List<String> modelList;

    /**
     * 엔드포인트 URL
     */
    @JsonProperty("endpoint")
    private String endpoint;

    /**
     * 에이전트 파라미터
     */
    @JsonProperty("agent_params")
    private Object agentParams;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private String servingType;
}
