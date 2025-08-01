package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * OpenAPI 명세: Namespace
 * 네임스페이스 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Namespace {

    @JsonProperty("id")
    private String id;

    @JsonProperty("cpu_quota")
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    private Double memQuota;

    @JsonProperty("gpu_quota")
    private Double gpuQuota;

    @JsonProperty("cpu_used")
    private Double cpuUsed;

    @JsonProperty("mem_used")
    private Double memUsed;

    @JsonProperty("gpu_used")
    private Double gpuUsed;

    @JsonProperty("private_volume_name")
    private String privateVolumeName;

    @JsonProperty("cpu_usable")
    private Double cpuUsable;

    @JsonProperty("mem_usable")
    private Double memUsable;

    @JsonProperty("gpu_usable")
    private Double gpuUsable;

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
