package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Prompt 복사 요청 DTO
 * 
 * <p>Prompt 복사 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 복사 요청")
public class PromptCopyRequest {

    /**
     * 새 Prompt 이름
     */
    @Schema(description = "New prompt name", example = "Insurance Consultation Prompt Copy", required = true)
    @JsonProperty("new_name")
    @NotBlank(message = "새 Prompt 이름은 필수입니다")
    private String newName;
}
