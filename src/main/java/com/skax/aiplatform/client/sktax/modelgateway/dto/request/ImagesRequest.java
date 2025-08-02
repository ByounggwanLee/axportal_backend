package com.skax.aiplatform.client.sktax.modelgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Images Request DTO
 * 
 * <p>이미지 생성 요청을 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "이미지 생성 요청 DTO")
public class ImagesRequest {

    /**
     * 프롬프트
     */
    @Schema(description = "이미지 생성을 위한 프롬프트", example = "A cute baby sea otter.", required = true)
    @JsonProperty("prompt")
    @NotBlank(message = "프롬프트는 필수입니다")
    private String prompt;

    /**
     * 모델명
     */
    @Schema(description = "사용할 모델명", example = "dall-e-3", required = true)
    @JsonProperty("model")
    @NotBlank(message = "모델명은 필수입니다")
    private String model;

    /**
     * 생성할 이미지 수
     */
    @Schema(description = "생성할 이미지 수", example = "1")
    @JsonProperty("n")
    private Integer n;

    /**
     * 이미지 크기
     */
    @Schema(description = "생성할 이미지 크기", example = "1024x1024")
    @JsonProperty("size")
    private String size;
}
