package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.request.UserRegisterRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.UserUpdateRequest;
import com.skax.aiportal.client.sktai.authorization.dto.request.ProjectRolesRequest;
import com.skax.aiportal.client.sktai.authorization.dto.response.MeResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.UserResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.UsersReadResponse;
import com.skax.aiportal.client.sktai.authorization.dto.response.UserRoleMappingsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI 사용자 관리 API Feign Client
 * 
 * <p>SKT AI 플랫폼의 사용자 관리 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-user",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiUserManagementClient {

    /**
     * 사용자 목록 조회
     * 
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 사용자 목록
     */
    @GetMapping("/api/v1/users")
    UsersReadResponse getUsers(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 로그인한 사용자 정보 조회
     * 
     * @return 현재 사용자 정보
     */
    @GetMapping("/api/v1/users/me")
    MeResponse getMyInfo();

    /**
     * 사용자 등록
     * 
     * @param userRegisterRequest 사용자 등록 요청
     * @return 등록된 사용자 정보
     */
    @PostMapping("/api/v1/users/register")
    UserResponse registerUser(@RequestBody UserRegisterRequest userRegisterRequest);

    /**
     * 사용자 정보 조회
     * 
     * @param userId 사용자 ID
     * @return 사용자 정보
     */
    @GetMapping("/api/v1/users/{user_id}")
    UserResponse getUser(@PathVariable("user_id") String userId);

    /**
     * 사용자 정보 수정
     * 
     * @param userId 사용자 ID
     * @param userUpdateRequest 사용자 수정 요청
     */
    @PutMapping("/api/v1/users/{user_id}")
    void updateUser(
            @PathVariable("user_id") String userId,
            @RequestBody UserUpdateRequest userUpdateRequest
    );

    /**
     * 사용자 삭제
     * 
     * @param userId 사용자 ID
     */
    @DeleteMapping("/api/v1/users/{user_id}")
    void deleteUser(@PathVariable("user_id") String userId);

    /**
     * 사용자의 할당 가능한 역할 목록 조회
     * 
     * @param userId 사용자 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 할당 가능한 역할 목록
     */
    @GetMapping("/api/v1/users/{user_id}/role-available")
    UserRoleMappingsResponse getUserAvailableRoles(
            @PathVariable("user_id") String userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 사용자의 역할 매핑 목록 조회
     * 
     * @param userId 사용자 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 역할 매핑 목록
     */
    @GetMapping("/api/v1/users/{user_id}/role-mappings")
    UserRoleMappingsResponse getUserRoleMappings(
            @PathVariable("user_id") String userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 사용자에게 역할 할당
     * 
     * @param userId 사용자 ID
     * @param projectRoles 할당할 역할 목록
     */
    @PutMapping("/api/v1/users/{user_id}/role-mappings")
    void assignRolesToUser(
            @PathVariable("user_id") String userId,
            @RequestBody List<ProjectRolesRequest> projectRoles
    );

    /**
     * 사용자의 역할 제거
     * 
     * @param userId 사용자 ID
     * @param projectRoles 제거할 역할 목록
     */
    @DeleteMapping("/api/v1/users/{user_id}/role-mappings")
    void removeRolesFromUser(
            @PathVariable("user_id") String userId,
            @RequestBody List<ProjectRolesRequest> projectRoles
    );

    /**
     * 사용자의 할당 가능한 그룹 목록 조회
     * 
     * @param userId 사용자 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 할당 가능한 그룹 목록
     */
    @GetMapping("/api/v1/users/{user_id}/group-available")
    Object getUserAvailableGroups(
            @PathVariable("user_id") String userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 사용자의 그룹 매핑 목록 조회
     * 
     * @param userId 사용자 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 그룹 매핑 목록
     */
    @GetMapping("/api/v1/users/{user_id}/group-mappings")
    Object getUserGroupMappings(
            @PathVariable("user_id") String userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 사용자를 그룹에 할당
     * 
     * @param userId 사용자 ID
     * @param groupId 그룹 ID
     */
    @PutMapping("/api/v1/users/{user_id}/group-mappings")
    void assignUserToGroup(
            @PathVariable("user_id") String userId,
            @RequestParam("group_id") String groupId
    );

    /**
     * 사용자를 그룹에서 제거
     * 
     * @param userId 사용자 ID
     * @param groupId 그룹 ID
     */
    @DeleteMapping("/api/v1/users/{user_id}/group-mappings")
    void removeUserFromGroup(
            @PathVariable("user_id") String userId,
            @RequestParam("group_id") String groupId
    );

    /**
     * 비밀번호 초기화
     * 
     * @param userId 사용자 ID
     * @return 초기화 결과
     */
    @PostMapping("/api/v1/users/{user_id}/password/reset")
    Object resetPassword(@PathVariable("user_id") String userId);

    /**
     * 비밀번호 변경
     * 
     * @param username 사용자명
     * @param newPassword 새 비밀번호
     */
    @PostMapping("/api/v1/users/{username}/password/change")
    void changePassword(
            @PathVariable("username") String username,
            @RequestParam("new_password") String newPassword
    );
}
