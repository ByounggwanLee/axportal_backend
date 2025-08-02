package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelBenchmarkResponse {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("tasks")
    private String tasks;
    
    @JsonProperty("n_fewshot")
    private Integer nFewshot;
    
    @JsonProperty("dataset_id")
    private String datasetId;
    
    @JsonProperty("is_custom")
    private Boolean isCustom;
}
