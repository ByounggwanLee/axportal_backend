package com.skax.aiportal.client.sktai.gateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * Model Gateway 생성 요청 DTO
 * 
 * <p>SKT AI Gateway 플랫폼에서 모델 게이트웨이를 생성하기 위한 요청 정보를 담는 객체입니다.
 * 라우팅 규칙, 로드 밸런싱, 보안 설정 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "Model Gateway 생성 요청",
    description = "SKT AI Gateway 플랫폼에서 모델 게이트웨이를 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModelGatewayCreateRequest {

    /**
     * 게이트웨이 이름
     * 
     * <p>생성할 모델 게이트웨이의 이름입니다.</p>
     */
    @Schema(
        description = "게이트웨이 이름",
        example = "AI 모델 라우터",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "게이트웨이 이름은 필수입니다.")
    @Size(max = 100, message = "게이트웨이 이름은 100자를 초과할 수 없습니다.")
    @JsonProperty("name")
    private String name;

    /**
     * 게이트웨이 설명
     * 
     * <p>게이트웨이의 용도와 기능에 대한 설명입니다.</p>
     */
    @Schema(
        description = "게이트웨이 설명",
        example = "다중 AI 모델에 대한 로드 밸런싱 게이트웨이",
        maxLength = 500
    )
    @Size(max = 500, message = "게이트웨이 설명은 500자를 초과할 수 없습니다.")
    @JsonProperty("description")
    private String description;

    /**
     * 게이트웨이 타입
     * 
     * <p>게이트웨이의 종류를 나타냅니다.</p>
     */
    @Schema(
        description = "게이트웨이 타입",
        example = "HTTP_PROXY",
        allowableValues = {"HTTP_PROXY", "TCP_PROXY", "LOAD_BALANCER"}
    )
    @JsonProperty("gateway_type")
    private String gatewayType;

    /**
     * 게이트웨이 설정
     * 
     * <p>게이트웨이의 기본 설정 정보입니다.</p>
     */
    @Schema(description = "게이트웨이 기본 설정")
    @Valid
    @JsonProperty("config")
    private GatewayConfig config;

    /**
     * 라우팅 규칙 목록
     * 
     * <p>요청을 적절한 모델로 라우팅하기 위한 규칙들입니다.</p>
     */
    @Schema(description = "라우팅 규칙 목록")
    @Valid
    @JsonProperty("routing_rules")
    private List<RoutingRule> routingRules;

    /**
     * 로드 밸런싱 설정
     * 
     * <p>다중 모델 인스턴스 간의 로드 밸런싱 설정입니다.</p>
     */
    @Schema(description = "로드 밸런싱 설정")
    @Valid
    @JsonProperty("load_balancing")
    private LoadBalancing loadBalancing;

    /**
     * 요청 제한 설정
     * 
     * <p>API 호출 빈도를 제한하는 설정입니다.</p>
     */
    @Schema(description = "요청 제한 설정")
    @Valid
    @JsonProperty("rate_limiting")
    private RateLimiting rateLimiting;

    /**
     * 보안 설정
     * 
     * <p>인증, 인가 등 보안 관련 설정입니다.</p>
     */
    @Schema(description = "보안 설정")
    @Valid
    @JsonProperty("security_config")
    private SecurityConfig securityConfig;

    /**
     * 모니터링 설정
     * 
     * <p>게이트웨이 모니터링 및 로깅 설정입니다.</p>
     */
    @Schema(description = "모니터링 설정")
    @Valid
    @JsonProperty("monitoring_config")
    private MonitoringConfig monitoringConfig;

    /**
     * 활성화 여부
     * 
     * <p>게이트웨이의 활성화 상태입니다.</p>
     */
    @Schema(
        description = "게이트웨이 활성화 여부",
        example = "true",
        defaultValue = "true"
    )
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * 태그 목록
     * 
     * <p>게이트웨이 분류 및 관리를 위한 태그들입니다.</p>
     */
    @Schema(
        description = "게이트웨이 태그 목록",
        example = "[\"production\", \"ai-model\", \"load-balancer\"]"
    )
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
