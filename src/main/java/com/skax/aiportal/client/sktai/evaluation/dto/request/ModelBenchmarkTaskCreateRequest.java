package com.skax.aiportal.client.sktai.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 태스크 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkTaskCreateRequest {
    
    @JsonProperty("model_id")
    private String modelId;
    
    @JsonProperty("version_id")
    private String versionId;
    
    @JsonProperty("benchmark_id")
    private Integer benchmarkId;
    
    @JsonProperty("dtype")
    private String dtype;
    
    @JsonProperty("gpu_memory_utilization")
    private Double gpuMemoryUtilization;
    
    @JsonProperty("max_model_len")
    private Integer maxModelLen;
    
    @JsonProperty("resource")
    private TaskManagerResourceRequest resource;
}
