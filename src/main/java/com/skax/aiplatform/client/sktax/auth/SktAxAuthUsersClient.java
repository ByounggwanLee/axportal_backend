package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.auth.dto.response.MeResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKTAX 사용자 관리 API Feign Client
 * 
 * <p>사용자 조회, 생성, 수정, 삭제, 역할 및 그룹 매핑 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-users-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthUsersClient {

    /**
     * 모든 사용자 조회
     * 
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 사용자 목록
     */
    @GetMapping("/api/v1/users")
    UsersRead getUsers(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 로그인된 사용자 정보 조회
     * 
     * @return 사용자 정보
     */
    @GetMapping("/api/v1/users/me")
    MeResponse getMe();

    /**
     * 사용자 등록
     * 
     * @param registerPayload 사용자 등록 정보
     * @return 생성된 사용자 정보
     */
    @PostMapping("/api/v1/users/register")
    UserRepresentation registerUser(@RequestBody RegisterUserPayload registerPayload);

    /**
     * 특정 사용자 조회
     * 
     * @param userId 사용자 ID
     * @return 사용자 정보
     */
    @GetMapping("/api/v1/users/{user_id}")
    UserBase getUser(@PathVariable("user_id") String userId);

    /**
     * 사용자 정보 수정
     * 
     * @param userId 사용자 ID
     * @param updatePayload 수정할 사용자 정보
     */
    @PutMapping("/api/v1/users/{user_id}")
    void updateUser(
            @PathVariable("user_id") String userId,
            @RequestBody UpdateUserPayload updatePayload
    );

    /**
     * 사용자 삭제
     * 
     * @param userId 사용자 ID
     */
    @DeleteMapping("/api/v1/users/{user_id}")
    void deleteUser(@PathVariable("user_id") String userId);

    /**
     * 사용자 역할 매핑 조회
     * 
     * @param userId 사용자 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 사용자 역할 매핑 목록
     */
    @GetMapping("/api/v1/users/{user_id}/role-mappings")
    UserRoleMappingsRead getUserRoleMappings(
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
     * @param projectRoles 할당할 프로젝트 역할 목록
     */
    @PutMapping("/api/v1/users/{user_id}/role-mappings")
    void assignRolesToUser(
            @PathVariable("user_id") String userId,
            @RequestBody List<ProjectRoles> projectRoles
    );

    /**
     * 사용자 비밀번호 재설정
     * 
     * @param userId 사용자 ID
     * @return 재설정 결과
     */
    @PostMapping("/api/v1/users/{user_id}/password/reset")
    Object resetPassword(@PathVariable("user_id") String userId);

    /**
     * 사용자 비밀번호 변경
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
