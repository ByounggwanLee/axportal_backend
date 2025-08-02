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
 * Embeddings Request DTO
 * 
 * <p>임베딩 생성 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "임베딩 생성 요청 DTO")
public class EmbeddingsRequest {

    /**
     * 입력 데이터
     */
    @Schema(description = "임베딩을 생성할 입력 데이터 (문자열 또는 배열)", required = true)
    @JsonProperty("input")
    @NotNull(message = "입력 데이터는 필수입니다")
    private Object input;

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "text-embedding-ada-002", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 인코딩 형식
     */
    @Schema(description = "인코딩 형식", example = "float")
    @JsonProperty("encoding_format")
    private String encodingFormat;
}
