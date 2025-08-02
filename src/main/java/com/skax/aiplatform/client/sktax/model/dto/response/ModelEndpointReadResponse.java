package com.skax.aiplatform.client.sktax.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 모델 엔드포인트 조회 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelEndpointReadResponse {

    /**
     * 엔드포인트 URL
     */
    @JsonProperty("url")
    private String url;

    /**
     * 식별자
     */
    @JsonProperty("identifier")
    private String identifier;

    /**
     * 키
     */
    @JsonProperty("key")
    private String key;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

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
