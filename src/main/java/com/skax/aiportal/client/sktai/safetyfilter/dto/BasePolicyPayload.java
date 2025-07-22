package com.skax.aiportal.client.sktai.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 페이로드 클래스
 * 
 * 안전 필터의 정책 페이로드 정보를 담습니다.
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
    private List<HttpScope> scopes;

    /**
     * 정책 목록
     */
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    /**
     * 논리 연산자
     */
    @JsonProperty("logic")
    private BasePolicy.PolicyLogic logic;

    /**
     * 결정 전략
     */
    @JsonProperty("decision_strategy")
    private DecisionStrategy decisionStrategy;

    /**
     * HTTP 스코프 열거형
     */
    public enum HttpScope {
        @JsonProperty("GET")
        GET,
        @JsonProperty("POST")
        POST,
        @JsonProperty("PUT")
        PUT,
        @JsonProperty("DELETE")
        DELETE
    }

    /**
     * 결정 전략 열거형
     */
    public enum DecisionStrategy {
        @JsonProperty("AFFIRMATIVE")
        AFFIRMATIVE,
        @JsonProperty("CONSENSUS")
        CONSENSUS,
        @JsonProperty("UNANIMOUS")
        UNANIMOUS
    }
}
