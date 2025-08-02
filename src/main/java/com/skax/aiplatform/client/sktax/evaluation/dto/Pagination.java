package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 페이지네이션 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {
    
    @JsonProperty("page")
    private Integer page;
    
    @JsonProperty("first_page_url")
    private String firstPageUrl;
    
    @JsonProperty("from_")
    private Integer fromIndex;
    
    @JsonProperty("last_page")
    private Integer lastPage;
    
    @JsonProperty("links")
    private List<PaginationLinks> links;
    
    @JsonProperty("next_page_url")
    private String nextPageUrl;
    
    @JsonProperty("items_per_page")
    private Integer itemsPerPage;
    
    @JsonProperty("prev_page_url")
    private String prevPageUrl;
    
    @JsonProperty("to")
    private Integer to;
    
    @JsonProperty("total")
    private Integer total;
}
