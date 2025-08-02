package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API 페이지네이션 링크
 * 
 * <p>페이지네이션에서 사용되는 링크 정보입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationLinks {
    
    /**
     * 링크 URL
     */
    @JsonProperty("url")
    private String url;
    
    /**
     * 링크 라벨
     */
    @JsonProperty("label")
    private String label;
    
    /**
     * 활성 상태
     */
    @JsonProperty("active")
    private Boolean active;
    
    /**
     * 페이지 번호
     */
    @JsonProperty("page")
    private Integer page;
}
