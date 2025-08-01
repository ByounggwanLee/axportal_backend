package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이징 링크 DTO
 * 
 * <p>OpenAPI 스키마명: PaginationLinks</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "페이징 링크")
public class PaginationLinks {

    @JsonProperty("url")
    @Schema(description = "URL")
    private String url;

    @JsonProperty("label")
    @Schema(description = "라벨", required = true)
    private String label;

    @JsonProperty("active")
    @Schema(description = "활성 여부", required = true)
    private Boolean active;

    @JsonProperty("page")
    @Schema(description = "페이지 번호")
    private Integer page;
}
