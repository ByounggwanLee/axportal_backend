package com.skax.aiportal.client.sktai.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "페이징 상세 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PaginationInfo {

    @Schema(description = "현재 페이지")
    @JsonProperty("page")
    private Integer page;

    @Schema(description = "첫 페이지 URL")
    @JsonProperty("first_page_url")
    private String firstPageUrl;

    @Schema(description = "시작 번호")
    @JsonProperty("from_")
    private Integer from;

    @Schema(description = "마지막 페이지")
    @JsonProperty("last_page")
    private Integer lastPage;

    @Schema(description = "다음 페이지 URL")
    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @Schema(description = "페이지당 항목 수")
    @JsonProperty("items_per_page")
    private Integer itemsPerPage;

    @Schema(description = "이전 페이지 URL")
    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    @Schema(description = "끝 번호")
    @JsonProperty("to")
    private Integer to;

    @Schema(description = "전체 항목 수")
    @JsonProperty("total")
    private Integer total;
}