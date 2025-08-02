package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 태스크 매니저 리소스 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskManagerResource {
    
    @JsonProperty("cpu_quota")
    private Integer cpuQuota;
    
    @JsonProperty("mem_quota")
    private Integer memQuota;
    
    @JsonProperty("gpu_quota")
    private Integer gpuQuota;
    
    @JsonProperty("gpu_type")
    private String gpuType;
}
