package com.skax.aiplatform.client.sktax.serving.dto;

/**
 * Decision Strategy Enum
 * 의사결정 전략을 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum DecisionStrategyEnum {
    /**
     * 긍정적 전략 (하나라도 승인되면 통과)
     */
    AFFIRMATIVE("AFFIRMATIVE"),

    /**
     * 합의 전략 (과반수 승인)
     */
    CONSENSUS("CONSENSUS"),

    /**
     * 만장일치 전략 (모두 승인)
     */
    UNANIMOUS("UNANIMOUS");

    private final String value;

    DecisionStrategyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
