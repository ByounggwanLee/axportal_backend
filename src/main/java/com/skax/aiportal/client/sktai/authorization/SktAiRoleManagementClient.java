package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.SidebarMenuDict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI 역할 관리 API Feign Client
 * 
 * <p>SKT AI 플랫폼의 역할 관리 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-role",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiRoleManagementClient {

    /**
     * 기본 역할 생성
     * 
     * @param clientName 클라이언트명 (기본값: default)
     * @return 생성 결과
     */
    @PostMapping("/api/v1/auth/role/default")
    Object createDefaultRoles(@RequestParam(value = "client_name", defaultValue = "default") String clientName);

    /**
     * 사이드바 메뉴 생성
     * 
     * @param roleName 역할명
     * @param sidebarMenuDict 사이드바 메뉴 정보
     * @return 생성 결과
     */
    @PostMapping("/api/v1/auth/role/sbn/{role_name}")
    Object createSidebarMenu(
            @PathVariable("role_name") String roleName,
            @RequestBody SidebarMenuDict sidebarMenuDict
    );

    /**
     * 사이드바 메뉴 조회
     * 
     * @param roleName 역할명
     * @return 사이드바 메뉴 정보
     */
    @GetMapping("/api/v1/auth/role/sbn/{role_name}")
    SidebarMenuDict getSidebarMenu(@PathVariable("role_name") String roleName);

    /**
     * 사이드바 메뉴 수정
     * 
     * @param roleName 역할명
     * @param sidebarMenuDict 수정할 사이드바 메뉴 정보
     * @return 수정된 사이드바 메뉴 정보
     */
    @PutMapping("/api/v1/auth/role/sbn/{role_name}")
    SidebarMenuDict updateSidebarMenu(
            @PathVariable("role_name") String roleName,
            @RequestBody SidebarMenuDict sidebarMenuDict
    );

    /**
     * 사이드바 메뉴 삭제
     * 
     * @param roleName 역할명
     */
    @DeleteMapping("/api/v1/auth/role/sbn/{role_name}")
    void deleteSidebarMenu(@PathVariable("role_name") String roleName);

    /**
     * 프로젝트별 사이드바 메뉴 조회
     * 
     * @return 프로젝트별 사이드바 메뉴 정보
     */
    @GetMapping("/api/v1/auth/role/sbn")
    Object getSidebarMenuByProject();
}
