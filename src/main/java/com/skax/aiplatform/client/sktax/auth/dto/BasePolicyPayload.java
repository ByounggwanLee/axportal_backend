package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 기본 정책 Payload DTO
 * 
 * <p>OpenAPI 스키마명: BasePolicyPayload</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "기본 정책 Payload")
public class BasePolicyPayload {

    @JsonProperty("scopes")
    @Schema(description = "접근 범위 목록", allowableValues = {"GET", "POST", "PUT", "DELETE"}, required = true)
    private List<String> scopes;

    @JsonProperty("policies")
    @Schema(description = "정책 목록", required = true)
    private List<BasePolicy> policies;

    @JsonProperty("logic")
    @Schema(description = "논리 연산자", allowableValues = {"NEGATIVE", "POSITIVE"}, defaultValue = "POSITIVE")
    @Builder.Default
    private String logic = "POSITIVE";

    @JsonProperty("decision_strategy")
    @Schema(description = "결정 전략", allowableValues = {"AFFIRMATIVE", "CONSENSUS", "UNANIMOUS"}, defaultValue = "UNANIMOUS")
    @Builder.Default
    private String decisionStrategy = "UNANIMOUS";
}
