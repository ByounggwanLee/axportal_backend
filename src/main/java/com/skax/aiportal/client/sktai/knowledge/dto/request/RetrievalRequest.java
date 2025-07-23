package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Knowledge 검색 요청 DTO
 * 
 * <p>SKT AI Knowledge 플랫폼에서 지식 검색을 위한 요청 정보를 담는 객체입니다.
 * 벡터 유사도 검색을 통해 관련 문서를 찾습니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "Knowledge 검색 요청",
    description = "SKT AI Knowledge 플랫폼에서 지식 검색을 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RetrievalRequest {

    /**
     * 사용자 질의
     * 
     * <p>검색하고자 하는 질문이나 키워드입니다.</p>
     */
    @Schema(
        description = "검색 질의 텍스트",
        example = "AI 모델의 성능을 향상시키는 방법",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 1000
    )
    @NotBlank(message = "검색 질의는 필수입니다.")
    @Size(max = 1000, message = "검색 질의는 1000자를 초과할 수 없습니다.")
    @JsonProperty("query_text")
    private String queryText;

    /**
     * 지식저장소 ID
     * 
     * <p>검색 대상이 되는 지식저장소의 식별자입니다.</p>
     */
    @Schema(
        description = "지식저장소 ID",
        example = "repo-12345",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 50
    )
    @NotBlank(message = "지식저장소 ID는 필수입니다.")
    @Size(max = 50, message = "지식저장소 ID는 50자를 초과할 수 없습니다.")
    @JsonProperty("repo_id")
    private String repoId;

    /**
     * 검색 옵션
     * 
     * <p>검색 방법, 결과 개수 등 세부 검색 설정입니다.</p>
     */
    @Schema(
        description = "검색 옵션 설정"
    )
    @Valid
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
