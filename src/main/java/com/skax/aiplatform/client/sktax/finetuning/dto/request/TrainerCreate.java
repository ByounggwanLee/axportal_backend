package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.finetuning.dto.PolicyPayload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Trainer 생성 요청 DTO
 * 새로운 트레이너를 생성하기 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerCreate {

    /**
     * 레지스트리 URL
     */
    @JsonProperty("registry_url")
    @NotBlank(message = "레지스트리 URL은 필수입니다")
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
    @NotBlank(message = "기본 파라미터는 필수입니다")
    private String defaultParams;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
