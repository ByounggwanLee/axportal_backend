package com.skax.aiportal.client.sktai.data.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 파일 클래스
 */
@Getter
@NoArgsConstructor
public class DataSourceFile {
    private String id;

    @JsonProperty("datasource_id")
    private String datasourceId;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("file_path")
    private String filePath;

    @JsonProperty("file_size")
    private Long fileSize;

    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("s3_etag")
    private String s3Etag;

    @JsonProperty("file_metadata")
    private Object fileMetadata;

    @JsonProperty("knowledge_config")
    private Object knowledgeConfig;
}