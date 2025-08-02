package com.skax.aiplatform.client.sktax.serving.dto;

/**
 * Policy Logic Enum
 * 정책 로직을 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum PolicyLogicEnum {
    /**
     * 부정 로직
     */
    NEGATIVE("NEGATIVE"),

    /**
     * 긍정 로직
     */
    POSITIVE("POSITIVE");

    private final String value;

    PolicyLogicEnum(String value) {
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
