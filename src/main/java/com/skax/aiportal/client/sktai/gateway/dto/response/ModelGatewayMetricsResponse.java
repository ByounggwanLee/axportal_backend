package com.skax.aiportal.client.sktai.gateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelGatewayMetricsResponse {

    @JsonProperty("gateway_id")
    private String gatewayId;

    @JsonProperty("period_start")
    private String periodStart;

    @JsonProperty("period_end")
    private String periodEnd;

    @JsonProperty("total_requests")
    private Long totalRequests;

    @JsonProperty("successful_requests")
    private Long successfulRequests;

    @JsonProperty("failed_requests")
    private Long failedRequests;

    @JsonProperty("success_rate")
    private Double successRate;

    @JsonProperty("avg_response_time_ms")
    private Double avgResponseTimeMs;

    @JsonProperty("min_response_time_ms")
    private Long minResponseTimeMs;

    @JsonProperty("max_response_time_ms")
    private Long maxResponseTimeMs;

    @JsonProperty("p95_response_time_ms")
    private Double p95ResponseTimeMs;

    @JsonProperty("p99_response_time_ms")
    private Double p99ResponseTimeMs;

    @JsonProperty("throughput_rps")
    private Double throughputRps;

    @JsonProperty("error_breakdown")
    private Map<String, Long> errorBreakdown;

    @JsonProperty("endpoint_metrics")
    private List<EndpointMetric> endpointMetrics;

    @JsonProperty("time_series_data")
    private List<TimeSeriesPoint> timeSeriesData;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EndpointMetric {

        @JsonProperty("endpoint")
        private String endpoint;

        @JsonProperty("request_count")
        private Long requestCount;

        @JsonProperty("avg_response_time_ms")
        private Double avgResponseTimeMs;

        @JsonProperty("error_count")
        private Long errorCount;

        @JsonProperty("error_rate")
        private Double errorRate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeSeriesPoint {

        @JsonProperty("timestamp")
        private String timestamp;

        @JsonProperty("request_count")
        private Long requestCount;

        @JsonProperty("avg_response_time_ms")
        private Double avgResponseTimeMs;

        @JsonProperty("error_count")
        private Long errorCount;
    }
}
