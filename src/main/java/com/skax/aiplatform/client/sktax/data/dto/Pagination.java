package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API 페이지네이션 정보
 * 
 * <p>목록 조회 시 페이지네이션 관련 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
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
     * 첫 번째 페이지 URL
     */
    @JsonProperty("first_page_url")
    private String firstPageUrl;
    
    /**
     * 시작 인덱스
     */
    @JsonProperty("from")
    private Integer from;
    
    /**
     * 마지막 페이지 번호
     */
    @JsonProperty("last_page")
    private Integer lastPage;
    
    /**
     * 페이지네이션 링크들
     */
    @JsonProperty("links")
    private PaginationLinks[] links;
    
    /**
     * 다음 페이지 URL
     */
    @JsonProperty("next_page_url")
    private String nextPageUrl;
    
    /**
     * 페이지당 항목 수
     */
    @JsonProperty("items_per_page")
    private Integer itemsPerPage;
    
    /**
     * 이전 페이지 URL
     */
    @JsonProperty("prev_page_url")
    private String prevPageUrl;
    
    /**
     * 종료 인덱스
     */
    @JsonProperty("to")
    private Integer to;
    
    /**
     * 전체 항목 수
     */
    @JsonProperty("total")
    private Integer total;
}
