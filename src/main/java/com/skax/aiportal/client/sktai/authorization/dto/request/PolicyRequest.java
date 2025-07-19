package com.skax.aiportal.client.sktai.authorization.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.BasePolicy;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI 정책 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 정책 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequest {

    @Schema(description = "스코프 목록")
    @JsonProperty("scopes")
    private List<String> scopes;

    @Schema(description = "정책 목록")
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    @Schema(description = "로직")
    @JsonProperty("logic")
    @Builder.Default
    private String logic = "POSITIVE";

    @Schema(description = "결정 전략")
    @JsonProperty("decision_strategy")
    @Builder.Default
    private String decisionStrategy = "UNANIMOUS";
}

