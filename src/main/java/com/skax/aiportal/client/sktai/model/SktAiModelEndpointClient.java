package com.skax.aiportal.client.sktai.model;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.model.dto.request.ModelEndpointCreateRequest;
import com.skax.aiportal.client.sktai.model.dto.response.ModelEndpointResponse;
import com.skax.aiportal.client.sktai.model.dto.response.ModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model API - 모델 엔드포인트 관리 Feign 클라이언트
 * 모델 엔드포인트 생성, 조회, 삭제
 */
@FeignClient(
    name = "skt-ai-model-endpoint",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelEndpointClient {
    
    /**
     * 모델 엔드포인트 생성
     */
    @PostMapping("/api/v1/models/{modelId}/endpoints")
    ModelEndpointResponse createModelEndpoint(
        @PathVariable("modelId") String modelId,
        @RequestBody ModelEndpointCreateRequest request
    );
    
    /**
     * 모델의 엔드포인트 목록 조회
     */
    @GetMapping("/api/v1/models/{modelId}/endpoints")
    ModelResponse<List<ModelEndpointResponse>> getModelEndpoints(
        @PathVariable("modelId") String modelId,
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "10") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search
    );
    
    /**
     * 모델의 특정 엔드포인트 조회
     */
    @GetMapping("/api/v1/models/{modelId}/endpoints/{endpointId}")
    ModelEndpointResponse getModelEndpoint(
        @PathVariable("modelId") String modelId,
        @PathVariable("endpointId") String endpointId
    );
    
    /**
     * 모델 엔드포인트 삭제
     */
    @DeleteMapping("/api/v1/models/{modelId}/endpoints/{endpointId}")
    void deleteModelEndpoint(
        @PathVariable("modelId") String modelId,
        @PathVariable("endpointId") String endpointId
    );
}
