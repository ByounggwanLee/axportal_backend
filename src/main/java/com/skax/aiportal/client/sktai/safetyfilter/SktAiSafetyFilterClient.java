package com.skax.aiportal.client.sktai.safetyfilter;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.safetyfilter.dto.request.SafetyFilterCreateRequest;
import com.skax.aiportal.client.sktai.safetyfilter.dto.request.SafetyFilterUpdateRequest;
import com.skax.aiportal.client.sktai.safetyfilter.dto.response.SafetyFilterResponse;
import com.skax.aiportal.client.sktai.safetyfilter.dto.response.SafetyFilterListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * SKT AI 안전 필터 관리 API 클라이언트
 * 
 * 안전 필터의 생성, 조회, 수정, 삭제를 담당합니다.
 */
@FeignClient(
    name = "sktai-safety-filter-client",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiSafetyFilterClient {

    /**
     * 안전 필터 목록 조회
     * 
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @return 안전 필터 목록 응답
     */
    @GetMapping("/api/v1/safety-filters")
    SafetyFilterListResponse getSafetyFilters(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 안전 필터 상세 조회
     * 
     * @param safetyFilterId 안전 필터 ID
     * @return 안전 필터 상세 정보
     */
    @GetMapping("/api/v1/safety-filters/{safety_filter_id}")
    SafetyFilterResponse getSafetyFilter(@PathVariable("safety_filter_id") String safetyFilterId);

    /**
     * 새로운 안전 필터 생성
     * 
     * @param request 안전 필터 생성 요청
     * @return 생성된 안전 필터 정보
     */
    @PostMapping("/api/v1/safety-filters")
    SafetyFilterResponse createSafetyFilter(@Valid @RequestBody SafetyFilterCreateRequest request);

    /**
     * 안전 필터 정보 수정
     * 
     * @param safetyFilterId 안전 필터 ID
     * @param request 안전 필터 수정 요청
     * @return 수정된 안전 필터 정보
     */
    @PutMapping("/api/v1/safety-filters/{safety_filter_id}")
    SafetyFilterResponse updateSafetyFilter(
            @PathVariable("safety_filter_id") String safetyFilterId,
            @Valid @RequestBody SafetyFilterUpdateRequest request
    );

    /**
     * 안전 필터 삭제
     * 
     * @param safetyFilterId 안전 필터 ID
     */
    @DeleteMapping("/api/v1/safety-filters/{safety_filter_id}")
    void deleteSafetyFilter(@PathVariable("safety_filter_id") String safetyFilterId);
}
