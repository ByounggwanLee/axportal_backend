package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Prompt 메시지 DTO
 * 
 * <p>Prompt에 포함되는 메시지 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 메시지")
public class PromptMessage {

    /**
     * 메시지 타입 (0: text, 1: system, 2: user, 3: assistant)
     */
    @Schema(description = "Prompt message type (0: text, 1: system, 2: user, 3: assistant)", 
            example = "0", allowableValues = {"0", "1", "2", "3"})
    @JsonProperty("mtype")
    @Builder.Default
    private Integer mtype = 0;

    /**
     * 메시지 내용
     */
    @Schema(description = "Prompt message", 
            example = "Tell me a {{adjective}} joke about {{content}}.", required = true)
    @JsonProperty("message")
    @NotBlank(message = "메시지 내용은 필수입니다")
    private String message;
}
