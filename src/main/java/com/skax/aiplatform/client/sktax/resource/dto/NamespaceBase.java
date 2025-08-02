package com.skax.aiplatform.client.sktax.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Namespace Base DTO
 * 
 * <p>Namespace의 기본 정보를 담는 DTO입니다.
 * Namespace 수정 시 사용되는 요청 데이터의 기본 구조를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Schema(description = "Namespace 기본 정보")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NamespaceBase {

    /**
     * 프로젝트 ID
     */
    @Schema(description = "프로젝트 ID", example = "629b5f03-d2bc-405b-b601-73168fc92e73")
    @JsonProperty("project_id")
    private String projectId;

    /**
     * CPU 할당량
     */
    @Schema(description = "CPU 할당량", example = "4", required = true)
    @JsonProperty("cpu_quota")
    @NotNull(message = "CPU 할당량은 필수입니다")
    private Double cpuQuota;

    /**
     * 메모리 할당량 (GB)
     */
    @Schema(description = "메모리 할당량 (GB)", example = "16", required = true)
    @JsonProperty("mem_quota")
    @NotNull(message = "메모리 할당량은 필수입니다")
    private Double memQuota;

    /**
     * GPU 할당량
     */
    @Schema(description = "GPU 할당량", example = "1", required = true)
    @JsonProperty("gpu_quota")
    @NotNull(message = "GPU 할당량은 필수입니다")
    private Double gpuQuota;
}
