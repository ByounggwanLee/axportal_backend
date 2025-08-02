package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 데이터셋 DTO
 * 
 * <p>데이터셋의 상세 정보를 담는 데이터 모델입니다.
 * OpenAPI 명세의 Dataset 스키마와 일치합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dataset {

    /**
     * 데이터셋 이름 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터셋 타입
     * 기본값: unsupervised_finetuning
     */
    @JsonProperty("type")
    @Builder.Default
    private DatasetTypeEnum type = DatasetTypeEnum.UNSUPERVISED_FINETUNING;

    /**
     * 설명
     * 기본값: 빈 문자열
     */
    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    /**
     * 태그 목록
     */
    @JsonProperty("tags")
    private List<DatasetTags> tags;

    /**
     * 상태 (필수)
     */
    @JsonProperty("status")
    private String status;

    /**
     * 프로젝트 ID
     * 기본값: 빈 문자열
     */
    @JsonProperty("project_id")
    @Builder.Default
    private String projectId = "";

    /**
     * 삭제 여부
     * 기본값: false
     */
    @JsonProperty("is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    /**
     * ID (필수)
     */
    @JsonProperty("id")
    private String id;

    /**
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성자 (필수)
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자 (필수)
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 데이터소스 ID (필수)
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 데이터소스 파일 목록 (필수)
     */
    @JsonProperty("datasource_files")
    private List<String> datasourceFiles;

    /**
     * 프로세서 정보 (필수)
     */
    @JsonProperty("processor")
    private Object processor;

    /**
     * 파일 경로 (필수)
     */
    @JsonProperty("file_path")
    private String filePath;
}
