package com.skax.aiportal.client.sktai.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 버전 업데이트 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionUpdateRequest {
    
    @JsonProperty("path")
    private String path;
    
    @JsonProperty("fine_tuning_id")
    private String fineTuningId;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("is_valid")
    private Boolean isValid;
}
