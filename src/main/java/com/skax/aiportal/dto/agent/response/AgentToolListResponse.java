package com.skax.aiportal.dto.agent.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Tool 목록 응답 DTO
 * 
 * <p>Agent Tool 목록 조회 시 페이지네이션 정보와 함께 반환되는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentToolListResponse {

    /**
     * Tool 목록
     */
    private List<AgentToolResponse> data;

    /**
     * 페이지네이션 정보
     */
    private Pagination pagination;

    /**
     * 전체 개수
     */
    private Long totalCount;

    /**
     * 검색/필터 조건
     */
    private String searchCriteria;

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
    }
}
