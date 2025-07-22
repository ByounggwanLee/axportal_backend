package com.skax.aiportal.client.sktai.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 기본 정책 페이로드 클래스
 * 
 * <p>SKT AI 플랫폼의 기본 정책 페이로드 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class BasePolicyPayload {

    /**
     * 정책 범위 (GET, POST, PUT, DELETE)
     */
    @NotEmpty(message = "정책 범위는 최소 하나 이상 필요합니다")
    @JsonProperty("scopes")
    private List<String> scopes;

    /**
     * 기본 정책 목록
     */
    @NotEmpty(message = "정책은 최소 하나 이상 필요합니다")
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    /**
     * 정책 로직 (NEGATIVE, POSITIVE)
     */
    @JsonProperty("logic")
    @Builder.Default
    private String logic = "POSITIVE";

    /**
     * 결정 전략 (AFFIRMATIVE, CONSENSUS, UNANIMOUS)
     */
    @JsonProperty("decision_strategy")
    @Builder.Default
    private String decisionStrategy = "UNANIMOUS";
}
