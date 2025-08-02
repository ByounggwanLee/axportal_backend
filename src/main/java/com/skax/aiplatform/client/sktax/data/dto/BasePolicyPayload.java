package com.skax.aiplatform.client.sktax.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 기본 정책 페이로드 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
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
     * 로직 (NEGATIVE, POSITIVE)
     */
    @JsonProperty("logic")
    private String logic;

    /**
     * 결정 전략 (AFFIRMATIVE, CONSENSUS, UNANIMOUS)
     */
    @JsonProperty("decision_strategy")
    private String decisionStrategy;
}
