package com.skax.aiportal.dto.data.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 미리보기 응답 DTO
 * 
 * <p>데이터셋의 일부 데이터를 미리보기로 조회할 때 반환되는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetPreviewResponse {

    /**
     * 데이터셋 ID
     */
    private String datasetId;

    /**
     * 전체 행 수
     */
    private Long totalRows;

    /**
     * 미리보기 행 수
     */
    private Integer previewRows;

    /**
     * 청크 크기
     */
    private Integer chunkSize;

    /**
     * 컬럼 정보
     */
    private List<ColumnInfo> columns;

    /**
     * 미리보기 데이터
     */
    private List<Map<String, Object>> data;

    /**
     * 데이터 통계 정보
     */
    private DataStatistics statistics;

    /**
     * 컬럼 정보 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ColumnInfo {
        
        /**
         * 컬럼 이름
         */
        private String name;
        
        /**
         * 컬럼 타입
         */
        private String type;
        
        /**
         * null 값 개수
         */
        private Long nullCount;
        
        /**
         * 고유 값 개수
         */
        private Long uniqueCount;
        
        /**
         * 샘플 값들
         */
        private List<Object> sampleValues;
    }

    /**
     * 데이터 통계 정보 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DataStatistics {
        
        /**
         * 전체 행 수
         */
        private Long totalRows;
        
        /**
         * 전체 컬럼 수
         */
        private Integer totalColumns;
        
        /**
         * null 값이 있는 컬럼 수
         */
        private Integer columnsWithNulls;
        
        /**
         * 중복 행 수
         */
        private Long duplicateRows;
        
        /**
         * 메모리 사용량 (바이트)
         */
        private Long memoryUsage;
    }
}
