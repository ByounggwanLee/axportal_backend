package com.skax.aiportal.dto.agent.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 목록 응답 DTO
 * 
 * <p>Agent 애플리케이션 목록과 페이지네이션 정보를 담는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentAppListResponse {

    /**
     * Agent App 목록
     */
    private List<AgentAppResponse> data;

    /**
     * 전체 개수
     */
    private Long totalCount;

    /**
     * 검색 조건
     */
    private String searchCriteria;

    /**
     * 페이지네이션 정보
     */
    private Pagination pagination;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {
        
        /**
         * 현재 페이지
         */
        private Integer currentPage;

        /**
         * 페이지 크기
         */
        private Integer pageSize;

        /**
         * 전체 요소 수
         */
        private Long totalElements;

        /**
         * 전체 페이지 수
         */
        private Integer totalPages;

        /**
         * 첫 페이지 여부
         */
        private Boolean first;

        /**
         * 마지막 페이지 여부
         */
        private Boolean last;
    }
}
