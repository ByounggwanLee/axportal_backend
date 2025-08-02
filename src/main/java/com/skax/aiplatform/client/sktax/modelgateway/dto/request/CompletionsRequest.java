package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Completions Request DTO
 * 
 * <p>텍스트 완성 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "텍스트 완성 요청 DTO")
public class CompletionsRequest {

    /**
     * 프롬프트
     */
    @Schema(description = "완성할 텍스트 프롬프트", example = "Write a short story about a robot.", required = true)
    @JsonProperty("prompt")
    @NotBlank(message = "프롬프트는 필수입니다")
    private String prompt;

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "text-davinci-003", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 최대 토큰 수
     */
    @Schema(description = "생성할 최대 토큰 수", example = "200")
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    /**
     * 온도 값
     */
    @Schema(description = "생성의 무작위성을 제어하는 온도 값 (0.0 ~ 2.0)", example = "0.7")
    @JsonProperty("temperature")
    private Double temperature;

    /**
     * Top P 값
     */
    @Schema(description = "누적 확률 기준 토큰 선택 (0.0 ~ 1.0)", example = "0.85")
    @JsonProperty("top_p")
    private Double topP;

    /**
     * 빈도 페널티
     */
    @Schema(description = "빈도 기반 페널티 (-2.0 ~ 2.0)", example = "0.2")
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    /**
     * 존재 페널티
     */
    @Schema(description = "존재 기반 페널티 (-2.0 ~ 2.0)", example = "0.3")
    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    /**
     * 스트림 모드
     */
    @Schema(description = "스트림 응답 여부", example = "true")
    @JsonProperty("stream")
    private String stream;
}
