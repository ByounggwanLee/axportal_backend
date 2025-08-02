package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * OpenAPI 명세: ProjectSidebarMenus
 * 프로젝트별 사이드바 메뉴 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSidebarMenus {

    @JsonProperty("additionalProperties")
    private Map<String, Object> additionalProperties;
}
