package com.skax.aiportal.client.sktai.gateway;

import com.skax.aiportal.client.sktai.gateway.dto.response.ModelGatewayHealthResponse;
import com.skax.aiportal.client.sktai.gateway.dto.response.ModelGatewayMetricsResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model Gateway API - 모델 게이트웨이 모니터링 Feign 클라이언트
 * 모델 게이트웨이 헬스체크, 메트릭 및 모니터링 기능
 */
@FeignClient(
    name = "skt-ai-model-gateway-monitoring",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelGatewayMonitoringClient {

    /**
     * 모델 게이트웨이 헬스체크
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/health")
    ModelGatewayHealthResponse getGatewayHealth(@PathVariable("gatewayId") String gatewayId);

    /**
     * 전체 게이트웨이 헬스체크
     */
    @GetMapping("/api/v1/model-gateway/health")
    List<ModelGatewayHealthResponse> getAllGatewayHealth();

    /**
     * 모델 게이트웨이 메트릭 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/metrics")
    ModelGatewayMetricsResponse getGatewayMetrics(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String granularity
    );

    /**
     * 전체 게이트웨이 메트릭 조회
     */
    @GetMapping("/api/v1/model-gateway/metrics")
    List<ModelGatewayMetricsResponse> getAllGatewayMetrics(
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String granularity
    );

    /**
     * 게이트웨이 실시간 상태 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/status")
    Object getGatewayStatus(@PathVariable("gatewayId") String gatewayId);

    /**
     * 게이트웨이 알림 규칙 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/alerts")
    Object getGatewayAlerts(@PathVariable("gatewayId") String gatewayId);

    /**
     * 게이트웨이 로그 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/logs")
    Object getGatewayLogs(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) String level,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) Integer limit
    );

    /**
     * 게이트웨이 트레이싱 정보 조회
     */
    @GetMapping("/api/v1/model-gateway/{gatewayId}/traces")
    Object getGatewayTraces(
        @PathVariable("gatewayId") String gatewayId,
        @RequestParam(required = false) String traceId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate
    );
}
