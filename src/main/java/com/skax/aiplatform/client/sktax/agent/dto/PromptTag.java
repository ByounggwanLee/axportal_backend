package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Prompt 태그 DTO
 * 
 * <p>Prompt에 설정되는 태그 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 태그")
public class PromptTag {

    /**
     * 태그 이름
     */
    @Schema(description = "Prompt Tag", example = "humor", required = true)
    @JsonProperty("tag")
    @NotBlank(message = "태그 이름은 필수입니다")
    private String tag;
}
