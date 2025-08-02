package com.skax.aiplatform.client.sktax.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

/**
 * 모델 버전 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionCreateRequest {

    /**
     * 모델 파일 경로
     */
    @JsonProperty("path")
    @NotBlank(message = "경로는 필수입니다")
    @Size(max = 255, message = "경로는 255자를 초과할 수 없습니다")
    private String path;

    /**
     * 파인튜닝 ID
     */
    @JsonProperty("fine_tuning_id")
    private UUID fineTuningId;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 유효 여부
     */
    @JsonProperty("is_valid")
    @Builder.Default
    private Boolean isValid = true;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
