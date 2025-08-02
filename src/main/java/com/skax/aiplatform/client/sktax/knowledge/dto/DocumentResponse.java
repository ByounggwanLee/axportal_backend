package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 문서 응답 DTO
 * OpenAPI 스키마: DocumentResponse
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("collection_id")
    private String collectionId;

    @JsonProperty("datasource_file_id")
    private String datasourceFileId;

    @JsonProperty("datasource_file_path")
    private String datasourceFilePath;

    @JsonProperty("loader")
    private String loader;

    @JsonProperty("processor")
    private String processor;

    @JsonProperty("splitter")
    private String splitter;

    @JsonProperty("chunk_size")
    private Integer chunkSize;

    @JsonProperty("chunk_overlap")
    private Integer chunkOverlap;

    @JsonProperty("separator")
    private String separator;

    @JsonProperty("status")
    @Builder.Default
    private DocumentStatus status = DocumentStatus.INIT;

    @JsonProperty("processor_ids")
    private List<String> processorIds;

    @JsonProperty("latest_task")
    private RepoTask latestTask;
}
