package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Training Metric 타입 열거형
 * 훈련 메트릭의 타입을 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum TrainingMetricTypeEnum {
    
    /**
     * 훈련
     */
    TRAIN("train"),
    
    /**
     * 평가
     */
    EVALUATION("evaluation"),
    
    /**
     * DPO
     */
    DPO("dpo");
    
    private final String value;
    
    TrainingMetricTypeEnum(String value) {
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
