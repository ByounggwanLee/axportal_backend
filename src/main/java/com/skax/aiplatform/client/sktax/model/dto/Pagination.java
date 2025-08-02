package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 페이지네이션 정보 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    /**
     * 현재 페이지
     */
    @JsonProperty("page")
    @NotNull(message = "페이지는 필수입니다")
    private Integer page;

    /**
     * 첫 페이지 URL
     */
    @JsonProperty("first_page_url")
    @NotNull(message = "첫 페이지 URL은 필수입니다")
    private String firstPageUrl;

    /**
     * 시작 인덱스
     */
    @JsonProperty("from_")
    @NotNull(message = "시작 인덱스는 필수입니다")
    private Integer from;

    /**
     * 마지막 페이지
     */
    @JsonProperty("last_page")
    @NotNull(message = "마지막 페이지는 필수입니다")
    private Integer lastPage;

    /**
     * 페이지네이션 링크
     */
    @JsonProperty("links")
    @NotNull(message = "링크는 필수입니다")
    private List<PaginationLinks> links;

    /**
     * 다음 페이지 URL
     */
    @JsonProperty("next_page_url")
    private String nextPageUrl;

    /**
     * 페이지당 아이템 수
     */
    @JsonProperty("items_per_page")
    @NotNull(message = "페이지당 아이템 수는 필수입니다")
    private Integer itemsPerPage;

    /**
     * 이전 페이지 URL
     */
    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    /**
     * 끝 인덱스
     */
    @JsonProperty("to")
    @NotNull(message = "끝 인덱스는 필수입니다")
    private Integer to;

    /**
     * 전체 개수
     */
    @JsonProperty("total")
    @NotNull(message = "전체 개수는 필수입니다")
    private Integer total;
}
