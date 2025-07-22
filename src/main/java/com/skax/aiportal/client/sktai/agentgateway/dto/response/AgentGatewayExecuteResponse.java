package com.skax.aiportal.client.sktai.agentgateway.dto.response;

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
public class AgentGatewayExecuteResponse {

    @JsonProperty("execution_id")
    private String executionId;

    @JsonProperty("conversation_id")
    private String conversationId;

    @JsonProperty("gateway_id")
    private String gatewayId;

    @JsonProperty("agent_name")
    private String agentName;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("response")
    private String response;

    @JsonProperty("status")
    private String status;

    @JsonProperty("execution_info")
    private ExecutionInfo executionInfo;

    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;

    @JsonProperty("context")
    private Map<String, Object> context;

    @JsonProperty("metadata")
    private ExecutionMetadata metadata;

    @JsonProperty("error_info")
    private ErrorInfo errorInfo;

    @JsonProperty("trace_id")
    private String traceId;

    @JsonProperty("timestamp")
    private String timestamp;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExecutionInfo {

        @JsonProperty("execution_mode")
        private String executionMode;

        @JsonProperty("processing_time_ms")
        private Long processingTimeMs;

        @JsonProperty("routing_info")
        private RoutingInfo routingInfo;

        @JsonProperty("retry_count")
        private Integer retryCount;

        @JsonProperty("session_id")
        private String sessionId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutingInfo {

        @JsonProperty("rule_id")
        private String ruleId;

        @JsonProperty("rule_condition")
        private String ruleCondition;

        @JsonProperty("target_agent")
        private String targetAgent;

        @JsonProperty("load_balancing_algorithm")
        private String loadBalancingAlgorithm;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ToolCall {

        @JsonProperty("tool_name")
        private String toolName;

        @JsonProperty("tool_input")
        private Map<String, Object> toolInput;

        @JsonProperty("tool_output")
        private Object toolOutput;

        @JsonProperty("execution_time_ms")
        private Long executionTimeMs;

        @JsonProperty("status")
        private String status;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExecutionMetadata {

        @JsonProperty("model_used")
        private String modelUsed;

        @JsonProperty("tokens_consumed")
        private Integer tokensConsumed;

        @JsonProperty("conversation_length")
        private Integer conversationLength;

        @JsonProperty("agent_version")
        private String agentVersion;

        @JsonProperty("execution_cost")
        private Double executionCost;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorInfo {

        @JsonProperty("error_code")
        private String errorCode;

        @JsonProperty("error_message")
        private String errorMessage;

        @JsonProperty("error_type")
        private String errorType;

        @JsonProperty("retry_attempted")
        private Boolean retryAttempted;

        @JsonProperty("recovery_suggestion")
        private String recoverySuggestion;
    }
}
