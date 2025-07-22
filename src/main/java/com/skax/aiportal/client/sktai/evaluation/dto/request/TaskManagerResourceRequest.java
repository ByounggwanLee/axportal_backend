package com.skax.aiportal.client.sktai.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 태스크 리소스 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskManagerResourceRequest {
    
    @JsonProperty("cpu_quota")
    private Integer cpuQuota;
    
    @JsonProperty("mem_quota")
    private Integer memQuota;
    
    @JsonProperty("gpu_quota")
    private Integer gpuQuota;
    
    @JsonProperty("gpu_type")
    private String gpuType;
}
