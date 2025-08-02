package com.skax.aiplatform.client.sktax.serving.dto;

/**
 * Policy Type Enum
 * 정책 타입을 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum PolicyTypeEnum {
    /**
     * 사용자 정책
     */
    USER("user"),

    /**
     * 그룹 정책
     */
    GROUP("group"),

    /**
     * 역할 정책
     */
    ROLE("role"),

    /**
     * 토큰 교환 정책
     */
    TOKEN_EXCHANGE("token-exchange");

    private final String value;

    PolicyTypeEnum(String value) {
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
