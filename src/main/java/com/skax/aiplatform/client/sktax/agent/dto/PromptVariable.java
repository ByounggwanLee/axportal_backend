package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Prompt 변수 DTO
 * 
 * <p>Prompt에서 사용되는 변수 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 변수")
public class PromptVariable {

    /**
     * 변수 이름
     */
    @Schema(description = "Name of prompt variables name", 
            example = "{{adjective}}", required = true)
    @JsonProperty("variable")
    @NotBlank(message = "변수 이름은 필수입니다")
    private String variable;

    /**
     * 변수 검증 여부
     */
    @Schema(description = "Flag of variables validation", example = "false")
    @JsonProperty("validation_flag")
    private Boolean validationFlag;

    /**
     * 변수 검증 정규표현식
     */
    @Schema(description = "Regular expression for variables validation", example = "")
    @JsonProperty("validation")
    @NotBlank(message = "검증 정규표현식은 필수입니다")
    private String validation;

    /**
     * 토큰 제한 여부
     */
    @Schema(description = "Flag of the token limit", example = "false")
    @JsonProperty("token_limit_flag")
    private Boolean tokenLimitFlag;

    /**
     * 토큰 제한 크기
     */
    @Schema(description = "Token limit size", example = "0")
    @JsonProperty("token_limit")
    private Integer tokenLimit;
}
