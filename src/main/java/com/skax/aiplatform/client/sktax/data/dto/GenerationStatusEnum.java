package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 생성 상태 열거형
 * 
 * <p>데이터 생성 작업의 상태를 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
public enum GenerationStatusEnum {

    /**
     * 초기화 상태
     */
    INITIALIZED("initialized"),

    /**
     * 시작 중 상태
     */
    STARTING("starting"),

    /**
     * 시작됨 상태
     */
    STARTED("started"),

    /**
     * 중지 중 상태
     */
    STOPPING("stopping"),

    /**
     * 중지됨 상태
     */
    STOPPED("stopped"),

    /**
     * 오류 상태
     */
    ERROR("error"),

    /**
     * 완료 상태
     */
    COMPLETED("completed");

    private final String value;

    GenerationStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
