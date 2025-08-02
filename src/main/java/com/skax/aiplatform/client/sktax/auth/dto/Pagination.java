package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 페이징 DTO
 * 
 * <p>OpenAPI 스키마명: Pagination</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "페이징")
public class Pagination<T> {

    @JsonProperty("page")
    @Schema(description = "현재 페이지", required = true)
    private Integer page;

    @JsonProperty("first_page_url")
    @Schema(description = "첫 페이지 URL", required = true)
    private String firstPageUrl;

    @JsonProperty("from_")
    @Schema(description = "시작 번호", required = true)
    private Integer from;

    @JsonProperty("last_page")
    @Schema(description = "마지막 페이지", required = true)
    private Integer lastPage;

    @JsonProperty("links")
    @Schema(description = "페이징 링크 목록", required = true)
    private List<PaginationLinks> links;

    @JsonProperty("next_page_url")
    @Schema(description = "다음 페이지 URL")
    private String nextPageUrl;

    @JsonProperty("items_per_page")
    @Schema(description = "페이지당 항목 수", required = true)
    private Integer itemsPerPage;

    @JsonProperty("prev_page_url")
    @Schema(description = "이전 페이지 URL")
    private String prevPageUrl;

    @JsonProperty("to")
    @Schema(description = "끝 번호", required = true)
    private Integer to;

    @JsonProperty("total")
    @Schema(description = "전체 항목 수", required = true)
    private Integer total;

    @JsonProperty("data")
    @Schema(description = "데이터 목록")
    private java.util.List<T> data;
}
