package com.skax.aiplatform.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 페이징 응답 래퍼 클래스
 * 
 * <p>페이징 처리된 데이터를 표준화된 형식으로 응답하기 위한 클래스입니다.
 * Spring Data의 Page 인터페이스와 호환됩니다.</p>
 * 
 * @param <T> 페이징 데이터 타입
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "페이징 응답 데이터")
public class PageResponse<T> {

    @Schema(description = "페이징 데이터 목록")
    private final List<T> content;

    @Schema(description = "페이징 정보")
    private final PageableInfo pageable;

    @Schema(description = "전체 데이터 수", example = "100")
    private final long totalElements;

    @Schema(description = "전체 페이지 수", example = "10")
    private final int totalPages;

    @Schema(description = "첫 페이지 여부", example = "true")
    private final boolean first;

    @Schema(description = "마지막 페이지 여부", example = "false")
    private final boolean last;

    @Schema(description = "현재 페이지 데이터 수", example = "20")
    private final int numberOfElements;

    @Schema(description = "빈 페이지 여부", example = "false")
    private final boolean empty;

    /**
     * Spring Data Page 객체로부터 PageResponse 생성
     * 
     * @param page Spring Data Page 객체
     * @param <T> 데이터 타입
     * @return PageResponse 객체
     */
    public static <T> PageResponse<T> of(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .pageable(PageableInfo.of(page.getPageable(), page.getSort()))
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .numberOfElements(page.getNumberOfElements())
                .empty(page.isEmpty())
                .build();
    }

    /**
     * 페이징 정보 내부 클래스
     */
    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "페이징 정보")
    public static class PageableInfo {

        @Schema(description = "현재 페이지 번호 (0부터 시작)", example = "0")
        private final int page;

        @Schema(description = "페이지 크기", example = "20")
        private final int size;

        @Schema(description = "정렬 정보", example = "createdAt,desc")
        private final String sort;

        /**
         * Spring Data Pageable과 Sort로부터 PageableInfo 생성
         * 
         * @param pageable Spring Data Pageable 객체
         * @param sort Spring Data Sort 객체
         * @return PageableInfo 객체
         */
        public static PageableInfo of(org.springframework.data.domain.Pageable pageable, 
                                    org.springframework.data.domain.Sort sort) {
            return PageableInfo.builder()
                    .page(pageable.getPageNumber())
                    .size(pageable.getPageSize())
                    .sort(sort.toString())
                    .build();
        }
    }
}
