package com.skax.aiplatform.client.sktax.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 모델 엔드포인트 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelEndpointCreateRequest {

    /**
     * 엔드포인트 URL
     */
    @JsonProperty("url")
    @NotBlank(message = "URL은 필수입니다")
    @Size(max = 255, message = "URL은 255자를 초과할 수 없습니다")
    private String url;

    /**
     * 식별자
     */
    @JsonProperty("identifier")
    @NotBlank(message = "식별자는 필수입니다")
    @Size(max = 255, message = "식별자는 255자를 초과할 수 없습니다")
    private String identifier;

    /**
     * 키
     */
    @JsonProperty("key")
    @NotBlank(message = "키는 필수입니다")
    @Size(max = 255, message = "키는 255자를 초과할 수 없습니다")
    private String key;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;
}
