package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 정책 타입 열거형
 * SKT AX Knowledge API의 정책 타입을 정의합니다.
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum PolicyType {
    
    /**
     * 사용자 기반 정책
     */
    USER("user"),
    
    /**
     * 그룹 기반 정책
     */
    GROUP("group"),
    
    /**
     * 역할 기반 정책
     */
    ROLE("role"),
    
    /**
     * 토큰 교환 기반 정책
     */
    TOKEN_EXCHANGE("token-exchange");
    
    private final String value;
    
    PolicyType(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
