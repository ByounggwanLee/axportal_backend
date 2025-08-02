package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 모델 언어 기본 DTO
 * 모델이 지원하는 언어 정보를 나타냅니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelLanguageBase {

    /**
     * 언어명
     */
    @JsonProperty("name")
    @NotBlank(message = "언어명은 필수입니다")
    @Size(max = 64, message = "언어명은 64자를 초과할 수 없습니다")
    private String name;
}
