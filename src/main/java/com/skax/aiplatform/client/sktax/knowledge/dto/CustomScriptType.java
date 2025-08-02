package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Custom Script Type 열거형
 * 
 * <p>Knowledge 서비스에서 지원하는 커스텀 스크립트 유형을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum CustomScriptType {
    LOADER("loader"),
    SPLITTER("splitter");

    private final String value;

    CustomScriptType(String value) {
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
