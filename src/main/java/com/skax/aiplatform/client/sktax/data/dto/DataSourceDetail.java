package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DataSource 상세 정보 DTO
 * 
 * <p>데이터소스의 상세 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceDetail {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 데이터소스명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터소스 타입 (기본값: file)
     */
    @JsonProperty("type")
    @Builder.Default
    private DatasourceTypeEnum type = DatasourceTypeEnum.FILE;

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
     * 설명 (기본값: "")
     */
    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    /**
     * S3 설정
     */
    @JsonProperty("s3_config")
    private S3Config s3Config;

    /**
     * 삭제 여부 (기본값: false)
     */
    @JsonProperty("is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * 범위 (기본값: public)
     */
    @JsonProperty("scope")
    @Builder.Default
    private DatasourceScopeEnum scope = DatasourceScopeEnum.PUBLIC;

    /**
     * 데이터소스 ID (필수)
     */
    @JsonProperty("id")
    private String id;

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
     * 상태 (필수)
     */
    @JsonProperty("status")
    private String status;

    /**
     * 버킷명 (필수)
     */
    @JsonProperty("bucket_name")
    private String bucketName;
}
