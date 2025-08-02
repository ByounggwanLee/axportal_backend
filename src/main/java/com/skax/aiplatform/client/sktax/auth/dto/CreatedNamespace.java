package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * OpenAPI 명세: CreatedNamespace
 * 생성된 네임스페이스 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedNamespace {

    @JsonProperty("id")
    private String id;

    @JsonProperty("private_volume_name")
    private String privateVolumeName;

    @JsonProperty("cpu_quota")
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    private Double memQuota;

    @JsonProperty("gpu_quota")
    private Double gpuQuota;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("creator")
    private String creator;

    @JsonProperty("modifier")
    private String modifier;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("modified_at")
    private LocalDateTime modifiedAt;
}
