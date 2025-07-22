package com.skax.aiportal.client.sktai.agentgateway.dto.request;

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
public class AgentGatewayExecuteRequest {

    @JsonProperty("agent_name")
    private String agentName;

    @JsonProperty("conversation_id")
    private String conversationId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("message")
    private String message;

    @JsonProperty("context")
    private Map<String, Object> context;

    @JsonProperty("tools")
    private List<String> tools;

    @JsonProperty("parameters")
    private Map<String, Object> parameters;

    @JsonProperty("execution_mode")
    private String executionMode;

    @JsonProperty("timeout_ms")
    private Integer timeoutMs;

    @JsonProperty("streaming")
    private Boolean streaming;

    @JsonProperty("routing_key")
    private String routingKey;

    @JsonProperty("trace_id")
    private String traceId;

    @JsonProperty("session_config")
    private SessionConfig sessionConfig;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SessionConfig {

        @JsonProperty("session_id")
        private String sessionId;

        @JsonProperty("persist_conversation")
        private Boolean persistConversation;

        @JsonProperty("context_retention")
        private Boolean contextRetention;

        @JsonProperty("memory_scope")
        private String memoryScope;
    }
}
