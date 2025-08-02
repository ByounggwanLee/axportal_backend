package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Chunk Mode 열거형
 * 
 * <p>Knowledge 서비스에서 문서 분할 방식을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum ChunkMode {
    RECURSIVE_CHARACTER("RecursiveCharacter"),
    CHARACTER("Character"),
    SEMANTIC("Semantic"),
    CUSTOM_SPLITTER("CustomSplitter"),
    NOT_SPLIT("NotSplit");

    private final String value;

    ChunkMode(String value) {
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
