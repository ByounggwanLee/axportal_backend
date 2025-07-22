package com.skax.aiportal.dto.data.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 응답 DTO
 * 
 * <p>데이터셋 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetResponse {

    /**
     * 데이터셋 ID
     */
    private String id;

    /**
     * 데이터셋 이름
     */
    private String name;

    /**
     * 데이터셋 타입
     */
    private String type;

    /**
     * 데이터셋 설명
     */
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    private List<DatasetTag> tags;

    /**
     * 데이터셋 상태
     */
    private String status;

    /**
     * 프로젝트 ID
     */
    private String projectId;

    /**
     * 프로젝트 이름
     */
    private String projectName;

    /**
     * 파일 크기 (바이트)
     */
    private Long fileSize;

    /**
     * 행 개수
     */
    private Long rowCount;

    /**
     * 열 개수
     */
    private Integer columnCount;

    /**
     * 파일 경로
     */
    private String filePath;

    /**
     * S3 경로
     */
    private String s3Path;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    private String createdBy;

    /**
     * 수정자
     */
    private String updatedBy;

    /**
     * 추가 페이로드
     */
    private Object payload;

    /**
     * 프로세서 매개변수 목록
     */
    private List<ProcessorParam> processorParams;

    /**
     * 데이터셋 태그 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetTag {
        
        /**
         * 태그 이름
         */
        private String name;
        
        /**
         * 태그 값
         */
        private String value;
        
        /**
         * 태그 색상
         */
        private String color;
        
        /**
         * 태그 설명
         */
        private String description;
    }

    /**
     * 프로세서 매개변수 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProcessorParam {
        
        /**
         * 매개변수 이름
         */
        private String name;
        
        /**
         * 매개변수 값
         */
        private Object value;
        
        /**
         * 매개변수 타입
         */
        private String type;
    }
}
