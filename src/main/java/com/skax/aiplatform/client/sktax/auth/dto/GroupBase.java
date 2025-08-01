package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: GroupBase
 * 그룹 기본 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupBase {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("path")
    private String path;
}
