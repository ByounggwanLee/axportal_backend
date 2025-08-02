package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 링크 DTO
 * 
 * <p>페이지네이션의 개별 링크 정보를 담습니다.</p>
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

    /**
     * URL
     */
    @JsonProperty("url")
    private String url;

    /**
     * 라벨
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
