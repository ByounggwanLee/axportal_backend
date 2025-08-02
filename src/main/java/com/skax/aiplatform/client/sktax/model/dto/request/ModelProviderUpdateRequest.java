package com.skax.aiplatform.client.sktax.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Size;

/**
 * 모델 제공자 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelProviderUpdateRequest {

    /**
     * 제공자명
     */
    @JsonProperty("name")
    @Size(max = 255, message = "제공자명은 255자를 초과할 수 없습니다")
    private String name;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 로고 URL
     */
    @JsonProperty("logo")
    @Size(max = 255, message = "로고 URL은 255자를 초과할 수 없습니다")
    private String logo;
}
