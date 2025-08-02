package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Chat Message DTO
 * 
 * <p>채팅 메시지를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채팅 메시지 DTO")
public class ChatMessage {

    /**
     * 메시지 내용
     */
    @Schema(description = "메시지 내용")
    @JsonProperty("content")
    private String content;

    /**
     * 메시지 역할
     */
    @Schema(description = "메시지 역할", example = "assistant")
    @JsonProperty("role")
    private String role;

    /**
     * 도구 호출
     */
    @Schema(description = "도구 호출 목록")
    @JsonProperty("tool_calls")
    private List<Object> toolCalls;
}
