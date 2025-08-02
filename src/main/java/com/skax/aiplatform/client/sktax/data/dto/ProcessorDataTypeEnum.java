package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 프로세서 데이터 타입 열거형
 * 
 * <p>데이터 프로세서가 처리하는 데이터 타입을 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
public enum ProcessorDataTypeEnum {

    /**
     * 데이터프레임 타입
     */
    DATAFRAME("dataframe"),

    /**
     * 텍스트 데이터
     */
    TEXT("text"),

    /**
     * 모든 데이터 타입
     */
    ALL("all");

    private final String value;

    ProcessorDataTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
