package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 사이드바 메뉴 관리 API Feign Client
 * 
 * <p>사이드바 메뉴 조회 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-sidebar-menu-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthSidebarMenuClient {

    /**
     * 사이드바 메뉴 목록 조회
     * 
     * @return 사이드바 메뉴 목록
     */
    @GetMapping("/api/v1/sidebar-menu")
    java.util.List<SidebarMenu> getSidebarMenu();

    /**
     * 사용자별 사이드바 메뉴 목록 조회
     * 
     * @param userId 사용자 ID
     * @return 사용자별 사이드바 메뉴 목록
     */
    @GetMapping("/api/v1/users/{user_id}/sidebar-menu")
    java.util.List<SidebarMenu> getUserSidebarMenu(@PathVariable("user_id") String userId);
}
