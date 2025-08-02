package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent 응답 메타데이터
 * 
 * <p>Agent 응답에 포함되는 메타 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent 응답 메타데이터")
public class AgentResponseMetadata {

    /**
     * 완료 이유
     */
    @JsonProperty("finish_reason")
    @Schema(description = "완료 이유", example = "stop")
    private String finishReason;

    /**
     * 모델명
     */
    @JsonProperty("model_name")
    @Schema(description = "사용된 모델명", example = "gpt-4o-2024-05-13")
    private String modelName;

    /**
     * 시스템 지문
     */
    @JsonProperty("system_fingerprint")
    @Schema(description = "시스템 지문", example = "fp_1b6075558b")
    private String systemFingerprint;

    /**
     * 토큰 사용량
     */
    @JsonProperty("token_usage")
    @Schema(description = "토큰 사용량")
    private AgentTokenUsage tokenUsage;
}
