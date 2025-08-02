package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Rerank Data DTO
 * 
 * <p>재순위화 데이터를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "재순위화 데이터 DTO")
public class RerankData {

    /**
     * 인덱스
     */
    @Schema(description = "문서 인덱스", example = "2")
    @JsonProperty("index")
    private Integer index;

    /**
     * 문서
     */
    @Schema(description = "문서 정보")
    @JsonProperty("document")
    private RerankDocument document;

    /**
     * 관련성 점수
     */
    @Schema(description = "관련성 점수", example = "0.9970703125")
    @JsonProperty("relevance_score")
    private String relevanceScore;
}
