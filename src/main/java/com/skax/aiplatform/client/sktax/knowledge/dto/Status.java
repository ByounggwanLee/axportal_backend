package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Status 열거형
 * 
 * <p>Knowledge 서비스에서 작업 상태를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum Status {
    NONE("NONE"),
    PROCESSING("PROCESSING"),
    COMPLETE("COMPLETE"),
    ERROR("ERROR"),
    STOP_REQUESTED("STOP_REQUESTED"),
    CANCELED("CANCELED"),
    PURGED("PURGED");

    private final String value;

    Status(String value) {
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
