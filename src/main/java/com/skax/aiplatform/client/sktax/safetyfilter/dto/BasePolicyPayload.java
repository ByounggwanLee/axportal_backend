package com.skax.aiplatform.client.sktax.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 페이로드 DTO
 * Safety Filter의 정책 설정을 위한 페이로드입니다.
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
     * 스코프 (권한)
     */
    @JsonProperty("scopes")
    @NotNull(message = "스코프는 필수입니다")
    private List<String> scopes; // "GET", "POST", "PUT", "DELETE"

    /**
     * 정책 목록
     */
    @JsonProperty("policies")
    @NotNull(message = "정책 목록은 필수입니다")
    private List<BasePolicy> policies;

    /**
     * 논리 연산자
     */
    @JsonProperty("logic")
    private String logic = "POSITIVE"; // "NEGATIVE", "POSITIVE"

    /**
     * 결정 전략
     */
    @JsonProperty("decision_strategy")
    private String decisionStrategy = "UNANIMOUS"; // "AFFIRMATIVE", "CONSENSUS", "UNANIMOUS"
}
