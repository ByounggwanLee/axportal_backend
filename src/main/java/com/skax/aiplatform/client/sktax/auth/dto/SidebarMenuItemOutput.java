package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OpenAPI 명세: SidebarMenuItem-Output
 * 사이드바 메뉴 항목 출력 데이터
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SidebarMenuItemOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("children")
    private List<SidebarMenuItemOutput> children;

    @JsonProperty("scope")
    private List<String> scope;
}
