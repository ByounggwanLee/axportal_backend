package com.skax.aiportal.client.sktai.authorization;

import com.skax.aiportal.client.sktai.authorization.dto.CreateClient;
import com.skax.aiportal.client.sktai.authorization.dto.CreateProjectRole;
import com.skax.aiportal.client.sktai.authorization.dto.UpdateClient;
import com.skax.aiportal.client.sktai.authorization.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI 프로젝트 관리 API Feign Client
 * 
 * <p>
 * SKT AI 플랫폼의 프로젝트 관리 관련 API를 호출하는 Feign Client입니다.
 * </p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@FeignClient(name = "skt-ai-project", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class)
public interface SktAiProjectManagementClient {

    /**
     * 프로젝트 등록
     * 
     * @param createClient 프로젝트 생성 정보
     * @return 생성된 프로젝트 정보
     */
    @PostMapping(value = "/api/v1/projects", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CreatedClientReadResponse registerProject(@RequestBody CreateClient createClient);

    /**
     * 프로젝트 목록 조회
     * 
     * @param page   페이지 번호 (기본값: 1)
     * @param size   페이지 크기 (기본값: 10)
     * @param sort   정렬 기준
     * @param filter 필터
     * @param search 검색어
     * @return 프로젝트 목록
     */
    @GetMapping("/api/v1/projects")
    ClientsReadResponse getProjects(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search);

    /**
     * 프로젝트 수정
     * 
     * @param projectId    프로젝트 ID
     * @param updateClient 프로젝트 수정 정보
     * @return 수정된 프로젝트 정보
     */
    @PutMapping("/api/v1/projects/{project_id}")
    CreatedClientReadResponse editProject(
            @PathVariable("project_id") String projectId,
            @RequestBody UpdateClient updateClient);

    /**
     * 프로젝트 조회
     * 
     * @param projectId 프로젝트 ID
     * @return 프로젝트 정보
     */
    @GetMapping("/api/v1/projects/{project_id}")
    ClientReadResponse getProject(@PathVariable("project_id") String projectId);

    /**
     * 프로젝트 삭제
     * 
     * @param projectId 프로젝트 ID
     */
    @DeleteMapping("/api/v1/projects/{project_id}")
    void removeProject(@PathVariable("project_id") String projectId);

    /**
     * 클라이언트 역할 목록 조회
     * 
     * @param clientId 클라이언트 ID
     * @param page     페이지 번호 (기본값: 1)
     * @param size     페이지 크기 (기본값: 10)
     * @param sort     정렬 기준
     * @param filter   필터
     * @param search   검색어
     * @return 역할 목록
     */
    @GetMapping("/api/v1/projects/{client_id}/roles")
    ProjectRoleMappingsResponse getClientRoles(
            @PathVariable("client_id") String clientId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search);

    /**
     * 클라이언트 역할 등록
     * 
     * @param clientId          클라이언트 ID
     * @param createProjectRole 역할 생성 정보
     * @return 생성된 역할 정보
     */
    @PostMapping(value = "/api/v1/projects/{client_id}/roles", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleResponse registerClientRole(
            @PathVariable("client_id") String clientId,
            @RequestBody CreateProjectRole createProjectRole);

    /**
     * 특정 역할의 사용자 목록 조회
     * 
     * @param clientId 클라이언트 ID
     * @param roleName 역할명
     * @param page     페이지 번호 (기본값: 1)
     * @param size     페이지 크기 (기본값: 10)
     * @param sort     정렬 기준
     * @param filter   필터
     * @param search   검색어
     * @return 사용자 목록
     */
    @GetMapping("/api/v1/projects/{client_id}/roles/{role_name}/users")
    UsersReadResponse getRoleUsers(
            @PathVariable("client_id") String clientId,
            @PathVariable("role_name") String roleName,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search);

    /**
     * 역할 정보 조회
     * 
     * @param roleId 역할 ID
     * @return 역할 정보
     */
    @GetMapping("/api/v1/projects/roles/{role_id}")
    RoleResponse getRole(@PathVariable("role_id") String roleId);

    /**
     * 클라이언트 역할 수정
     * 
     * @param clientId    클라이언트 ID
     * @param roleName    역할명
     * @param description 설명
     */
    @PutMapping("/api/v1/projects/{client_id}/roles/{role_name}")
    void updateClientRole(
            @PathVariable("client_id") String clientId,
            @PathVariable("role_name") String roleName,
            @RequestParam("description") String description);

    /**
     * 클라이언트 역할 삭제
     * 
     * @param clientId 클라이언트 ID
     * @param roleName 역할명
     */
    @DeleteMapping("/api/v1/projects/{client_id}/roles/{role_name}")
    void deleteClientRole(
            @PathVariable("client_id") String clientId,
            @PathVariable("role_name") String roleName);
}
