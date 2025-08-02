package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelEndpointCreateRequest;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelEndpointReadResponse;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelEndpointsReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Model API - Model Endpoints Feign Client
 * 모델 엔드포인트 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-model-endpoint-client", 
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ModelEndpointClient {

    /**
     * 모델 엔드포인트 등록
     */
    @PostMapping("/api/v1/models/{model_id}/endpoints")
    ModelEndpointReadResponse registerModelEndpoint(
        @PathVariable("model_id") UUID modelId,
        @RequestBody ModelEndpointCreateRequest request
    );

    /**
     * 모델 엔드포인트 목록 조회
     */
    @GetMapping("/api/v1/models/{model_id}/endpoints")
    ModelEndpointsReadResponse readModelEndpoints(
        @PathVariable("model_id") UUID modelId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 모델 엔드포인트 상세 조회
     */
    @GetMapping("/api/v1/models/{model_id}/endpoints/{endpoint_id}")
    ModelEndpointReadResponse readModelEndpoint(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("endpoint_id") UUID endpointId
    );

    /**
     * 모델 엔드포인트 삭제 (삭제 플래그 설정)
     */
    @DeleteMapping("/api/v1/models/{model_id}/endpoints/{endpoint_id}")
    void removeModelEndpoint(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("endpoint_id") UUID endpointId
    );
}
