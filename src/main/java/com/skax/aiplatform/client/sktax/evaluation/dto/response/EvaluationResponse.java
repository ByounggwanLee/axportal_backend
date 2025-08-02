package com.skax.aiplatform.client.sktax.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.EvaluationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 평가 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationResponse {
    
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
    
    @JsonProperty("type_text")
    private String typeText;
}
