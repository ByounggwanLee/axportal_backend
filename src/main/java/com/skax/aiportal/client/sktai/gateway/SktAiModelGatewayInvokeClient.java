package com.skax.aiportal.client.sktai.gateway;

import com.skax.aiportal.client.sktai.gateway.dto.request.ModelGatewayInvokeRequest;
import com.skax.aiportal.client.sktai.gateway.dto.response.ModelGatewayInvokeResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model Gateway API - 모델 게이트웨이 호출 Feign 클라이언트
 * 모델 게이트웨이를 통한 모델 호출 및 라우팅 기능
 */
@FeignClient(
    name = "skt-ai-model-gateway-invoke",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelGatewayInvokeClient {

    /**
     * 모델 게이트웨이를 통한 모델 호출
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/invoke")
    ModelGatewayInvokeResponse invokeModel(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody ModelGatewayInvokeRequest request
    );

    /**
     * 모델 게이트웨이를 통한 비동기 모델 호출
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/invoke-async")
    ModelGatewayInvokeResponse invokeModelAsync(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody ModelGatewayInvokeRequest request
    );

    /**
     * 비동기 호출 결과 조회
     */
    @GetMapping("/api/v1/model-gateway/invoke/{requestId}")
    ModelGatewayInvokeResponse getInvokeResult(@PathVariable("requestId") String requestId);

    /**
     * 호출 히스토리 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/invoke-history")
    List<ModelGatewayInvokeResponse> getInvokeHistory(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String status
    );

    /**
     * 특정 모델의 호출 히스토리 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/models/{modelName}/invoke-history")
    List<ModelGatewayInvokeResponse> getModelInvokeHistory(
        @PathVariable("gatewayId") String gatewayId,
        @PathVariable("modelName") String modelName,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate
    );
}
