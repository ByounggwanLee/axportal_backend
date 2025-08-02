package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Repository 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoResponse {

    /**
     * Repository ID
     */
    @JsonProperty("repo_id")
    private String repoId;
}
