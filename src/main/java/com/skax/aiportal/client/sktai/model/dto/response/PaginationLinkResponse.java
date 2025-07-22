package com.skax.aiportal.client.sktai.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 링크 응답 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationLinkResponse {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("label")
    private String label;
    
    @JsonProperty("active")
    private Boolean active;
    
    @JsonProperty("page")
    private Integer page;
}
