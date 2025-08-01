package com.skax.aiplatform.client.sktax.auth;

import com.skax.aiplatform.client.sktax.auth.dto.*;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKTAX 네임스페이스 관리 API Feign Client
 * 
 * <p>네임스페이스 생성, 조회, 수정, 삭제 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@FeignClient(
    name = "sktax-auth-namespaces-client",
    url = "https://aip-stg.sktai.io",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAuthNamespacesClient {

    /**
     * 네임스페이스 목록 조회
     * 
     * @param projectId 프로젝트 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색 조건
     * @return 네임스페이스 목록
     */
    @GetMapping("/api/v1/projects/{project_id}/namespaces")
    java.util.List<NamespaceBase> getNamespaces(
            @PathVariable("project_id") String projectId,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 네임스페이스 생성
     * 
     * @param projectId 프로젝트 ID
     * @param createNamespace 생성할 네임스페이스 정보
     * @return 생성된 네임스페이스 정보
     */
    @PostMapping("/api/v1/projects/{project_id}/namespaces")
    NamespaceBase createNamespace(
            @PathVariable("project_id") String projectId,
            @RequestBody CreateNamespace createNamespace
    );

    /**
     * 특정 네임스페이스 조회
     * 
     * @param projectId 프로젝트 ID
     * @param namespaceId 네임스페이스 ID
     * @return 네임스페이스 정보
     */
    @GetMapping("/api/v1/projects/{project_id}/namespaces/{namespace_id}")
    NamespaceBase readNamespace(
            @PathVariable("project_id") String projectId,
            @PathVariable("namespace_id") String namespaceId
    );

    /**
     * 네임스페이스 수정
     * 
     * @param projectId 프로젝트 ID
     * @param namespaceId 네임스페이스 ID
     * @param createNamespace 수정할 네임스페이스 정보
     * @return 수정된 네임스페이스 정보
     */
    @PutMapping("/api/v1/projects/{project_id}/namespaces/{namespace_id}")
    NamespaceBase editNamespace(
            @PathVariable("project_id") String projectId,
            @PathVariable("namespace_id") String namespaceId,
            @RequestBody CreateNamespace createNamespace
    );

    /**
     * 네임스페이스 삭제
     * 
     * @param projectId 프로젝트 ID
     * @param namespaceId 네임스페이스 ID
     */
    @DeleteMapping("/api/v1/projects/{project_id}/namespaces/{namespace_id}")
    void removeNamespace(
            @PathVariable("project_id") String projectId,
            @PathVariable("namespace_id") String namespaceId
    );
}
