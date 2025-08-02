package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Score Request DTO
 * 
 * <p>점수 계산 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "점수 계산 요청 DTO")
public class ScoreRequest {

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "BAAI/bge-reranker-v2-m3", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 첫 번째 텍스트
     */
    @Schema(description = "비교할 첫 번째 텍스트", example = "What is the capital of France?", required = true)
    @JsonProperty("text_1")
    @NotNull(message = "첫 번째 텍스트는 필수입니다")
    private Object text1;

    /**
     * 두 번째 텍스트
     */
    @Schema(description = "비교할 두 번째 텍스트", example = "The capital of France is Paris.", required = true)
    @JsonProperty("text_2")
    @NotNull(message = "두 번째 텍스트는 필수입니다")
    private Object text2;

    /**
     * 인코딩 형식
     */
    @Schema(description = "인코딩 형식", example = "float")
    @JsonProperty("encoding_format")
    private String encodingFormat;
}
