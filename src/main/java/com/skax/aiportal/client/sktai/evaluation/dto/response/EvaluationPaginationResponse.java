package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Evaluation 페이지네이션 응답 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationPaginationResponse {
    
    @JsonProperty("page")
    private Integer page;
    
    @JsonProperty("first_page_url")
    private String firstPageUrl;
    
    @JsonProperty("from_")
    private Integer from;
    
    @JsonProperty("last_page")
    private Integer lastPage;
    
    @JsonProperty("links")
    private List<EvaluationPaginationLinkResponse> links;
    
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
