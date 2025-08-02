package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Vector DB 정보 DTO
 * OpenAPI 스키마: VectorDBInfo
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VectorDBInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private VectorDatabaseType type;

    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;
}
