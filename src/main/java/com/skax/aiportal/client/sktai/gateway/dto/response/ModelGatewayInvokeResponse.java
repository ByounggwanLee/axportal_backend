package com.skax.aiportal.client.sktai.gateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelGatewayInvokeResponse {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("gateway_id")
    private String gatewayId;

    @JsonProperty("target_endpoint")
    private String targetEndpoint;

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("response_headers")
    private Map<String, String> responseHeaders;

    @JsonProperty("response_body")
    private Object responseBody;

    @JsonProperty("processing_time_ms")
    private Long processingTimeMs;

    @JsonProperty("routing_info")
    private RoutingInfo routingInfo;

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
    public static class RoutingInfo {

        @JsonProperty("rule_id")
        private String ruleId;

        @JsonProperty("rule_condition")
        private String ruleCondition;

        @JsonProperty("load_balancing_algorithm")
        private String loadBalancingAlgorithm;

        @JsonProperty("retry_count")
        private Integer retryCount;
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
    }
}
