package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Embedding Data DTO
 * 
 * <p>임베딩 데이터를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "임베딩 데이터 DTO")
public class EmbeddingData {

    /**
     * 임베딩 벡터
     */
    @Schema(description = "임베딩 벡터 배열")
    @JsonProperty("embedding")
    private List<Double> embedding;

    /**
     * 인덱스
     */
    @Schema(description = "데이터 인덱스", example = "0")
    @JsonProperty("index")
    private Integer index;

    /**
     * 객체 타입
     */
    @Schema(description = "객체 타입", example = "embedding")
    @JsonProperty("object")
    private String object;
}
