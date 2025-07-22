package com.skax.aiportal.client.sktai.resource;

import com.skax.aiportal.client.sktai.resource.dto.request.ResourceCreateRequest;
import com.skax.aiportal.client.sktai.resource.dto.request.ResourceUpdateRequest;
import com.skax.aiportal.client.sktai.resource.dto.request.ResourceAllocationRequest;
import com.skax.aiportal.client.sktai.resource.dto.response.ResourceResponse;
import com.skax.aiportal.client.sktai.resource.dto.response.ResourceListResponse;
import com.skax.aiportal.client.sktai.resource.dto.response.ResourceAllocationResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Resource API - 리소스 관리 Feign 클라이언트
 * 컴퓨팅 리소스 생성, 조회, 수정, 삭제 및 할당 관리 기능
 */
@FeignClient(
    name = "skt-ai-resource",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiResourceClient {

    /**
     * 리소스 생성
     */
    @PostMapping("/api/v1/resource")
    ResourceResponse createResource(@RequestBody ResourceCreateRequest request);

    /**
     * 리소스 목록 조회
     */
    @GetMapping("/api/v1/resource")
    ResourceListResponse getResources(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String resourceType,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String availabilityZone,
        @RequestParam(required = false) String sort
    );

    /**
     * 리소스 상세 조회
     */
    @GetMapping("/api/v1/resource/{resourceId}")
    ResourceResponse getResource(@PathVariable("resourceId") String resourceId);

    /**
     * 리소스 수정
     */
    @PutMapping("/api/v1/resource/{resourceId}")
    ResourceResponse updateResource(
        @PathVariable("resourceId") String resourceId,
        @RequestBody ResourceUpdateRequest request
    );

    /**
     * 리소스 삭제
     */
    @DeleteMapping("/api/v1/resource/{resourceId}")
    void deleteResource(@PathVariable("resourceId") String resourceId);

    /**
     * 리소스 할당
     */
    @PostMapping("/api/v1/resource/allocate")
    ResourceAllocationResponse allocateResource(@RequestBody ResourceAllocationRequest request);

    /**
     * 리소스 할당 해제
     */
    @PostMapping("/api/v1/resource/allocation/{allocationId}/release")
    ResourceAllocationResponse releaseResource(@PathVariable("allocationId") String allocationId);

    /**
     * 리소스 할당 목록 조회
     */
    @GetMapping("/api/v1/resource/{resourceId}/allocations")
    List<ResourceAllocationResponse> getResourceAllocations(
        @PathVariable("resourceId") String resourceId,
        @RequestParam(required = false) String status
    );

    /**
     * 리소스 사용량 통계 조회
     */
    @GetMapping("/api/v1/resource/{resourceId}/usage-stats")
    Object getResourceUsageStats(
        @PathVariable("resourceId") String resourceId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate
    );

    /**
     * 리소스 헬스체크
     */
    @GetMapping("/api/v1/resource/{resourceId}/health")
    Object getResourceHealth(@PathVariable("resourceId") String resourceId);

    /**
     * 리소스 시작
     */
    @PostMapping("/api/v1/resource/{resourceId}/start")
    ResourceResponse startResource(@PathVariable("resourceId") String resourceId);

    /**
     * 리소스 중지
     */
    @PostMapping("/api/v1/resource/{resourceId}/stop")
    ResourceResponse stopResource(@PathVariable("resourceId") String resourceId);

    /**
     * 리소스 재시작
     */
    @PostMapping("/api/v1/resource/{resourceId}/restart")
    ResourceResponse restartResource(@PathVariable("resourceId") String resourceId);
}
