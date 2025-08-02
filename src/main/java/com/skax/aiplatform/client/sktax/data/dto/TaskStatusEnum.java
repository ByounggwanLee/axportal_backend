package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 태스크 상태 열거형
 * 
 * <p>데이터소스 태스크의 상태를 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum TaskStatusEnum {
    /**
     * 대기 중
     */
    PENDING("pending"),
    
    /**
     * 진행 중
     */
    IN_PROGRESS("in_progress"),
    
    /**
     * 완료
     */
    COMPLETED("completed"),
    
    /**
     * 실패
     */
    FAILED("failed");

    private final String value;

    TaskStatusEnum(String value) {
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
