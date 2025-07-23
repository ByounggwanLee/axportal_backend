package com.skax.aiportal.client.sktai.knowledge.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SKT AI Knowledge API 공통 응답 DTO
 * 
 * <p>SKT AI Knowledge 서비스의 모든 API 응답에 사용되는 공통 응답 포맷입니다.
 * 응답 코드, 메시지, 데이터, 추적 정보 등을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "Knowledge API 공통 응답",
    description = "SKT AI Knowledge 서비스의 표준 응답 형식"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KnowledgeResponse<T> {

    /**
     * 응답 타임스탬프
     * 
     * <p>API 응답이 생성된 시각입니다.</p>
     */
    @Schema(
        description = "API 응답 생성 시각",
        example = "2025-07-23T10:30:45",
        format = "date-time"
    )
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     * 
     * <p>API 호출 결과를 나타내는 응답 코드입니다.</p>
     */
    @Schema(
        description = "API 응답 코드",
        example = "200"
    )
    @JsonProperty("code")
    private Integer code;

    /**
     * 응답 상세 메시지
     * 
     * <p>API 호출 결과에 대한 상세한 설명입니다.</p>
     */
    @Schema(
        description = "응답 상세 메시지",
        example = "요청이 성공적으로 처리되었습니다.",
        maxLength = 500
    )
    @JsonProperty("detail")
    private String detail;

    /**
     * 추적 ID
     * 
     * <p>요청 추적을 위한 고유 식별자입니다.</p>
     */
    @Schema(
        description = "요청 추적 ID",
        example = "trace-12345-67890-abcdef",
        maxLength = 100
    )
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
