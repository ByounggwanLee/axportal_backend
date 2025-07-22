package com.skax.aiportal.client.sktai.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 링크 클래스
 * 
 * 페이지네이션의 개별 링크 정보를 담습니다.
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
     * 활성화 여부
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * 페이지 번호
     */
    @JsonProperty("page")
    private Integer page;
}
