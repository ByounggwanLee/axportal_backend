package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 링크 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationLinks {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("label")
    private String label;
    
    @JsonProperty("active")
    private Boolean active;
    
    @JsonProperty("page")
    private Integer page;
}
