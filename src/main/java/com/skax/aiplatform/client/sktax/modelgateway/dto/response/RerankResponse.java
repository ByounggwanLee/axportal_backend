package com.skax.aiplatform.client.sktax.modelgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.modelgateway.dto.RerankData;
import com.skax.aiplatform.client.sktax.modelgateway.dto.Usage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Rerank Response DTO
 * 
 * <p>재순위화 응답을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "재순위화 응답 DTO")
public class RerankResponse {

    /**
     * 응답 ID
     */
    @Schema(description = "재순위화 응답 ID", example = "rerank-5812a0d668243a6b20172866193f286")
    @JsonProperty("id")
    private String id;

    /**
     * 사용된 모델
     */
    @Schema(description = "사용된 모델명", example = "BAAI/bge-reranker-v2-m3")
    @JsonProperty("model")
    private String model;

    /**
     * 재순위화된 데이터 목록
     */
    @Schema(description = "재순위화된 문서 데이터 목록")
    @JsonProperty("data")
    private List<RerankData> data;

    /**
     * 토큰 사용량
     */
    @Schema(description = "토큰 사용량 정보")
    @JsonProperty("usage")
    private Usage usage;
}
