package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 서빙 타입 열거형
 * SKT AX Model API의 서빙 타입을 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum ServingTypeEnum {
    
    /**
     * 서버리스 서빙
     */
    SERVERLESS("serverless"),
    
    /**
     * 셀프 호스팅 서빙
     */
    SELF_HOSTING("self-hosting");
    
    private final String value;
    
    ServingTypeEnum(String value) {
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
