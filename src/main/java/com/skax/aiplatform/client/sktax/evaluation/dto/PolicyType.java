package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 정책 타입 enum
 * OpenAPI 명세: {"type": "string", "enum": ["user", "group", "role", "token-exchange"]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum PolicyType {
    /** 사용자 정책 */
    USER("user"),
    /** 그룹 정책 */
    GROUP("group"),
    /** 역할 정책 */
    ROLE("role"),
    /** 토큰 교환 정책 */
    TOKEN_EXCHANGE("token-exchange");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
