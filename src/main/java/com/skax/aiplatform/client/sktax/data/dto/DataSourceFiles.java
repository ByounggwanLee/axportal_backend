package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DataSource 파일 DTO
 * 
 * <p>데이터소스의 파일 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceFiles {

    /**
     * 파일 ID (필수)
     */
    @JsonProperty("id")
    private String id;

    /**
     * 데이터소스 ID (필수)
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 파일명 (필수)
     */
    @JsonProperty("file_name")
    private String fileName;

    /**
     * 파일 경로 (필수)
     */
    @JsonProperty("file_path")
    private String filePath;

    /**
     * 파일 크기
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * 삭제 여부 (필수)
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * S3 ETag
     */
    @JsonProperty("s3_etag")
    private String s3Etag;

    /**
     * 파일 메타데이터
     */
    @JsonProperty("file_metadata")
    private Object fileMetadata;

    /**
     * 지식 설정
     */
    @JsonProperty("knowledge_config")
    private Object knowledgeConfig;
}
