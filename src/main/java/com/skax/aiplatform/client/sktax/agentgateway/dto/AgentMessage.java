package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Agent 메시지
 * 
 * <p>Agent 처리를 위한 메시지 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 메시지")
public class AgentMessage {

    /**
     * 메시지 내용
     */
    @JsonProperty("content")
    @NotBlank
    @Schema(description = "메시지 내용", example = "hello")
    private String content;

    /**
     * 메시지 타입
     */
    @JsonProperty("type")
    @NotNull
    @Schema(description = "메시지 타입", example = "human", allowableValues = {"human", "ai", "system"})
    private String type;
}
