package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Schema(description = "메뉴 ID")
    private Long menuId;

    @JsonProperty("menu_name")
    @Schema(description = "메뉴명")
    private String menuName;

    @JsonProperty("menu_path")
    @Schema(description = "메뉴 경로")
    private String menuPath;

    @JsonProperty("menu_icon")
    @Schema(description = "메뉴 아이콘")
    private String menuIcon;

    @JsonProperty("parent_menu_id")
    @Schema(description = "상위 메뉴 ID")
    private Long parentMenuId;

    @JsonProperty("sort_order")
    @Schema(description = "정렬 순서")
    private Integer sortOrder;

    @JsonProperty("is_visible")
    @Schema(description = "표시 여부")
    private Boolean isVisible;

    @JsonProperty("permissions")
    @Schema(description = "필요 권한")
    private java.util.List<String> permissions;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;
}
