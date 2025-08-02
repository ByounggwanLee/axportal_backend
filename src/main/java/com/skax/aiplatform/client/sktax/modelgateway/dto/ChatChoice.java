package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Chat Choice DTO
 * 
 * <p>채팅 선택지를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "채팅 선택지 DTO")
public class ChatChoice {

    /**
     * 완료 이유
     */
    @Schema(description = "응답 완료 이유", example = "length")
    @JsonProperty("finish_reason")
    private String finishReason;

    /**
     * 선택지 인덱스
     */
    @Schema(description = "선택지 인덱스", example = "0")
    @JsonProperty("index")
    private Integer index;

    /**
     * 메시지
     */
    @Schema(description = "생성된 메시지")
    @JsonProperty("message")
    private ChatMessage message;
}
