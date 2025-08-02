package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pagination Links DTO
 * 페이지네이션 링크 정보를 나타내는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
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
