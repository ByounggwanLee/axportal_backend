package com.skax.aiportal.client.sktai.authorization.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 기본 정책 DTO
 * 
 * <p>SKT AI 권한 관리에서 사용되는 기본 정책 정보를 담는 객체입니다.
 * 정책 타입, 로직, 대상 이름 목록 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "기본 정책",
    description = "SKT AI 권한 관리 시스템의 기본 정책 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasePolicy {

    /**
     * 정책 타입
     * 
     * <p>정책의 종류를 나타냅니다.</p>
     */
    @Schema(
        description = "정책 타입 (role, user, group 등)",
        example = "role",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 50
    )
    @NotBlank(message = "정책 타입은 필수입니다.")
    @Size(max = 50, message = "정책 타입은 50자를 초과할 수 없습니다.")
    @JsonProperty("type")
    private String type;

    /**
     * 정책 로직
     * 
     * <p>정책이 적용되는 방식을 나타냅니다. POSITIVE는 허용, NEGATIVE는 거부를 의미합니다.</p>
     */
    @Schema(
        description = "정책 적용 로직 (POSITIVE: 허용, NEGATIVE: 거부)",
        example = "POSITIVE",
        allowableValues = {"POSITIVE", "NEGATIVE"},
        defaultValue = "POSITIVE"
    )
    @JsonProperty("logic")
    @Builder.Default
    private String logic = "POSITIVE";

    /**
     * 대상 이름 목록
     * 
     * <p>정책이 적용될 대상들의 이름 목록입니다.</p>
     */
    @Schema(
        description = "정책 적용 대상 이름 목록",
        example = "[\"admin\", \"user\", \"guest\"]"
    )
    @JsonProperty("names")
    private List<String> names;
}
