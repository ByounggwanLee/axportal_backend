package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Completion Choice DTO
 * 
 * <p>텍스트 완성 선택지를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "텍스트 완성 선택지 DTO")
public class CompletionChoice {

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
     * 생성된 텍스트
     */
    @Schema(description = "생성된 텍스트", example = "\\nSK~~~~~")
    @JsonProperty("text")
    private String text;
}
