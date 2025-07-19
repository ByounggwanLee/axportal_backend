package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.response.GroupResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.GroupsReadResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.UsersReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI 그룹 관리 API Feign Client
 * 
 * <p>SKT AI 플랫폼의 그룹 관리 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-group",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiGroupManagementClient {

    /**
     * 그룹 목록 조회
     * 
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 그룹 목록
     */
    @GetMapping("/api/v1/groups")
    GroupsReadResponse getGroups(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 그룹 생성
     * 
     * @param groupName 그룹명
     * @return 생성된 그룹 정보
     */
    @PostMapping("/api/v1/groups")
    GroupResponse registerGroup(@RequestParam("group_name") String groupName);

    /**
     * 그룹 정보 조회
     * 
     * @param groupId 그룹 ID
     * @return 그룹 정보
     */
    @GetMapping("/api/v1/groups/{group_id}")
    GroupResponse getGroup(@PathVariable("group_id") String groupId);

    /**
     * 그룹 정보 수정
     * 
     * @param groupId 그룹 ID
     * @param groupName 새 그룹명
     */
    @PutMapping("/api/v1/groups/{group_id}")
    void updateGroup(
            @PathVariable("group_id") String groupId,
            @RequestParam("group_name") String groupName
    );

    /**
     * 그룹 삭제
     * 
     * @param groupId 그룹 ID
     */
    @DeleteMapping("/api/v1/groups/{group_id}")
    void deleteGroup(@PathVariable("group_id") String groupId);

    /**
     * 그룹에 할당 가능한 사용자 목록 조회
     * 
     * @param groupId 그룹 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 할당 가능한 사용자 목록
     */
    @GetMapping("/api/v1/groups/{group_id}/user-available")
    UsersReadResponse getGroupAvailableUsers(
            @PathVariable("group_id") String groupId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 그룹의 사용자 매핑 목록 조회
     * 
     * @param groupId 그룹 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 그룹의 사용자 목록
     */
    @GetMapping("/api/v1/groups/{group_id}/user-mappings")
    UsersReadResponse getGroupUserMappings(
            @PathVariable("group_id") String groupId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 그룹에 사용자 할당
     * 
     * @param groupId 그룹 ID
     * @param userId 사용자 ID
     */
    @PutMapping("/api/v1/groups/{group_id}/user-mappings")
    void assignUserToGroup(
            @PathVariable("group_id") String groupId,
            @RequestParam("user_id") String userId
    );

    /**
     * 그룹에서 사용자 제거
     * 
     * @param groupId 그룹 ID
     * @param userId 사용자 ID
     */
    @DeleteMapping("/api/v1/groups/{group_id}/user-mappings")
    void removeUserFromGroup(
            @PathVariable("group_id") String groupId,
            @RequestParam("user_id") String userId
    );
}
