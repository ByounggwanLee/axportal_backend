package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 정책 로직 enum
 * OpenAPI 명세: {"type": "string", "enum": ["NEGATIVE", "POSITIVE"]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum PolicyLogic {
    /** 거부 로직 */
    NEGATIVE("NEGATIVE"),
    /** 허용 로직 */
    POSITIVE("POSITIVE");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
