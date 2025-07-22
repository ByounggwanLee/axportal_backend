package com.skax.aiportal.dto.data.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 목록 응답 DTO
 * 
 * <p>데이터셋 목록 조회 시 페이지네이션 정보와 함께 반환되는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetListResponse {

    /**
     * 데이터셋 목록
     */
    private List<DatasetResponse> data;

    /**
     * 페이지네이션 정보
     */
    private Pagination pagination;

    /**
     * 페이지네이션 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {
        
        /**
         * 현재 페이지
         */
        private int currentPage;
        
        /**
         * 페이지 크기
         */
        private int pageSize;
        
        /**
         * 전체 항목 수
         */
        private long totalElements;
        
        /**
         * 전체 페이지 수
         */
        private int totalPages;
        
        /**
         * 첫 번째 페이지 여부
         */
        private boolean first;
        
        /**
         * 마지막 페이지 여부
         */
        private boolean last;
        
        /**
         * 페이지네이션 링크
         */
        private PaginationLinks links;
    }

    /**
     * 페이지네이션 링크 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaginationLinks {
        
        /**
         * 첫 번째 페이지 링크
         */
        private String first;
        
        /**
         * 이전 페이지 링크
         */
        private String prev;
        
        /**
         * 현재 페이지 링크
         */
        private String self;
        
        /**
         * 다음 페이지 링크
         */
        private String next;
        
        /**
         * 마지막 페이지 링크
         */
        private String last;
    }
}
