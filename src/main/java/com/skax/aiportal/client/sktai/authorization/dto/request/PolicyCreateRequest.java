package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 * SKT AI 정책 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼의 정책 생성 API 요청을 매핑하는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 정책 생성 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyCreateRequest {

    /**
     * 정책명
     */
    @Schema(description = "정책명", example = "user-access-policy")
    @JsonProperty("name")
    @NotBlank(message = "정책명은 필수입니다")
    private String name;

    /**
     * 정책 설명
     */
    @Schema(description = "정책 설명", example = "사용자 접근 정책")
    @JsonProperty("description")
    private String description;

    /**
     * 리소스 URL
     */
    @Schema(description = "리소스 URL", example = "/api/v1/users")
    @JsonProperty("resource_url")
    @NotBlank(message = "리소스 URL은 필수입니다")
    private String resourceUrl;

    /**
     * 스코프 목록
     */
    @Schema(description = "스코프 목록")
    @JsonProperty("scopes")
    private List<String> scopes;

    /**
     * 정책 타입
     */
    @Schema(description = "정책 타입", example = "permission")
    @JsonProperty("type")
    private String type;

    /**
     * 로직
     */
    @Schema(description = "로직", example = "POSITIVE")
    @JsonProperty("logic")
    private String logic;

    /**
     * 결정 전략
     */
    @Schema(description = "결정 전략", example = "UNANIMOUS")
    @JsonProperty("decision_strategy")
    private String decisionStrategy;
}
