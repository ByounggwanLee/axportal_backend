package com.skax.aiplatform.client.sktax.resource.dto.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceDetail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Namespace List 응답
 * 
 * <p>Namespace 목록 조회 결과를 포함합니다.
 * OpenAPI에서 additionalProperties: true로 정의된 유연한 응답 구조입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Namespace List 응답", additionalProperties = Schema.AdditionalPropertiesValue.TRUE)
public class NamespaceListRes {

    /**
     * Namespace 데이터
     */
    @JsonProperty("data")
    @Valid
    @Schema(description = "Namespace 상세 정보")
    private NamespaceDetail data;

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
