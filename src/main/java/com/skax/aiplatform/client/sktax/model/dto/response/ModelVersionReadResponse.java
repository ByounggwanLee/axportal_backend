package com.skax.aiplatform.client.sktax.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 모델 버전 조회 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionReadResponse {

    /**
     * 모델 파일 경로
     */
    @JsonProperty("path")
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
    private Boolean isValid;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 부모 ID (모델 ID)
     */
    @JsonProperty("parent_id")
    private UUID parentId;

    /**
     * 버전 번호
     */
    @JsonProperty("version")
    private Integer version;

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
