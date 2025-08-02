package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 페이지네이션 링크 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
     * 활성 여부
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * 페이지 번호
     */
    @JsonProperty("page")
    private Integer page;
}
