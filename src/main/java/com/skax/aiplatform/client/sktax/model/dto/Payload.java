package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 페이로드 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    @NotNull(message = "페이지네이션 정보는 필수입니다")
    private Pagination pagination;
}
