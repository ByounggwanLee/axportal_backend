package com.skax.aiportal.client.sktai.model;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.model.dto.request.ModelProviderCreateRequest;
import com.skax.aiportal.client.sktai.model.dto.request.ModelProviderUpdateRequest;
import com.skax.aiportal.client.sktai.model.dto.response.ModelProviderResponse;
import com.skax.aiportal.client.sktai.model.dto.response.ModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model API - 모델 프로바이더 관리 Feign 클라이언트
 * 모델 프로바이더 생성, 조회, 수정, 삭제
 */
@FeignClient(
    name = "skt-ai-model-provider",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelProviderClient {
    
    /**
     * 모델 프로바이더 생성
     */
    @PostMapping("/api/v1/models/providers")
    ModelProviderResponse createProvider(@RequestBody ModelProviderCreateRequest request);
    
    /**
     * 모델 프로바이더 목록 조회
     */
    @GetMapping("/api/v1/models/providers")
    ModelResponse<List<ModelProviderResponse>> getProviders(
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "10") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search
    );
    
    /**
     * 모델 프로바이더 상세 조회
     */
    @GetMapping("/api/v1/models/providers/{providerId}")
    ModelProviderResponse getProvider(@PathVariable("providerId") String providerId);
    
    /**
     * 모델 프로바이더 수정
     */
    @PutMapping("/api/v1/models/providers/{providerId}")
    ModelProviderResponse updateProvider(
        @PathVariable("providerId") String providerId,
        @RequestBody ModelProviderUpdateRequest request
    );
    
    /**
     * 모델 프로바이더 삭제
     */
    @DeleteMapping("/api/v1/models/providers/{providerId}")
    void deleteProvider(@PathVariable("providerId") String providerId);
}
