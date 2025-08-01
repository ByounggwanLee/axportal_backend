package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.auth.dto.response.*;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 프로젝트 관리 API Feign Client
 * 
 * <p>프로젝트 생성, 조회, 수정, 삭제, 역할 관리 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-projects-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthProjectsClient {

    /**
     * 프로젝트 생성
     * 
     * @param createClient 생성할 프로젝트 정보
     * @return 생성된 프로젝트 정보
     */
    @PostMapping("/api/v1/projects")
    CreatedClientReadResponse createProject(@RequestBody CreateClient createClient);

    /**
     * 프로젝트 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 프로젝트 목록
     */
    @GetMapping("/api/v1/projects")
    Pagination<ProjectPayload> getProjects(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 특정 프로젝트 조회
     * 
     * @param projectId 프로젝트 ID
     * @return 프로젝트 정보
     */
    @GetMapping("/api/v1/projects/{project_id}")
    ClientReadResponse readProject(@PathVariable("project_id") String projectId);

    /**
     * 프로젝트 수정
     * 
     * @param projectId 프로젝트 ID
     * @param updateClient 수정할 프로젝트 정보
     * @return 수정된 프로젝트 정보
     */
    @PutMapping("/api/v1/projects/{project_id}")
    CreatedClientReadResponse editProject(
            @PathVariable("project_id") String projectId,
            @RequestBody UpdateClient updateClient
    );

    /**
     * 프로젝트 삭제
     * 
     * @param projectId 프로젝트 ID
     */
    @DeleteMapping("/api/v1/projects/{project_id}")
    void removeProject(@PathVariable("project_id") String projectId);

    /**
     * 클라이언트 역할 조회
     * 
     * @param clientId 클라이언트 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 클라이언트 역할 목록
     */
    @GetMapping("/api/v1/projects/clients/{client_id}/roles")
    Pagination<ProjectRoleMappingsReadResponse> getClientRoles(
            @PathVariable("client_id") String clientId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 프로젝트 역할 생성
     * 
     * @param projectId 프로젝트 ID
     * @param createProjectRole 생성할 역할 정보
     * @return 생성된 역할 정보
     */
    @PostMapping("/api/v1/projects/{project_id}/roles")
    ProjectRoleMappingsReadResponse createProjectRole(
            @PathVariable("project_id") String projectId,
            @RequestBody CreateProjectRole createProjectRole
    );

    /**
     * 프로젝트 역할 목록 조회
     * 
     * @param projectId 프로젝트 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 프로젝트 역할 목록
     */
    @GetMapping("/api/v1/projects/{project_id}/roles")
    Pagination<ProjectRoleMappingsReadResponse> getProjectRoles(
            @PathVariable("project_id") String projectId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 특정 프로젝트 역할 조회
     * 
     * @param projectId 프로젝트 ID
     * @param roleId 역할 ID
     * @return 프로젝트 역할 정보
     */
    @GetMapping("/api/v1/projects/{project_id}/roles/{role_id}")
    ProjectRoleMappingsReadResponse readProjectRole(
            @PathVariable("project_id") String projectId,
            @PathVariable("role_id") String roleId
    );

    /**
     * 프로젝트 역할 수정
     * 
     * @param projectId 프로젝트 ID
     * @param roleId 역할 ID
     * @param createProjectRole 수정할 역할 정보
     * @return 수정된 역할 정보
     */
    @PutMapping("/api/v1/projects/{project_id}/roles/{role_id}")
    ProjectRoleMappingsReadResponse editProjectRole(
            @PathVariable("project_id") String projectId,
            @PathVariable("role_id") String roleId,
            @RequestBody CreateProjectRole createProjectRole
    );

    /**
     * 프로젝트 역할 삭제
     * 
     * @param projectId 프로젝트 ID
     * @param roleId 역할 ID
     */
    @DeleteMapping("/api/v1/projects/{project_id}/roles/{role_id}")
    void removeProjectRole(
            @PathVariable("project_id") String projectId,
            @PathVariable("role_id") String roleId
    );
}
