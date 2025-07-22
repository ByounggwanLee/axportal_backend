package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Repository 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoCreateRequest {

    /**
     * Knowledge 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * Knowledge 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 임베딩 모델 ID
     */
    @JsonProperty("embedding_model_id")
    private String embeddingModelId;

    /**
     * 임베딩 모델 이름
     */
    @JsonProperty("embedding_model_name")
    private String embeddingModelName;

    /**
     * Vector DB ID
     */
    @JsonProperty("vector_db_id")
    private String vectorDbId;

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
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 도구 ID
     */
    @JsonProperty("tool_id")
    private String toolId;

    /**
     * 저장소 범위 (public, private)
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 인덱싱 설정
     */
    @JsonProperty("indexing_config")
    private Map<String, Object> indexingConfig;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private Object policy;
}
