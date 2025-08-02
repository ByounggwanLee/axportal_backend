package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 평가 상태 enum
 * OpenAPI 명세: {"type": "integer", "enum": [0, 1, 2]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum EvaluationStatus {
    /** 대기 상태 (0) */
    PENDING(0),
    /** 실행 중 (1) */
    RUNNING(1),
    /** 완료 상태 (2) */
    COMPLETED(2);

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
