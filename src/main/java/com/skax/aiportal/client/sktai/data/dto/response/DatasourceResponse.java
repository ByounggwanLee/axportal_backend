package com.skax.aiportal.client.sktai.data.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.data.dto.S3Config;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터소스 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
public class DatasourceResponse {

    /**
     * 데이터소스 ID
     */
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 데이터소스 이름
     */
    private String name;

    /**
     * 데이터소스 타입
     */
    private String type;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 데이터소스 설명
     */
    private String description;

    /**
     * S3 설정
     */
    @JsonProperty("s3_config")
    private S3Config s3Config;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 데이터소스 범위
     */
    private String scope;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 상태
     */
    private String status;

    /**
     * 버킷 이름
     */
    @JsonProperty("bucket_name")
    private String bucketName;

    /**
     * 생성자 정보
     */
    private String creator;

    /**
     * 데이터소스 파일 목록
     */
    private List<DataSourceFile> files;
}
