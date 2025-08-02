package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * External Knowledge Repo 테스트 응답 DTO
 * OpenAPI 스키마: RepoExtTestResponse
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoExtTestResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("detail")
    private Object detail; // 배열 또는 문자열이 될 수 있음
}
