package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent 토큰 사용량
 * 
 * <p>Agent 실행 시 사용된 토큰 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 토큰 사용량")
public class AgentTokenUsage {

    /**
     * 완료 토큰 수
     */
    @JsonProperty("completion_tokens")
    @Schema(description = "완료 토큰 수", example = "30")
    private Integer completionTokens;

    /**
     * 프롬프트 토큰 수
     */
    @JsonProperty("prompt_tokens")
    @Schema(description = "프롬프트 토큰 수", example = "13")
    private Integer promptTokens;

    /**
     * 총 토큰 수
     */
    @JsonProperty("total_tokens")
    @Schema(description = "총 토큰 수", example = "43")
    private Integer totalTokens;
}
