package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 평가 타입 enum
 * OpenAPI 명세: {"type": "integer", "enum": [1, 2, 3]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum EvaluationType {
    /** 기본 평가 타입 (1) */
    BASIC(1),
    /** 고급 평가 타입 (2) */
    ADVANCED(2),
    /** 사용자 정의 평가 타입 (3) */
    CUSTOM(3);

    private final int value;

    @JsonValue
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
