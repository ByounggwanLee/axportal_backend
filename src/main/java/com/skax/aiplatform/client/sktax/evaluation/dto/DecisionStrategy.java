package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 결정 전략 enum
 * OpenAPI 명세: {"type": "string", "enum": ["AFFIRMATIVE", "CONSENSUS", "UNANIMOUS"]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum DecisionStrategy {
    /** 긍정적 결정 전략 */
    AFFIRMATIVE("AFFIRMATIVE"),
    /** 합의 결정 전략 */
    CONSENSUS("CONSENSUS"),
    /** 만장일치 결정 전략 */
    UNANIMOUS("UNANIMOUS");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
