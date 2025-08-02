package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.ChatChoice;
import com.skax.aiplatform.client.sktax.modelgateway.dto.Usage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Chat Completion Response DTO
 * 
 * <p>채팅 완성 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채팅 완성 응답 DTO")
public class ChatCompletionResponse {

    /**
     * 응답 ID
     */
    @Schema(description = "채팅 완성 응답 ID", example = "chat-f1b7ae76b4a143e6967e3fd40008e00a")
    @JsonProperty("id")
    private String id;

    /**
     * 선택지 목록
     */
    @Schema(description = "생성된 응답 선택지 목록")
    @JsonProperty("choices")
    private List<ChatChoice> choices;

    /**
     * 생성 시간
     */
    @Schema(description = "응답 생성 시간 (Unix 타임스탬프)", example = "1727999548")
    @JsonProperty("created")
    private Long created;

    /**
     * 사용된 모델
     */
    @Schema(description = "사용된 모델명", example = "/mnt/models")
    @JsonProperty("model")
    private String model;

    /**
     * 객체 타입
     */
    @Schema(description = "응답 객체 타입", example = "chat.completion")
    @JsonProperty("object")
    private String object;

    /**
     * 토큰 사용량
     */
    @Schema(description = "토큰 사용량 정보")
    @JsonProperty("usage")
    private Usage usage;
}
