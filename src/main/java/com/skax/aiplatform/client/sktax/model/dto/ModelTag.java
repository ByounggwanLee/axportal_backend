package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 모델 태그 DTO
 * 모델의 태그 정보를 나타냅니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelTag {

    /**
     * 태그명
     */
    @JsonProperty("name")
    @NotBlank(message = "태그명은 필수입니다")
    @Size(max = 255, message = "태그명은 255자를 초과할 수 없습니다")
    private String name;

    /**
     * ID
     */
    @JsonProperty("id")
    private Integer id;

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
