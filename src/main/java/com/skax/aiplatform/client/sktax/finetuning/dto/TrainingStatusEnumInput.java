package com.skax.aiplatform.client.sktax.finetuning.dto;

/**
 * 훈련 상태 열거형 (입력용)
 * OpenAPI 명세의 TrainingStatusEnum-Input에 해당합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum TrainingStatusEnumInput {
    
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

    TrainingStatusEnumInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
