package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKTAX Agent Query Body Message DTO
 * 
 * <p>쿼리 바디 내 메시지 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "쿼리 바디 메시지")
public class QueryBodyMessage {

    /**
     * 메시지 내용
     */
    @NotBlank(message = "메시지 내용은 필수입니다")
    @JsonProperty("content")
    @Schema(description = "메시지 내용", example = "내 이름은 HANI야")
    private String content;

    /**
     * 메시지 타입
     */
    @NotBlank(message = "메시지 타입은 필수입니다")
    @JsonProperty("type")
    @Schema(description = "메시지 타입", example = "human", allowableValues = {"human", "ai", "system"})
    private String type;
}
