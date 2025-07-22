package com.skax.aiportal.client.sktai.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 모델 프로모션 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelPromoteRequest {
    
    @JsonProperty("display_name")
    private String displayName;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("policy")
    private List<Object> policy;
}
