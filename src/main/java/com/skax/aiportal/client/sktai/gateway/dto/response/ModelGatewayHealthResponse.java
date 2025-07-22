package com.skax.aiportal.client.sktai.gateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelGatewayHealthResponse {

    @JsonProperty("gateway_id")
    private String gatewayId;

    @JsonProperty("overall_status")
    private String overallStatus;

    @JsonProperty("health_checks")
    private List<HealthCheck> healthChecks;

    @JsonProperty("uptime_seconds")
    private Long uptimeSeconds;

    @JsonProperty("last_check_time")
    private String lastCheckTime;

    @JsonProperty("next_check_time")
    private String nextCheckTime;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HealthCheck {

        @JsonProperty("endpoint")
        private String endpoint;

        @JsonProperty("status")
        private String status;

        @JsonProperty("response_time_ms")
        private Long responseTimeMs;

        @JsonProperty("error_message")
        private String errorMessage;

        @JsonProperty("last_success_time")
        private String lastSuccessTime;

        @JsonProperty("consecutive_failures")
        private Integer consecutiveFailures;
    }
}
