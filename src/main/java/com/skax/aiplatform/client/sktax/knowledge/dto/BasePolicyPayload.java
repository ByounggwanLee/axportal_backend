package com.skax.aiplatform.client.sktax.knowledge.dto;

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
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicyPayload {

    /**
     * 스코프 목록
     */
    @JsonProperty("scopes")
    private List<String> scopes;

    /**
     * 정책 목록
     */
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    /**
     * 로직 (NEGATIVE 또는 POSITIVE)
     */
    @JsonProperty("logic")
    private String logic;

    /**
     * 결정 전략 (AFFIRMATIVE, CONSENSUS, UNANIMOUS)
     */
    @JsonProperty("decision_strategy")
    private String decisionStrategy;
}
