package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 모델 태스크 기본 DTO
 * 모델이 수행할 수 있는 태스크 정보를 나타냅니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelTaskBase {

    /**
     * 태스크명
     */
    @JsonProperty("name")
    @NotBlank(message = "태스크명은 필수입니다")
    @Size(max = 64, message = "태스크명은 64자를 초과할 수 없습니다")
    private String name;
}
