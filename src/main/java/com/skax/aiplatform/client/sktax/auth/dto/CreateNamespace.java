package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: CreateNamespace
 * 네임스페이스 생성 요청
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNamespace {

    @JsonProperty("cpu_quota")
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    private Double memQuota;

    @JsonProperty("gpu_quota")
    private Double gpuQuota;

    @JsonProperty("private_volume_name")
    private String privateVolumeName;
}
