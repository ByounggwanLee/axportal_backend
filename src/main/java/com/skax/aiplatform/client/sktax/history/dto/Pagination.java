package com.skax.aiplatform.client.sktax.history.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이징 정보
 * 
 * <p>히스토리 조회 결과의 페이징 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "페이징 정보")
public class Pagination {

    /**
     * 현재 페이지
     */
    @JsonProperty("page")
    @Schema(description = "현재 페이지", required = true)
    private Integer page;

    /**
     * 첫 번째 페이지 URL
     */
    @JsonProperty("first_page_url")
    @Schema(description = "첫 번째 페이지 URL", required = true)
    private String firstPageUrl;

    /**
     * 시작 아이템 번호
     */
    @JsonProperty("from_")
    @Schema(description = "시작 아이템 번호", required = true)
    private Integer from;

    /**
     * 마지막 페이지
     */
    @JsonProperty("last_page")
    @Schema(description = "마지막 페이지", required = true)
    private Integer lastPage;

    /**
     * 페이징 링크 목록
     */
    @JsonProperty("links")
    @Valid
    @Schema(description = "페이징 링크 목록", required = true)
    private List<PaginationLinks> links;

    /**
     * 다음 페이지 URL
     */
    @JsonProperty("next_page_url")
    @Schema(description = "다음 페이지 URL")
    private String nextPageUrl;

    /**
     * 페이지당 아이템 수
     */
    @JsonProperty("items_per_page")
    @Schema(description = "페이지당 아이템 수", required = true)
    private Integer itemsPerPage;

    /**
     * 이전 페이지 URL
     */
    @JsonProperty("prev_page_url")
    @Schema(description = "이전 페이지 URL")
    private String prevPageUrl;

    /**
     * 마지막 아이템 번호
     */
    @JsonProperty("to")
    @Schema(description = "마지막 아이템 번호", required = true)
    private Integer to;

    /**
     * 전체 아이템 수
     */
    @JsonProperty("total")
    @Schema(description = "전체 아이템 수", required = true)
    private Integer total;
}
