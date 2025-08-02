package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Chat Completions Request DTO
 * 
 * <p>채팅 완성 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채팅 완성 요청 DTO")
public class ChatCompletionsRequest {

    /**
     * 메시지 목록
     */
    @Schema(description = "채팅 메시지 목록", required = true)
    @JsonProperty("messages")
    @NotNull(message = "메시지 목록은 필수입니다")
    private List<Object> messages;

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "gpt-4", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 최대 토큰 수
     */
    @Schema(description = "생성할 최대 토큰 수", example = "100")
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
    @Schema(description = "누적 확률 기준 토큰 선택 (0.0 ~ 1.0)", example = "0.9")
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
    @Schema(description = "존재 기반 페널티 (-2.0 ~ 2.0)", example = "0.5")
    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    /**
     * 스트림 모드
     */
    @Schema(description = "스트림 응답 여부", example = "false")
    @JsonProperty("stream")
    private Boolean stream;
}
