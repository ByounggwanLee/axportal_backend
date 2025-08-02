package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 태스크 타입 열거형
 * 
 * <p>데이터소스 태스크의 타입을 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum TaskTypeEnum {
    /**
     * 파일 생성
     */
    FILE_CREATE("file_create"),
    
    /**
     * 파일 업데이트
     */
    FILE_UPDATE("file_update"),
    
    /**
     * S3 생성
     */
    S3_CREATE("s3_create"),
    
    /**
     * S3 업데이트
     */
    S3_UPDATE("s3_update");

    private final String value;

    TaskTypeEnum(String value) {
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
