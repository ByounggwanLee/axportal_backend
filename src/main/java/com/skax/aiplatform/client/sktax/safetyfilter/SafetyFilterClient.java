package com.skax.aiplatform.client.sktax.safetyfilter;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.request.SafetyFilterCreate;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.request.SafetyFilterUpdate;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.response.SafetyFilterRead;
import com.skax.aiplatform.client.sktax.safetyfilter.dto.response.SafetyFiltersRead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Safety Filter API - Safety Filters Management Feign Client
 * Safety Filter 관리 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-safety-filter-client",
    url = "${skt-ax.safety-filter.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SafetyFilterClient {

    /**
     * Safety Filter 등록
     */
    @PostMapping("/api/v1/safety-filters")
    SafetyFilterRead registerSafetyFilter(@RequestBody SafetyFilterCreate request);

    /**
     * Safety Filter 목록 조회
     */
    @GetMapping("/api/v1/safety-filters")
    SafetyFiltersRead readSafetyFilters(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Safety Filter 상세 조회
     */
    @GetMapping("/api/v1/safety-filters/{safety_filter_id}")
    SafetyFilterRead readSafetyFilter(@PathVariable("safety_filter_id") UUID safetyFilterId);

    /**
     * Safety Filter 수정
     */
    @PutMapping("/api/v1/safety-filters/{safety_filter_id}")
    SafetyFilterRead editSafetyFilter(
        @PathVariable("safety_filter_id") UUID safetyFilterId,
        @RequestBody SafetyFilterUpdate request
    );

    /**
     * Safety Filter 삭제
     */
    @DeleteMapping("/api/v1/safety-filters/{safety_filter_id}")
    void removeSafetyFilter(@PathVariable("safety_filter_id") UUID safetyFilterId);
}
