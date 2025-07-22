package com.skax.aiportal.client.sktai.knowledge.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge 검색 결과 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrievalResponse {

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
     * 검색 결과 리스트
     */
    @JsonProperty("data")
    private List<RetrievalResult> data;

    /**
     * 검색 결과 아이템 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalResult {

        /**
         * 검색된 본문 내용
         */
        @JsonProperty("content")
        private String content;

        /**
         * 문서 메타데이터
         */
        @JsonProperty("metadata")
        private Map<String, Object> metadata;

        /**
         * 검색 점수
         */
        @JsonProperty("score")
        private Double score;
    }
}
