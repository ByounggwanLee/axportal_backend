package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: UpdateNamespace
 * 네임스페이스 업데이트 요청
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNamespace {

    @JsonProperty("cpu_quota")
    private Double cpuQuota;

    @JsonProperty("mem_quota")
    private Double memQuota;

    @JsonProperty("gpu_quota")
    private Double gpuQuota;
}
