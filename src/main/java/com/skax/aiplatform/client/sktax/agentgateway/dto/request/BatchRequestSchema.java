package com.skax.aiplatform.client.sktax.agentgateway.dto.request;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentConfig;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentInput;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Gateway Batch 요청 스키마
 * 
 * <p>Batch Request Schema for Swagger documentation.
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
    description = "Batch Request Schema for Swagger documentation. This schema is for documentation purposes only.",
    example = "{\"config\":[{\"configurable\":{},\"metadata\":{},\"recursion_limit\":25,\"tags\":[]},{\"configurable\":{},\"metadata\":{},\"recursion_limit\":25,\"tags\":[]}],\"inputs\":[{\"messages\":[{\"content\":\"뉴진스의 새 이름은??\",\"type\":\"human\"}]},{\"messages\":[{\"content\":\"한국을 영어로 하면?\",\"type\":\"human\"}]}],\"kwargs\":{}}"
)
public class BatchRequestSchema {

    /**
     * 설정 정보 목록
     */
    @JsonProperty("config")
    @Valid
    @Schema(description = "Agent 설정 정보 목록")
    private List<AgentConfig> config;

    /**
     * 입력 데이터 목록
     */
    @JsonProperty("inputs")
    @Valid
    @Schema(description = "Agent 입력 데이터 목록")
    private List<AgentInput> inputs;

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
