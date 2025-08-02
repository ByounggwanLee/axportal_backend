package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 네임스페이스 기본 정보 DTO
 * 
 * <p>OpenAPI 스키마명: NamespaceBase</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "네임스페이스 기본 정보")
public class NamespaceBase {

    @JsonProperty("id")
    @Schema(description = "네임스페이스 ID", required = true)
    private String id;

    @JsonProperty("name")
    @Schema(description = "네임스페이스명", required = true)
    private String name;

    @JsonProperty("description")
    @Schema(description = "설명")
    private String description;

    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량")
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량")
    private Double memQuota;

    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량")
    private Double gpuQuota;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", required = true)
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "수정 일시")
    private String updatedAt;
}
