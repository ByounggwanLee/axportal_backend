package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.EmbeddingData;
import com.skax.aiplatform.client.sktax.modelgateway.dto.Usage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Embedding Response DTO
 * 
 * <p>임베딩 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "임베딩 응답 DTO")
public class EmbeddingResponse {

    /**
     * 임베딩 데이터 목록
     */
    @Schema(description = "생성된 임베딩 데이터 목록")
    @JsonProperty("data")
    private List<EmbeddingData> data;

    /**
     * 사용된 모델
     */
    @Schema(description = "사용된 모델명", example = "text-embedding-3-large")
    @JsonProperty("model")
    private String model;

    /**
     * 객체 타입
     */
    @Schema(description = "응답 객체 타입", example = "list")
    @JsonProperty("object")
    private String object;

    /**
     * 토큰 사용량
     */
    @Schema(description = "토큰 사용량 정보")
    @JsonProperty("usage")
    private Usage usage;
}
