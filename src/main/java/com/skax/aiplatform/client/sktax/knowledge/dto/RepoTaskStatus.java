package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Repo Task 상태 Enum
 * OpenAPI 스키마: RepoTaskStatus
 */
public enum RepoTaskStatus {
    @JsonProperty("init")
    INIT("init"),

    @JsonProperty("registered")
    REGISTERED("registered"),

    @JsonProperty("collecting")
    COLLECTING("collecting"),

    @JsonProperty("started")
    STARTED("started"),

    @JsonProperty("stopped")
    STOPPED("stopped"),

    @JsonProperty("succeeded")
    SUCCEEDED("succeeded"),

    @JsonProperty("failed")
    FAILED("failed");

    private final String value;

    RepoTaskStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
