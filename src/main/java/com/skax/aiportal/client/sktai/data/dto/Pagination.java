package com.skax.aiportal.client.sktai.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 클래스
 */ 
@Getter
@NoArgsConstructor
public class Pagination {
    private int page;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    @JsonProperty("from_")
    private int from;

    @JsonProperty("last_page")
    private int lastPage;

    private List<PaginationLink> links;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("items_per_page")
    private int itemsPerPage;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private int to;
    private int total;
}