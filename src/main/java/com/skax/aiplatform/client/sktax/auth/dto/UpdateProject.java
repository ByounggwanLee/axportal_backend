package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: UpdateProject
 * 프로젝트 업데이트 요청
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProject {

    @JsonProperty("name")
    private String name;
}
