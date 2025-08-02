package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Retrieval Mode 열거형
 * 
 * <p>Knowledge 서비스에서 검색 모드를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum RetrievalMode {
    DENSE("dense"),
    SPARSE("sparse"),
    HYBRID("hybrid"),
    SEMANTIC("semantic");

    private final String value;

    RetrievalMode(String value) {
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
