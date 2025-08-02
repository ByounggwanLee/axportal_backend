package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Usage DTO
 * 
 * <p>토큰 사용량을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "토큰 사용량 DTO")
public class Usage {

    /**
     * 완성 토큰 수
     */
    @Schema(description = "완성에 사용된 토큰 수", example = "60")
    @JsonProperty("completion_tokens")
    private Integer completionTokens;

    /**
     * 프롬프트 토큰 수
     */
    @Schema(description = "프롬프트에 사용된 토큰 수", example = "34")
    @JsonProperty("prompt_tokens")
    private Integer promptTokens;

    /**
     * 총 토큰 수
     */
    @Schema(description = "총 사용된 토큰 수", example = "94")
    @JsonProperty("total_tokens")
    private Integer totalTokens;
}
