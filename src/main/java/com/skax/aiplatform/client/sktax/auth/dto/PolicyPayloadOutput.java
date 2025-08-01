package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 정책 Payload 출력 DTO
 * 
 * <p>OpenAPI 스키마명: PolicyPayload-Output</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "정책 Payload 출력")
public class PolicyPayloadOutput {

    @JsonProperty("scopes")
    @Schema(description = "접근 범위 목록", required = true)
    private List<String> scopes;

    @JsonProperty("policies")
    @Schema(description = "정책 목록", required = true)
    private List<BasePolicy> policies;

    @JsonProperty("logic")
    @Schema(description = "논리 연산자", defaultValue = "POSITIVE")
    private String logic;

    @JsonProperty("decision_strategy")
    @Schema(description = "결정 전략", defaultValue = "UNANIMOUS")
    private String decisionStrategy;
}
