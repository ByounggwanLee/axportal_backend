package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.TaskManagerResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 태스크 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private TaskManagerResource resource;
}
