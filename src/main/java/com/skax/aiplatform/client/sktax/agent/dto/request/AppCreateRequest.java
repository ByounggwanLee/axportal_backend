package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent App 생성 요청 DTO
 * 
 * <p>Agent App 생성 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Agent App 생성 요청")
public class AppCreateRequest {

    /**
     * App 이름
     */
    @Schema(description = "App 이름", example = "finance_agent_form_service", required = true)
    @JsonProperty("name")
    @NotBlank(message = "App 이름은 필수입니다")
    private String name;

    /**
     * App 설명
     */
    @Schema(description = "App 설명", example = "agent_form service_deploy")
    @JsonProperty("description")
    private String description;

    /**
     * 버전 설명
     */
    @Schema(description = "버전 설명", example = "this is version description")
    @JsonProperty("version_description")
    private String versionDescription;

    /**
     * 배포 대상 ID
     */
    @Schema(description = "화면에서 선택된 배포대상의 id를 설정합니다", example = "c89a7451-3d40-4bab-b4ee-6aecd55b4f32")
    @JsonProperty("target_id")
    private String targetId;

    /**
     * 배포 대상 타입
     */
    @Schema(description = "화면에서 선택된 배포대상의 type 입니다", example = "agent_graph", required = true,
            allowableValues = {"agent_graph", "agent_form"})
    @JsonProperty("target_type")
    @NotBlank(message = "배포 대상 타입은 필수입니다")
    private String targetType;

    /**
     * 서빙 타입
     */
    @Schema(description = "서빙 타입", example = "shared")
    @JsonProperty("serving_type")
    @Builder.Default
    private String servingType = "shared";

    /**
     * CPU 요청량
     */
    @Schema(description = "CPU 요청량", example = "1")
    @JsonProperty("cpu_request")
    private Integer cpuRequest;

    /**
     * CPU 제한량
     */
    @Schema(description = "CPU 제한량", example = "2")
    @JsonProperty("cpu_limit")
    private Integer cpuLimit;

    /**
     * 메모리 요청량
     */
    @Schema(description = "메모리 요청량", example = "2")
    @JsonProperty("mem_request")
    private Integer memRequest;

    /**
     * 메모리 제한량
     */
    @Schema(description = "메모리 제한량", example = "4")
    @JsonProperty("mem_limit")
    private Integer memLimit;

    /**
     * GPU 요청량
     */
    @Schema(description = "GPU 요청량", example = "0")
    @JsonProperty("gpu_request")
    private Integer gpuRequest;

    /**
     * GPU 제한량
     */
    @Schema(description = "GPU 제한량", example = "0")
    @JsonProperty("gpu_limit")
    private Integer gpuLimit;

    /**
     * 최소 복제본 수
     */
    @Schema(description = "최소 복제본 수", example = "1")
    @JsonProperty("min_replicas")
    private Integer minReplicas;

    /**
     * 최대 복제본 수
     */
    @Schema(description = "최대 복제본 수", example = "1")
    @JsonProperty("max_replicas")
    private Integer maxReplicas;

    /**
     * 코어당 워커 수
     */
    @Schema(description = "코어당 워커 수", example = "3")
    @JsonProperty("workers_per_core")
    @Builder.Default
    private Integer workersPerCore = 3;
}
