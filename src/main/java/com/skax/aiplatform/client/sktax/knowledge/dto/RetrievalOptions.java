package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.RetrievalMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 검색 옵션 DTO
 * 
 * <p>벡터DB 종류에 따라 지원되는 검색 옵션을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetrievalOptions {

    /**
     * 검색 모드
     */
    @JsonProperty("retrieval_mode")
    @Builder.Default
    private RetrievalMode retrievalMode = RetrievalMode.DENSE;

    /**
     * 검색 상위 K개
     */
    @JsonProperty("top_k")
    @Builder.Default
    private Integer topK = 3;

    /**
     * vector 검색 threshold
     */
    @JsonProperty("threshold")
    private Double threshold;

    /**
     * 필터
     */
    @JsonProperty("filter")
    private String filter;

    /**
     * 정렬
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
