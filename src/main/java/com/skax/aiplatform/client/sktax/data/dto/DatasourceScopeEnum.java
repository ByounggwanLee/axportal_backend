package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 데이터소스 스코프 열거형
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
public enum DatasourceScopeEnum {
    /**
     * 공개
     */
    PUBLIC("public"),
    
    /**
     * 비공개
     */
    PRIVATE("private");

    private final String value;

    DatasourceScopeEnum(String value) {
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
