package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 역할 관리 API Feign Client
 * 
 * <p>역할 생성, 조회, 수정, 삭제 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-roles-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthRolesClient {

    /**
     * 역할 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 역할 목록
     */
    @GetMapping("/api/v1/roles")
    Pagination<RoleBase> getRoles(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 역할 생성
     * 
     * @param roleBase 생성할 역할 정보
     * @return 생성된 역할 정보
     */
    @PostMapping("/api/v1/roles")
    RoleBase createRole(@RequestBody RoleBase roleBase);

    /**
     * 특정 역할 조회
     * 
     * @param roleId 역할 ID
     * @return 역할 정보
     */
    @GetMapping("/api/v1/roles/{role_id}")
    RoleBase readRole(@PathVariable("role_id") String roleId);

    /**
     * 역할 수정
     * 
     * @param roleId 역할 ID
     * @param roleBase 수정할 역할 정보
     * @return 수정된 역할 정보
     */
    @PutMapping("/api/v1/roles/{role_id}")
    RoleBase editRole(
            @PathVariable("role_id") String roleId,
            @RequestBody RoleBase roleBase
    );

    /**
     * 역할 삭제
     * 
     * @param roleId 역할 ID
     */
    @DeleteMapping("/api/v1/roles/{role_id}")
    void removeRole(@PathVariable("role_id") String roleId);
}
