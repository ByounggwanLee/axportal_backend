package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 사이드바 메뉴 DTO
 * 
 * <p>OpenAPI 스키마명: SidebarMenu</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사이드바 메뉴")
public class SidebarMenu {

    @JsonProperty("menu_id")
    @Schema(description = "메뉴 ID", required = true)
    private Long menuId;

    @JsonProperty("menu_name")
    @Schema(description = "메뉴명", required = true)
    private String menuName;

    @JsonProperty("menu_url")
    @Schema(description = "메뉴 URL")
    private String menuUrl;

    @JsonProperty("menu_icon")
    @Schema(description = "메뉴 아이콘")
    private String menuIcon;

    @JsonProperty("parent_menu_id")
    @Schema(description = "부모 메뉴 ID")
    private Long parentMenuId;

    @JsonProperty("menu_order")
    @Schema(description = "메뉴 순서")
    private Integer menuOrder;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", required = true)
    private Boolean isActive;

    @JsonProperty("children")
    @Schema(description = "하위 메뉴 목록")
    private List<SidebarMenu> children;
}