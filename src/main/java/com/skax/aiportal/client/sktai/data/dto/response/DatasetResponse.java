package com.skax.aiportal.client.sktai.data.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.data.dto.DatasetTag;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터셋 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
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
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

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
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 데이터소스 파일 목록
     */
    @JsonProperty("datasource_files")
    private List<String> datasourceFiles;

    /**
     * 프로세서 정보
     */
    private Object processor;

    /**
     * 파일 경로
     */
    @JsonProperty("file_path")
    private String filePath;
}
