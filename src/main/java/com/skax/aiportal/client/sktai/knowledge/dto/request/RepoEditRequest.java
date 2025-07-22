package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Repository 편집 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoEditRequest {

    /**
     * Repository 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * Repository 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 로더 타입 (Default, DataIngestionTool, CustomLoader)
     */
    @JsonProperty("loader")
    private String loader;

    /**
     * 스플리터 타입 (RecursiveCharacter, Character, Semantic, CustomSplitter, NotSplit)
     */
    @JsonProperty("splitter")
    private String splitter;

    /**
     * 청크 크기
     */
    @JsonProperty("chunk_size")
    private Integer chunkSize;

    /**
     * 청크 중복 크기
     */
    @JsonProperty("chunk_overlap")
    private Integer chunkOverlap;

    /**
     * 구분자
     */
    @JsonProperty("separator")
    private String separator;

    /**
     * 커스텀 로더 ID
     */
    @JsonProperty("custom_loader_id")
    private String customLoaderId;

    /**
     * 커스텀 스플리터 ID
     */
    @JsonProperty("custom_splitter_id")
    private String customSplitterId;

    /**
     * 도구 ID
     */
    @JsonProperty("tool_id")
    private String toolId;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 프로세서 ID 목록
     */
    @JsonProperty("processor_ids")
    private List<String> processorIds;

    /**
     * 인덱싱 설정
     */
    @JsonProperty("indexing_config")
    private Object indexingConfig;
}
