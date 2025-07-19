package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 데이터셋 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 데이터셋 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum DatasetTypeEnum {

    /**
     * 비지도 파인튜닝
     */
    UNSUPERVISED_FINETUNING("unsupervised_finetuning", "비지도 파인튜닝"),

    /**
     * 지도 파인튜닝
     */
    SUPERVISED_FINETUNING("supervised_finetuning", "지도 파인튜닝"),

    /**
     * 모델 벤치마크
     */
    MODEL_BENCHMARK("model_benchmark", "모델 벤치마크"),

    /**
     * RAG 평가
     */
    RAG_EVALUATION("rag_evaluation", "RAG 평가");

    private final String code;
    private final String description;

    /**
     * 코드로 DatasetTypeEnum을 찾습니다.
     * 
     * @param code 데이터셋 타입 코드
     * @return DatasetTypeEnum
     */
    public static DatasetTypeEnum fromCode(String code) {
        for (DatasetTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown dataset type code: " + code);
    }
}
