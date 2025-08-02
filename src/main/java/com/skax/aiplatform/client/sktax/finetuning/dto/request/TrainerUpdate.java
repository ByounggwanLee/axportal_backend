package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Trainer 수정 요청 DTO
 * 기존 트레이너를 수정하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerUpdate {

    /**
     * 레지스트리 URL
     */
    @JsonProperty("registry_url")
    @Size(max = 255, message = "레지스트리 URL은 255자를 초과할 수 없습니다")
    private String registryUrl;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 기본 파라미터
     */
    @JsonProperty("default_params")
    private String defaultParams;
}
