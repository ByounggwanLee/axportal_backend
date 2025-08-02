package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 프로세서 타입 열거형
 * 
 * <p>데이터 프로세서의 타입을 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
public enum ProcessorTypeEnum {

    /**
     * 기본 프로세서
     */
    DEFAULT("default"),

    /**
     * 규칙 기반 프로세서
     */
    RULE("rule"),

    /**
     * 코드 기반 프로세서
     */
    CODE("code");

    private final String value;

    ProcessorTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
