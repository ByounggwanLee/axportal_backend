package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 정책 생성/수정 요청 DTO
 * 
 * <p>특정 리소스에 대한 [Role|User|Group] 정책을 생성/수정하기 위한 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "정책 생성/수정 요청")
public class PolicyPayloadInputReq {

    @JsonProperty("scopes")
    @Schema(description = "접근 범위 목록", example = "[\"GET\", \"POST\", \"PUT\", \"DELETE\"]", required = true)
    private List<String> scopes;

    @JsonProperty("policies")
    @Schema(description = "정책 목록", required = true)
    private List<BasePolicy> policies;

    @JsonProperty("logic")
    @Schema(description = "논리 연산자", example = "POSITIVE", defaultValue = "POSITIVE")
    @Builder.Default
    private String logic = "POSITIVE";

    @JsonProperty("decision_strategy")
    @Schema(description = "결정 전략", example = "UNANIMOUS", defaultValue = "UNANIMOUS")
    @Builder.Default
    private String decisionStrategy = "UNANIMOUS";

    /**
     * 기본 정책 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "기본 정책")
    public static class BasePolicy {

        @JsonProperty("type")
        @Schema(description = "정책 타입", example = "user", allowableValues = {"user", "group", "role", "token-exchange"}, required = true)
        private String type;

        @JsonProperty("logic")
        @Schema(description = "논리 연산자", example = "POSITIVE", defaultValue = "POSITIVE")
        @Builder.Default
        private String logic = "POSITIVE";

        @JsonProperty("names")
        @Schema(description = "대상 이름 목록", example = "[\"admin\"]", required = true)
        private List<String> names;
    }
}
