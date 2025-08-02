package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 테스트 용 사용자 질의 관련 유사도 높은 문서 검색 요청 DTO
 * 
 * <p>테스트 환경에서 문서 검색을 위한 요청 정보를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestRetrievalRequest {

    /**
     * 사용자 질의
     */
    @JsonProperty("query_text")
    @NotBlank(message = "사용자 질의는 필수입니다")
    @Size(min = 1, message = "사용자 질의 내용은 최소 1글자 이상 입력해주세요")
    private String queryText;

    /**
     * 지식저장소 ID
     */
    @JsonProperty("repo_id")
    @NotNull(message = "지식저장소 ID는 필수입니다")
    private String repoId;

    /**
     * Repo collection ID
     */
    @JsonProperty("collection_id")
    private String collectionId;
}
