package com.skax.aiportal.client.sktai.gateway;

import com.skax.aiportal.client.sktai.gateway.dto.request.ModelGatewayCreateRequest;
import com.skax.aiportal.client.sktai.gateway.dto.request.ModelGatewayUpdateRequest;
import com.skax.aiportal.client.sktai.gateway.dto.response.ModelGatewayResponse;
import com.skax.aiportal.client.sktai.gateway.dto.response.ModelGatewayListResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AI Model Gateway API - 모델 게이트웨이 관리 Feign 클라이언트
 * 모델 게이트웨이 생성, 조회, 수정, 삭제 및 관리 기능
 */
@FeignClient(
    name = "skt-ai-model-gateway",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelGatewayClient {

    /**
     * 모델 게이트웨이 생성
     */
    @PostMapping("/api/v1/model-gateway")
    ModelGatewayResponse createModelGateway(@RequestBody ModelGatewayCreateRequest request);

    /**
     * 모델 게이트웨이 목록 조회
     */
    @GetMapping("/api/v1/model-gateway")
    ModelGatewayListResponse getModelGateways(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String gatewayType,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String sort
    );

    /**
     * 모델 게이트웨이 상세 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}")
    ModelGatewayResponse getModelGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 모델 게이트웨이 수정
     */
    @PutMapping("/api/v1/model-gateway/{gatewayId}")
    ModelGatewayResponse updateModelGateway(
        @PathVariable("gatewayId") String gatewayId,
        @RequestBody ModelGatewayUpdateRequest request
    );

    /**
     * 모델 게이트웨이 삭제
     */
    @DeleteMapping("/api/v1/model-gateway/{gatewayId}")
    void deleteModelGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 모델 게이트웨이 시작
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/start")
    ModelGatewayResponse startGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 모델 게이트웨이 중지
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/stop")
    ModelGatewayResponse stopGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 모델 게이트웨이 재시작
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/restart")
    ModelGatewayResponse restartGateway(@PathVariable("gatewayId") String gatewayId);

    /**
     * 모델 게이트웨이 활성화/비활성화
     */
    @PostMapping("/api/v1/model-gateway/{gatewayId}/toggle")
    ModelGatewayResponse toggleGateway(@PathVariable("gatewayId") String gatewayId);
}
