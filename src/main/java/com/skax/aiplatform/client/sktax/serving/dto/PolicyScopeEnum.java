package com.skax.aiplatform.client.sktax.serving.dto;

/**
 * Policy Scope Enum
 * 정책 스코프를 정의하는 열거형입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum PolicyScopeEnum {
    /**
     * GET 요청
     */
    GET("GET"),

    /**
     * POST 요청
     */
    POST("POST"),

    /**
     * PUT 요청
     */
    PUT("PUT"),

    /**
     * DELETE 요청
     */
    DELETE("DELETE");

    private final String value;

    PolicyScopeEnum(String value) {
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
