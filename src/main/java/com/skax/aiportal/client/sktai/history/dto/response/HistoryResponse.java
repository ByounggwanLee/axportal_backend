package com.skax.aiportal.client.sktai.history.dto.response;

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
public class HistoryResponse {

    @JsonProperty("history_id")
    private String historyId;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("entity_id")
    private String entityId;

    @JsonProperty("entity_name")
    private String entityName;

    @JsonProperty("action_type")
    private String actionType;

    @JsonProperty("action_description")
    private String actionDescription;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("changes")
    private List<ChangeInfo> changes;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("request_details")
    private RequestDetails requestDetails;

    @JsonProperty("response_details")
    private ResponseDetails responseDetails;

    @JsonProperty("execution_info")
    private ExecutionInfo executionInfo;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("user_agent")
    private String userAgent;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChangeInfo {

        @JsonProperty("field_name")
        private String fieldName;

        @JsonProperty("old_value")
        private Object oldValue;

        @JsonProperty("new_value")
        private Object newValue;

        @JsonProperty("change_type")
        private String changeType;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDetails {

        @JsonProperty("method")
        private String method;

        @JsonProperty("endpoint")
        private String endpoint;

        @JsonProperty("headers")
        private Map<String, String> headers;

        @JsonProperty("query_params")
        private Map<String, String> queryParams;

        @JsonProperty("body_size")
        private Long bodySize;

        @JsonProperty("content_type")
        private String contentType;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDetails {

        @JsonProperty("status_code")
        private Integer statusCode;

        @JsonProperty("response_size")
        private Long responseSize;

        @JsonProperty("content_type")
        private String contentType;

        @JsonProperty("error_message")
        private String errorMessage;

        @JsonProperty("error_code")
        private String errorCode;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExecutionInfo {

        @JsonProperty("processing_time_ms")
        private Long processingTimeMs;

        @JsonProperty("retry_count")
        private Integer retryCount;

        @JsonProperty("success")
        private Boolean success;

        @JsonProperty("resource_usage")
        private Map<String, Object> resourceUsage;

        @JsonProperty("trace_id")
        private String traceId;
    }
}
