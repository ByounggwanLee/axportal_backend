package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.CompletionChoice;
import com.skax.aiplatform.client.sktax.modelgateway.dto.Usage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Completion Response DTO
 * 
 * <p>텍스트 완성 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "텍스트 완성 응답 DTO")
public class CompletionResponse {

    /**
     * 응답 ID
     */
    @Schema(description = "완성 응답 ID", example = "cmpl-9c8f26002e7e409c8d54c069c5a4b320")
    @JsonProperty("id")
    private String id;

    /**
     * 선택지 목록
     */
    @Schema(description = "생성된 텍스트 선택지 목록")
    @JsonProperty("choices")
    private List<CompletionChoice> choices;

    /**
     * 생성 시간
     */
    @Schema(description = "응답 생성 시간 (Unix 타임스탬프)", example = "1728003086")
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
    @Schema(description = "응답 객체 타입", example = "text_completion")
    @JsonProperty("object")
    private String object;

    /**
     * 토큰 사용량
     */
    @Schema(description = "토큰 사용량 정보")
    @JsonProperty("usage")
    private Usage usage;
}
