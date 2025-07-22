package com.skax.aiportal.client.sktai.gateway.dto.request;

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
public class ModelGatewayUpdateRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("config")
    private GatewayConfig config;

    @JsonProperty("routing_rules")
    private List<RoutingRule> routingRules;

    @JsonProperty("load_balancing")
    private LoadBalancing loadBalancing;

    @JsonProperty("rate_limiting")
    private RateLimiting rateLimiting;

    @JsonProperty("security_config")
    private SecurityConfig securityConfig;

    @JsonProperty("monitoring_config")
    private MonitoringConfig monitoringConfig;

    @JsonProperty("enabled")
    private Boolean enabled;

    @JsonProperty("tags")
    private List<String> tags;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GatewayConfig {

        @JsonProperty("timeout_ms")
        private Integer timeoutMs;

        @JsonProperty("retry_count")
        private Integer retryCount;

        @JsonProperty("circuit_breaker_enabled")
        private Boolean circuitBreakerEnabled;

        @JsonProperty("health_check_interval")
        private Integer healthCheckInterval;

        @JsonProperty("custom_headers")
        private Map<String, String> customHeaders;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutingRule {

        @JsonProperty("rule_id")
        private String ruleId;

        @JsonProperty("condition")
        private String condition;

        @JsonProperty("target_endpoint")
        private String targetEndpoint;

        @JsonProperty("weight")
        private Integer weight;

        @JsonProperty("priority")
        private Integer priority;

        @JsonProperty("enabled")
        private Boolean enabled;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoadBalancing {

        @JsonProperty("algorithm")
        private String algorithm;

        @JsonProperty("health_check_enabled")
        private Boolean healthCheckEnabled;

        @JsonProperty("failover_enabled")
        private Boolean failoverEnabled;

        @JsonProperty("sticky_session")
        private Boolean stickySession;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateLimiting {

        @JsonProperty("enabled")
        private Boolean enabled;

        @JsonProperty("requests_per_minute")
        private Integer requestsPerMinute;

        @JsonProperty("burst_size")
        private Integer burstSize;

        @JsonProperty("key_strategy")
        private String keyStrategy;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SecurityConfig {

        @JsonProperty("authentication_required")
        private Boolean authenticationRequired;

        @JsonProperty("api_key_validation")
        private Boolean apiKeyValidation;

        @JsonProperty("cors_enabled")
        private Boolean corsEnabled;

        @JsonProperty("allowed_origins")
        private List<String> allowedOrigins;

        @JsonProperty("ssl_required")
        private Boolean sslRequired;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonitoringConfig {

        @JsonProperty("metrics_enabled")
        private Boolean metricsEnabled;

        @JsonProperty("logging_enabled")
        private Boolean loggingEnabled;

        @JsonProperty("tracing_enabled")
        private Boolean tracingEnabled;

        @JsonProperty("alert_rules")
        private List<String> alertRules;
    }
}
