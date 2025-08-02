package com.skax.aiplatform.client.sktax.serving.dto.request;

/**
 * Serving Type Enum
 * 서빙 타입을 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum ServingTypeEnum {
    /**
     * 독립형 서빙
     */
    STANDALONE("standalone"),

    /**
     * 공유형 서빙
     */
    SHARED("shared");

    private final String value;

    ServingTypeEnum(String value) {
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
