package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 생성 태스크 타입 열거형
 * 
 * <p>데이터 생성 태스크의 타입을 정의하는 열거형입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
public enum GenerationTypeEnum {

    /**
     * 오픈북 QnA 타입
     */
    OPENBOOK_QNA("openbook_qna"),

    /**
     * RAG QnA 타입
     */
    RAG_QNA("rag_qna"),

    /**
     * 의도 분류 타입
     */
    INTENT_CLASSIFICATION("intent_classification"),

    /**
     * CS 타입 분류
     */
    CS_TYPE_CLASSIFICATION("cs_type_classification"),

    /**
     * 감정 분류 타입
     */
    EMOTION_CLASSIFICATION("emotion_classification"),

    /**
     * CS 요약 타입
     */
    CS_SUMMARIZATION("cs_summarization"),

    /**
     * 키워드 타입
     */
    KEYWORD("keyword");

    private final String value;

    GenerationTypeEnum(String value) {
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
