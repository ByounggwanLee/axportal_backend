package com.skax.aiportal.client.sktai.agentgateway.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * Agent Gateway 생성 요청 DTO
 * 
 * <p>SKT AI Agent Gateway를 생성하기 위한 요청 정보를 담는 객체입니다.
 * 게이트웨이 설정, 라우팅 규칙, 로드밸런싱, 보안 설정 등을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "Agent Gateway 생성 요청",
    description = "SKT AI Agent Gateway 생성을 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgentGatewayCreateRequest {

    /**
     * 게이트웨이 이름
     */
    @Schema(
        description = "게이트웨이 이름",
        example = "고객서비스 게이트웨이",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "게이트웨이 이름은 필수입니다.")
    @Size(max = 100, message = "게이트웨이 이름은 100자를 초과할 수 없습니다.")
    @JsonProperty("name")
    private String name;

    /**
     * 게이트웨이 설명
     */
    @Schema(
        description = "게이트웨이 설명",
        example = "고객 상담을 위한 AI Agent 게이트웨이",
        maxLength = 500
    )
    @Size(max = 500, message = "게이트웨이 설명은 500자를 초과할 수 없습니다.")
    @JsonProperty("description")
    private String description;

    /**
     * 게이트웨이 타입
     */
    @Schema(
        description = "게이트웨이 타입",
        example = "http",
        allowableValues = {"http", "websocket", "grpc"}
    )
    @JsonProperty("gateway_type")
    private String gatewayType;

    /**
     * 게이트웨이 설정
     */
    @Schema(
        description = "게이트웨이 기본 설정",
        implementation = GatewayConfig.class
    )
    @JsonProperty("config")
    private GatewayConfig config;

    /**
     * 라우팅 규칙 목록
     */
    @Schema(
        description = "요청을 라우팅하기 위한 규칙 목록",
        implementation = RoutingRule.class
    )
    @JsonProperty("routing_rules")
    private List<RoutingRule> routingRules;

    /**
     * 로드밸런싱 설정
     */
    @Schema(
        description = "로드밸런싱 설정",
        implementation = LoadBalancing.class
    )
    @JsonProperty("load_balancing")
    private LoadBalancing loadBalancing;

    /**
     * 속도 제한 설정
     */
    @Schema(
        description = "요청 속도 제한 설정",
        implementation = RateLimiting.class
    )
    @JsonProperty("rate_limiting")
    private RateLimiting rateLimiting;

    /**
     * 보안 설정
     */
    @Schema(
        description = "게이트웨이 보안 설정",
        implementation = SecurityConfig.class
    )
    @JsonProperty("security_config")
    private SecurityConfig securityConfig;

    /**
     * Agent 설정
     */
    @Schema(
        description = "연결될 Agent 설정",
        implementation = AgentConfig.class
    )
    @JsonProperty("agent_config")
    private AgentConfig agentConfig;

    /**
     * 워크플로우 설정
     */
    @Schema(
        description = "워크플로우 설정",
        implementation = WorkflowConfig.class
    )
    @JsonProperty("workflow_config")
    private WorkflowConfig workflowConfig;

    /**
     * 모니터링 설정
     */
    @Schema(
        description = "모니터링 및 로깅 설정",
        implementation = MonitoringConfig.class
    )
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

        @JsonProperty("session_management")
        private Boolean sessionManagement;
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

        @JsonProperty("target_agent")
        private String targetAgent;

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

        @JsonProperty("agent_pool_size")
        private Integer agentPoolSize;
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

        @JsonProperty("concurrent_sessions")
        private Integer concurrentSessions;
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

        @JsonProperty("user_isolation")
        private Boolean userIsolation;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AgentConfig {

        @JsonProperty("agent_execution_mode")
        private String agentExecutionMode;

        @JsonProperty("context_sharing")
        private Boolean contextSharing;

        @JsonProperty("memory_management")
        private String memoryManagement;

        @JsonProperty("tool_access_control")
        private Map<String, Boolean> toolAccessControl;

        @JsonProperty("conversation_timeout")
        private Integer conversationTimeout;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WorkflowConfig {

        @JsonProperty("workflow_enabled")
        private Boolean workflowEnabled;

        @JsonProperty("parallel_execution")
        private Boolean parallelExecution;

        @JsonProperty("error_handling_strategy")
        private String errorHandlingStrategy;

        @JsonProperty("result_aggregation")
        private String resultAggregation;
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

        @JsonProperty("conversation_logging")
        private Boolean conversationLogging;

        @JsonProperty("alert_rules")
        private List<String> alertRules;
    }
}
