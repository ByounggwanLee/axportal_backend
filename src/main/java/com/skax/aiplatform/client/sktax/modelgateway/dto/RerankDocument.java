package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Rerank Document DTO
 * 
 * <p>재순위화 문서를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "재순위화 문서 DTO")
public class RerankDocument {

    /**
     * 문서 텍스트
     */
    @Schema(description = "문서 텍스트 내용")
    @JsonProperty("text")
    private String text;
}
