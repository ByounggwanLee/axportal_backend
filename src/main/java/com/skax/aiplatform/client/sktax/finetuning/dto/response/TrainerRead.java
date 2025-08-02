package com.skax.aiplatform.client.sktax.finetuning.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Trainer 조회 응답 DTO
 * 트레이너 정보 조회 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerRead {

    /**
     * 레지스트리 URL
     */
    @JsonProperty("registry_url")
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

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
