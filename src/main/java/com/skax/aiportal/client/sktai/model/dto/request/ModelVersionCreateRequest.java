package com.skax.aiportal.client.sktai.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 모델 버전 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionCreateRequest {
    
    @JsonProperty("path")
    private String path;
    
    @JsonProperty("fine_tuning_id")
    private String fineTuningId;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("is_valid")
    private Boolean isValid;
    
    @JsonProperty("policy")
    private List<Object> policy;
}
