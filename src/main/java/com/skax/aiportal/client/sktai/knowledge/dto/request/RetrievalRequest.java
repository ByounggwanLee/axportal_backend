package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge 검색 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrievalRequest {

    /**
     * 사용자 질의
     */
    @JsonProperty("query_text")
    private String queryText;

    /**
     * 지식저장소 ID
     */
    @JsonProperty("repo_id")
    private String repoId;

    /**
     * 검색 옵션
     */
    @JsonProperty("retrieval_options")
    private RetrievalOptions retrievalOptions;

    /**
     * 검색 옵션 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalOptions {

        /**
         * 검색 모드 (dense, sparse, hybrid, semantic)
         */
        @JsonProperty("retrieval_mode")
        private String retrievalMode;

        /**
         * 검색 상위 K개
         */
        @JsonProperty("top_k")
        private Integer topK;

        /**
         * Vector 검색 threshold
         */
        @JsonProperty("threshold")
        private Double threshold;

        /**
         * 필터 조건
         */
        @JsonProperty("filter")
        private String filter;

        /**
         * 정렬 조건
         */
        @JsonProperty("order_by")
        private String orderBy;

        /**
         * 핵심 키워드 기반 질의
         */
        @JsonProperty("query_keywords")
        private String queryKeywords;

        /**
         * Semantic Configuration Name (Azure AI Search Only)
         */
        @JsonProperty("semantic_configuration_name")
        private String semanticConfigurationName;

        /**
         * Scoring Profile (Azure AI Search Only)
         */
        @JsonProperty("scoring_profile")
        private String scoringProfile;

        /**
         * Scoring Parameters (Azure AI Search Only)
         */
        @JsonProperty("scoring_parameters")
        private Map<String, String> scoringParameters;
    }
}
