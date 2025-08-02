package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Repo Task 타입 Enum
 * OpenAPI 스키마: RepoTaskType
 */
public enum RepoTaskType {
    @JsonProperty("DOCUMENT_INDEXING")
    DOCUMENT_INDEXING("DOCUMENT_INDEXING"),

    @JsonProperty("REPO_INDEXING")
    REPO_INDEXING("REPO_INDEXING"),

    @JsonProperty("COLLECT_AND_UPDATE")
    COLLECT_AND_UPDATE("COLLECT_AND_UPDATE");

    private final String value;

    RepoTaskType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
