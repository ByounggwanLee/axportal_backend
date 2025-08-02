package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Rerank Request DTO
 * 
 * <p>재순위화 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "재순위화 요청 DTO")
public class RerankRequest {

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "BAAI/bge-reranker-v2-m3", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 쿼리
     */
    @Schema(description = "검색 쿼리", example = "What is the capital of the United States?", required = true)
    @JsonProperty("query")
    @NotBlank(message = "쿼리는 필수입니다")
    private String query;

    /**
     * 문서 목록
     */
    @Schema(description = "재순위화할 문서 목록", required = true)
    @JsonProperty("documents")
    @NotNull(message = "문서 목록은 필수입니다")
    private List<String> documents;
}
