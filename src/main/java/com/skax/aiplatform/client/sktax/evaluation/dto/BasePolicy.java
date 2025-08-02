package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasePolicy {
    
    @JsonProperty("type")
    private PolicyType type;
    
    @JsonProperty("logic")
    private PolicyLogic logic;
    
    @JsonProperty("names")
    private List<String> names;
}
