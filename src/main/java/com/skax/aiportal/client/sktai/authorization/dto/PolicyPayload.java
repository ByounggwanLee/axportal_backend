package com.skax.aiportal.client.sktai.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * SKT AI 정책 페이로드 DTO
 * 
 * <p>SKT AI 플랫폼의 정책 생성/수정 시 사용되는 페이로드 DTO입니다.
 * 정책의 스코프, 로직, 결정 전략 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 정책 페이로드")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyPayload {

    /**
     * 스코프 목록
     * 정책이 적용될 권한 범위들
     */
    @Schema(description = "스코프 목록", example = "[\"read\", \"write\", \"delete\"]")
    @JsonProperty("scopes")
    @NotNull(message = "스코프는 필수입니다")
    private List<String> scopes;

    /**
     * 정책 목록
     * 적용할 정책들의 세부 정보
     */
    @Schema(description = "정책 목록")
    @JsonProperty("policies")
    private List<BasePolicy> policies;

    /**
     * 로직
     * 정책 평가 로직 (POSITIVE, NEGATIVE)
     */
    @Schema(description = "정책 로직", example = "POSITIVE", allowableValues = {"POSITIVE", "NEGATIVE"})
    @JsonProperty("logic")
    @NotBlank(message = "로직은 필수입니다")
    private String logic;

    /**
     * 결정 전략
     * 여러 정책이 있을 때의 결정 방식
     */
    @Schema(description = "결정 전략", example = "UNANIMOUS", 
            allowableValues = {"AFFIRMATIVE", "UNANIMOUS", "CONSENSUS"})
    @JsonProperty("decision_strategy")
    @NotBlank(message = "결정 전략은 필수입니다")
    private String decisionStrategy;

    /**
     * 정책명 (선택사항)
     */
    @Schema(description = "정책명", example = "user-access-policy")
    @JsonProperty("name")
    private String name;

    /**
     * 정책 설명 (선택사항)
     */
    @Schema(description = "정책 설명", example = "사용자 접근 권한 정책")
    @JsonProperty("description")
    private String description;

    /**
     * 정책 타입 (선택사항)
     */
    @Schema(description = "정책 타입", example = "resource")
    @JsonProperty("type")
    private String type;

    /**
     * 리소스 목록 (선택사항)
     * 정책이 적용될 리소스들
     */
    @Schema(description = "리소스 목록")
    @JsonProperty("resources")
    private List<String> resources;

    /**
     * 조건 (선택사항)
     * 정책 적용 조건
     */
    @Schema(description = "정책 적용 조건")
    @JsonProperty("condition")
    private String condition;

    /**
     * 정책 활성화 여부 (선택사항)
     */
    @Schema(description = "정책 활성화 여부", example = "true")
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * 우선순위 (선택사항)
     */
    @Schema(description = "우선순위", example = "1")
    @JsonProperty("priority")
    private Integer priority;

    /**
     * 팩토리 메서드 - 기본 정책 생성
     */
    public static PolicyPayload createDefault(List<String> scopes) {
        return PolicyPayload.builder()
                .scopes(scopes)
                .logic("POSITIVE")
                .decisionStrategy("UNANIMOUS")
                .enabled(true)
                .priority(1)
                .build();
    }

    /**
     * 팩토리 메서드 - 리소스 기반 정책 생성
     */
    public static PolicyPayload createResourcePolicy(List<String> scopes, List<String> resources, String name) {
        return PolicyPayload.builder()
                .scopes(scopes)
                .resources(resources)
                .name(name)
                .type("resource")
                .logic("POSITIVE")
                .decisionStrategy("UNANIMOUS")
                .enabled(true)
                .priority(1)
                .build();
    }

    /**
     * 팩토리 메서드 - 조건부 정책 생성
     */
    public static PolicyPayload createConditionalPolicy(List<String> scopes, String condition, String name) {
        return PolicyPayload.builder()
                .scopes(scopes)
                .condition(condition)
                .name(name)
                .type("conditional")
                .logic("POSITIVE")
                .decisionStrategy("UNANIMOUS")
                .enabled(true)
                .priority(1)
                .build();
    }
}
