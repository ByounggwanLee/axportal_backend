package com.skax.aiplatform.client.sktax.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 모델 승격 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelPromoteRequest {

    /**
     * 모델 표시명
     */
    @JsonProperty("display_name")
    @NotBlank(message = "모델 표시명은 필수입니다")
    @Size(max = 255, message = "모델 표시명은 255자를 초과할 수 없습니다")
    private String displayName;

    /**
     * 승격된 버전의 설명
     */
    @JsonProperty("description")
    @NotBlank(message = "설명은 필수입니다")
    private String description;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
