package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Knowledge Action 열거형
 * 
 * <p>Knowledge 서비스에서 수행 가능한 작업을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum KnowledgeAction {
    LOADING_DOCS("loading_docs"),
    CHUNKING_DOCS("chunking_docs"),
    EMBEDDING_AND_INDEXING("embedding_and_indexing");

    private final String value;

    KnowledgeAction(String value) {
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
