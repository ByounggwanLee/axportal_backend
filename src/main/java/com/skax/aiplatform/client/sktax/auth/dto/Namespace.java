package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 네임스페이스 DTO
 * 
 * <p>OpenAPI 스키마명: Namespace</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "네임스페이스")
public class Namespace {

    @JsonProperty("id")
    @Schema(description = "ID", required = true)
    private String id;

    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량", required = true)
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량", required = true)
    private Double memQuota;

    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량", required = true)
    private Double gpuQuota;

    @JsonProperty("cpu_used")
    @Schema(description = "CPU 사용량")
    private Double cpuUsed;

    @JsonProperty("mem_used")
    @Schema(description = "메모리 사용량")
    private Double memUsed;

    @JsonProperty("gpu_used")
    @Schema(description = "GPU 사용량")
    private Double gpuUsed;

    @JsonProperty("private_volume_name")
    @Schema(description = "프라이빗 볼륨명")
    private String privateVolumeName;

    @JsonProperty("cpu_usable")
    @Schema(description = "사용 가능한 CPU")
    private Double cpuUsable;

    @JsonProperty("mem_usable")
    @Schema(description = "사용 가능한 메모리")
    private Double memUsable;

    @JsonProperty("gpu_usable")
    @Schema(description = "사용 가능한 GPU")
    private Double gpuUsable;

    @JsonProperty("name")
    @Schema(description = "이름", required = true)
    private String name;

    @JsonProperty("description")
    @Schema(description = "설명")
    private String description;

    @JsonProperty("creator")
    @Schema(description = "생성자", required = true)
    private String creator;

    @JsonProperty("modifier")
    @Schema(description = "수정자")
    private String modifier;

    @JsonProperty("created_at")
    @Schema(description = "생성일시", required = true)
    private LocalDateTime createdAt;

    @JsonProperty("modified_at")
    @Schema(description = "수정일시")
    private LocalDateTime modifiedAt;
}
