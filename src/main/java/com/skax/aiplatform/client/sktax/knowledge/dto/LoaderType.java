package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Loader Type 열거형
 * 
 * <p>Knowledge 서비스에서 지원하는 문서 로더 유형을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum LoaderType {
    DEFAULT("Default"),
    DATA_INGESTION_TOOL("DataIngestionTool"),
    CUSTOM_LOADER("CustomLoader");

    private final String value;

    LoaderType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
