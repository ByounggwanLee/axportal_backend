package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Base Policy Payload DTO
 * 기본 정책 페이로드를 나타내는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePolicyPayload {

    /**
     * 정책 스코프 목록
     */
    @JsonProperty("scopes")
    private List<PolicyScopeEnum> scopes;

    /**
     * 정책 목록
     */
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    /**
     * 로직 타입
     */
    @JsonProperty("logic")
    private PolicyLogicEnum logic = PolicyLogicEnum.POSITIVE;

    /**
     * 의사결정 전략
     */
    @JsonProperty("decision_strategy")
    private DecisionStrategyEnum decisionStrategy = DecisionStrategyEnum.UNANIMOUS;
}
