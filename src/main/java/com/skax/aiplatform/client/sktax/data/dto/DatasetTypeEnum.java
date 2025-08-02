package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 데이터셋 타입 열거형
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
public enum DatasetTypeEnum {
    /**
     * 비지도 파인튜닝
     */
    UNSUPERVISED_FINETUNING("unsupervised_finetuning"),
    
    /**
     * 지도 파인튜닝
     */
    SUPERVISED_FINETUNING("supervised_finetuning"),
    
    /**
     * 모델 벤치마크
     */
    MODEL_BENCHMARK("model_benchmark"),
    
    /**
     * RAG 평가
     */
    RAG_EVALUATION("rag_evaluation");

    private final String value;

    DatasetTypeEnum(String value) {
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
