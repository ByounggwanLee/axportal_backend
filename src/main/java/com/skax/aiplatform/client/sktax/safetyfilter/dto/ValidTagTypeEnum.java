package com.skax.aiplatform.client.sktax.safetyfilter.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 유효 태그 타입 열거형
 * Safety Filter의 태그 매칭 방식을 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum ValidTagTypeEnum {
    
    /**
     * 모든 형태소 매칭
     */
    ALL("ALL"),
    
    /**
     * 명사만 매칭
     */
    NN("NN");
    
    private final String value;
    
    ValidTagTypeEnum(String value) {
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
