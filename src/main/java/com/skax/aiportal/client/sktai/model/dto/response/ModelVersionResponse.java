package com.skax.aiportal.client.sktai.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 모델 버전 응답 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionResponse {
    
    @JsonProperty("path")
    private String path;
    
    @JsonProperty("fine_tuning_id")
    private String fineTuningId;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("is_valid")
    private Boolean isValid;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("parent_id")
    private String parentId;
    
    @JsonProperty("version")
    private Integer version;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
