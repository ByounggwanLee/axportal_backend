package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 그룹 관리 API Feign Client
 * 
 * <p>그룹 생성, 조회, 수정, 삭제 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-groups-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthGroupsClient {

    /**
     * 그룹 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 그룹 목록
     */
    @GetMapping("/api/v1/groups")
    java.util.List<GroupBase> getGroups(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 그룹 생성
     * 
     * @param groupBase 생성할 그룹 정보
     * @return 생성된 그룹 정보
     */
    @PostMapping("/api/v1/groups")
    GroupBase createGroup(@RequestBody GroupBase groupBase);

    /**
     * 특정 그룹 조회
     * 
     * @param groupId 그룹 ID
     * @return 그룹 정보
     */
    @GetMapping("/api/v1/groups/{group_id}")
    GroupBase readGroup(@PathVariable("group_id") String groupId);

    /**
     * 그룹 수정
     * 
     * @param groupId 그룹 ID
     * @param groupBase 수정할 그룹 정보
     * @return 수정된 그룹 정보
     */
    @PutMapping("/api/v1/groups/{group_id}")
    GroupBase editGroup(
            @PathVariable("group_id") String groupId,
            @RequestBody GroupBase groupBase
    );

    /**
     * 그룹 삭제
     * 
     * @param groupId 그룹 ID
     */
    @DeleteMapping("/api/v1/groups/{group_id}")
    void removeGroup(@PathVariable("group_id") String groupId);
}
