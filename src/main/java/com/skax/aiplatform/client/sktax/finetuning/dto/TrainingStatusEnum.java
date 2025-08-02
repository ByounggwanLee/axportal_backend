package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Training 상태 열거형
 * 훈련의 상태를 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum TrainingStatusEnum {
    
    /**
     * 초기화됨
     */
    INITIALIZED("initialized"),
    
    /**
     * 시작 중
     */
    STARTING("starting"),
    
    /**
     * 중지 중
     */
    STOPPING("stopping"),
    
    /**
     * 중지됨
     */
    STOPPED("stopped"),
    
    /**
     * 리소스 할당 중
     */
    RESOURCE_ALLOCATING("resource-allocating"),
    
    /**
     * 리소스 할당됨
     */
    RESOURCE_ALLOCATED("resource-allocated"),
    
    /**
     * 훈련 중
     */
    TRAINING("training"),
    
    /**
     * 훈련 완료
     */
    TRAINED("trained"),
    
    /**
     * 오류
     */
    ERROR("error");
    
    private final String value;
    
    TrainingStatusEnum(String value) {
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
