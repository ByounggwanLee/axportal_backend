package com.skax.aiplatform.client.sktax.history.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이징 링크 정보
 * 
 * <p>페이징의 개별 링크 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "페이징 링크 정보")
public class PaginationLinks {

    /**
     * 링크 URL
     */
    @JsonProperty("url")
    @Schema(description = "링크 URL")
    private String url;

    /**
     * 링크 라벨
     */
    @JsonProperty("label")
    @Schema(description = "링크 라벨", required = true)
    private String label;

    /**
     * 활성 상태
     */
    @JsonProperty("active")
    @Schema(description = "활성 상태", required = true)
    private Boolean active;

    /**
     * 페이지 번호
     */
    @JsonProperty("page")
    @Schema(description = "페이지 번호")
    private Integer page;
}
