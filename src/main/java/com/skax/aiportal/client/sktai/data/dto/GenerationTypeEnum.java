package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 생성 타입 열거형
 * 
 * <p>SKT AI 플랫폼의 생성 작업 타입을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum GenerationTypeEnum {

    /**
     * 오픈북 QnA
     */
    OPENBOOK_QNA("openbook_qna", "오픈북 QnA"),

    /**
     * RAG QnA
     */
    RAG_QNA("rag_qna", "RAG QnA"),

    /**
     * 의도 분류
     */
    INTENT_CLASSIFICATION("intent_classification", "의도 분류"),

    /**
     * CS 타입 분류
     */
    CS_TYPE_CLASSIFICATION("cs_type_classification", "CS 타입 분류"),

    /**
     * 감정 분류
     */
    EMOTION_CLASSIFICATION("emotion_classification", "감정 분류"),

    /**
     * CS 요약
     */
    CS_SUMMARIZATION("cs_summarization", "CS 요약"),

    /**
     * 키워드
     */
    KEYWORD("keyword", "키워드");

    private final String code;
    private final String description;

    /**
     * 코드로 GenerationTypeEnum을 찾습니다.
     * 
     * @param code 생성 타입 코드
     * @return GenerationTypeEnum
     */
    public static GenerationTypeEnum fromCode(String code) {
        for (GenerationTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown generation type code: " + code);
    }
}
