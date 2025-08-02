package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.EvaluationType;
import com.skax.aiplatform.client.sktax.evaluation.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 평가 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationCreateRequest {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("type")
    private EvaluationType type;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("tasks")
    private String tasks;
    
    @JsonProperty("dataset_id")
    private String datasetId;
    
    @JsonProperty("is_custom")
    private Boolean isCustom;
    
    @JsonProperty("policy")
    private PolicyPayload policy;
}
