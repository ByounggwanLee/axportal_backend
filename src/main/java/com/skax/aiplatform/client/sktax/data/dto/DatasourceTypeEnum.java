package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 데이터소스 타입 열거형
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
public enum DatasourceTypeEnum {
    /**
     * 파일
     */
    FILE("file"),
    
    /**
     * 데이터베이스
     */
    DATABASE("database"),
    
    /**
     * S3
     */
    S3("s3");

    private final String value;

    DatasourceTypeEnum(String value) {
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
