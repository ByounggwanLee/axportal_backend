package com.skax.aiplatform.client.sktax.history.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이로드 정보
 * 
 * <p>히스토리 조회 결과의 페이로드 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "페이로드 정보")
public class Payload {

    /**
     * 페이징 정보
     */
    @JsonProperty("pagination")
    @Valid
    @Schema(description = "페이징 정보", required = true)
    private Pagination pagination;
}
