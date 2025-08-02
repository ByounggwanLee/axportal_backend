package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Knowledge Repo 생성 응답 DTO
 * 
 * <p>신규 생성된 Knowledge Repo의 ID를 반환합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepoCreateResponse {

    /**
     * 신규 Knowledge ID (repo_id)
     */
    @JsonProperty("repo_id")
    private String repoId;
}
