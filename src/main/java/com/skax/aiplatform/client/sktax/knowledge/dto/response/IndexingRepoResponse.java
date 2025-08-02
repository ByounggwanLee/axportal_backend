package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Repo 인덱싱 응답 DTO
 * OpenAPI 스키마: IndexingRepoResponse
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndexingRepoResponse {

    @JsonProperty("repo_id")
    private String repoId;

    @JsonProperty("repo_task_id")
    private String repoTaskId;
}
