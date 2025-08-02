package com.skax.aiplatform.client.sktax.agentgateway.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentInput;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * Agent Gateway Invoke 요청 스키마
 * 
 * <p>Invoke Request Schema for Swagger documentation.
 * This schema is for documentation purposes only.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Invoke Request Schema for Swagger documentation. This schema is for documentation purposes only.",
    example = "{\"config\":{},\"input\":{\"additional_kwargs\":{\"additional1\":\"value\"},\"messages\":[{\"content\":\"hello\",\"type\":\"human\"}]},\"kwargs\":{}}"
)
public class InvokeRequestSchema {

    /**
     * 설정 정보
     */
    @JsonProperty("config")
    @Schema(description = "Agent 설정 정보", example = "{}")
    private Map<String, Object> config;

    /**
     * 입력 데이터
     */
    @JsonProperty("input")
    @Valid
    @Schema(description = "Agent 입력 데이터")
    private AgentInput input;

    /**
     * 추가 키워드 인수
     */
    @JsonProperty("kwargs")
    @Schema(description = "추가 키워드 인수", example = "{}")
    private Map<String, Object> kwargs;

    /**
     * 추가 속성 지원 (OpenAPI additionalProperties: true)
     */
    @Builder.Default
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
