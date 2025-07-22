package com.skax.aiportal.client.sktai.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * External Knowledge Repository 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalRepoCreateRequest {

    /**
     * External Knowledge 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * External Knowledge 설명
     */
    @JsonProperty("description")
    private String description;

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
     * 인덱스 이름
     */
    @JsonProperty("index_name")
    private String indexName;

    /**
     * 스크립트
     */
    @JsonProperty("script")
    private String script;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private Object policy;
}
