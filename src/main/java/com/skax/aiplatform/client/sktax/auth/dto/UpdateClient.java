package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: UpdateClient
 * 클라이언트 업데이트 요청
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClient {

    @JsonProperty("project")
    private UpdateProject project;

    @JsonProperty("namespace")
    private UpdateNamespace namespace;
}
