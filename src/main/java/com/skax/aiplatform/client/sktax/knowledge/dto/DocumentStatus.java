package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 문서 상태 Enum
 * OpenAPI 스키마: DocumentStatus
 */
public enum DocumentStatus {
    @JsonProperty("init")
    INIT("init"),

    @JsonProperty("loaded")
    LOADED("loaded"),

    @JsonProperty("chunked")
    CHUNKED("chunked"),

    @JsonProperty("embedded")
    EMBEDDED("embedded"),

    @JsonProperty("deleted")
    DELETED("deleted");

    private final String value;

    DocumentStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
