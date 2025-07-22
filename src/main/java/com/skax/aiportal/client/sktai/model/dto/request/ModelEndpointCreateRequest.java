package com.skax.aiportal.client.sktai.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 엔드포인트 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelEndpointCreateRequest {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("identifier")
    private String identifier;
    
    @JsonProperty("key")
    private String key;
    
    @JsonProperty("description")
    private String description;
}
