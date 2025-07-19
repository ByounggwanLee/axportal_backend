package com.skax.aiportal.client.sktai.authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 사이드바 메뉴 Dictionary DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SidebarMenuDict {

    /**
     * 사이드바 메뉴 구조
     * Map<카테고리, Map<서브카테고리, 메뉴아이템리스트>>
     */
    private Map<String, Map<String, List<SidebarMenuItem>>> menus;

    /**
     * 사이드바 메뉴 아이템
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SidebarMenuItem {
        
        /**
         * 메뉴 키
         */
        private String key;

        /**
         * 하위 메뉴
         */
        private List<SidebarMenuItem> children;

        /**
         * 스코프 (GET, POST, PUT, DELETE)
         */
        private List<String> scope;
    }
}
