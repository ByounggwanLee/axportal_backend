package com.skax.aiportal.client.sktai.gateway.dto.request;

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
public class ModelGatewayInvokeRequest {

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("method")
    private String method;

    @JsonProperty("endpoint")
    private String endpoint;

    @JsonProperty("headers")
    private Map<String, String> headers;

    @JsonProperty("payload")
    private Object payload;

    @JsonProperty("timeout_ms")
    private Integer timeoutMs;

    @JsonProperty("retry_count")
    private Integer retryCount;

    @JsonProperty("routing_key")
    private String routingKey;

    @JsonProperty("trace_id")
    private String traceId;
}
