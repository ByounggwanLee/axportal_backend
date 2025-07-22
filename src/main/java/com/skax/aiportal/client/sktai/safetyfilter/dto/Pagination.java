package com.skax.aiportal.client.sktai.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 페이지네이션 정보 클래스
 * 
 * 안전 필터 목록 조회 시 페이지네이션 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    /**
     * 현재 페이지 번호
     */
    @JsonProperty("page")
    private Integer page;

    /**
     * 첫 페이지 URL
     */
    @JsonProperty("first_page_url")
    private String firstPageUrl;

    /**
     * 시작 번호
     */
    @JsonProperty("from_")
    private Integer from;

    /**
     * 마지막 페이지 번호
     */
    @JsonProperty("last_page")
    private Integer lastPage;

    /**
     * 페이지네이션 링크 목록
     */
    @JsonProperty("links")
    private List<PaginationLinks> links;

    /**
     * 다음 페이지 URL
     */
    @JsonProperty("next_page_url")
    private String nextPageUrl;

    /**
     * 페이지당 아이템 수
     */
    @JsonProperty("items_per_page")
    private Integer itemsPerPage;

    /**
     * 이전 페이지 URL
     */
    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    /**
     * 끝 번호
     */
    @JsonProperty("to")
    private Integer to;

    /**
     * 전체 아이템 수
     */
    @JsonProperty("total")
    private Integer total;
}
