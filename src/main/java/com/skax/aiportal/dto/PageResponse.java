package com.skax.aiportal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 페이징 응답 클래스
 * 
 * <p>페이징된 데이터에 대한 응답 형식을 정의합니다.</p>
 * 
 * @param <T> 응답 데이터 타입
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponse<T> {
    
    /**
     * 페이지 콘텐츠
     */
    private final List<T> content;
    
    /**
     * 페이지 정보
     */
    private final PageInfo pageable;
    
    /**
     * 전체 요소 수
     */
    private final long totalElements;
    
    /**
     * 전체 페이지 수
     */
    private final int totalPages;
    
    /**
     * 첫 번째 페이지 여부
     */
    private final boolean first;
    
    /**
     * 마지막 페이지 여부
     */
    private final boolean last;
    
    /**
     * 빈 페이지 여부
     */
    private final boolean empty;

    /**
     * Spring Data Page 객체로부터 PageResponse를 생성합니다.
     * 
     * @param page Spring Data Page 객체
     * @param <T> 데이터 타입
     * @return PageResponse
     */
    public static <T> PageResponse<T> of(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .pageable(PageInfo.of(page))
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .empty(page.isEmpty())
                .build();
    }

    /**
     * 페이지 정보 클래스
     */
    @Getter
    @Builder
    public static class PageInfo {
        
        /**
         * 현재 페이지 번호 (0부터 시작)
         */
        private final int page;
        
        /**
         * 페이지 크기
         */
        private final int size;
        
        /**
         * 정렬 정보
         */
        private final String sort;

        /**
         * Spring Data Page 객체로부터 PageInfo를 생성합니다.
         * 
         * @param page Spring Data Page 객체
         * @return PageInfo
         */
        public static PageInfo of(Page<?> page) {
            return PageInfo.builder()
                    .page(page.getNumber())
                    .size(page.getSize())
                    .sort(page.getSort().toString())
                    .build();
        }
    }
}
