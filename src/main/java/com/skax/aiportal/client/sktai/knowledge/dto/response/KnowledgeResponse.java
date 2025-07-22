package com.skax.aiportal.client.sktai.knowledge.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI Knowledge API 공통 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeResponse<T> {

    /**
     * 응답 타임스탬프
     */
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 응답 상세
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * 추적 ID
     */
    @JsonProperty("traceId")
    private String traceId;

    /**
     * 응답 데이터
     */
    @JsonProperty("data")
    private T data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;

    /**
     * 페이지네이션 페이로드 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload {

        /**
         * 페이지네이션 정보
         */
        @JsonProperty("pagination")
        private Pagination pagination;
    }

    /**
     * 페이지네이션 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {

        /**
         * 현재 페이지
         */
        @JsonProperty("page")
        private Integer page;

        /**
         * 첫 페이지 URL
         */
        @JsonProperty("first_page_url")
        private String firstPageUrl;

        /**
         * 시작 인덱스
         */
        @JsonProperty("from_")
        private Integer from;

        /**
         * 마지막 페이지
         */
        @JsonProperty("last_page")
        private Integer lastPage;

        /**
         * 다음 페이지 URL
         */
        @JsonProperty("next_page_url")
        private String nextPageUrl;

        /**
         * 페이지당 항목 수
         */
        @JsonProperty("items_per_page")
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
        private Integer to;

        /**
         * 전체 항목 수
         */
        @JsonProperty("total")
        private Integer total;
    }
}
