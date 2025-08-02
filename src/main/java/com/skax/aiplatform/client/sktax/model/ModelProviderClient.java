package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelProviderCreateRequest;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelProviderUpdateRequest;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelProviderReadResponse;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelProvidersReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Model API - Model Providers Feign Client
 * 모델 제공자 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-model-provider-client", 
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ModelProviderClient {

    /**
     * 모델 제공자 등록
     */
    @PostMapping("/api/v1/models/providers")
    ModelProviderReadResponse registerModelProvider(@RequestBody ModelProviderCreateRequest request);

    /**
     * 모델 제공자 목록 조회
     */
    @GetMapping("/api/v1/models/providers")
    ModelProvidersReadResponse readModelProviders(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 모델 제공자 상세 조회
     */
    @GetMapping("/api/v1/models/providers/{provider_id}")
    ModelProviderReadResponse readModelProvider(@PathVariable("provider_id") UUID providerId);

    /**
     * 모델 제공자 수정
     */
    @PutMapping("/api/v1/models/providers/{provider_id}")
    ModelProviderReadResponse editModelProvider(
        @PathVariable("provider_id") UUID providerId,
        @RequestBody ModelProviderUpdateRequest request
    );

    /**
     * 모델 제공자 삭제 (삭제 플래그 설정)
     */
    @DeleteMapping("/api/v1/models/providers/{provider_id}")
    void removeModelProvider(@PathVariable("provider_id") UUID providerId);
}
