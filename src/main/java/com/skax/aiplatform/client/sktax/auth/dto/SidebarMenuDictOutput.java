package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * OpenAPI 명세: SidebarMenuDict-Output
 * 사이드바 메뉴 출력 데이터
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SidebarMenuDictOutput {

    @JsonProperty("additionalProperties")
    private Map<String, Map<String, List<SidebarMenuItemOutput>>> additionalProperties;
}
