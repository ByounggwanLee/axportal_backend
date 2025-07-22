package com.skax.aiportal.client.sktai.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 모델 엔드포인트 응답 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelEndpointResponse {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("identifier")
    private String identifier;
    
    @JsonProperty("key")
    private String key;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
