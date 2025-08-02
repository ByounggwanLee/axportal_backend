package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 페이로드 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasePolicyPayload {
    
    @JsonProperty("scopes")
    private List<HttpScope> scopes;
    
    @JsonProperty("policies")
    private List<BasePolicy> policies;
    
    @JsonProperty("logic")
    private PolicyLogic logic;
    
    @JsonProperty("decision_strategy")
    private DecisionStrategy decisionStrategy;
}
