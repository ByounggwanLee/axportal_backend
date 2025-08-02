package com.skax.aiplatform.client.sktax.knowledge.dto;

/**
 * Knowledge 업데이트 모드 Enum
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum KnowledgeUpdateMode {
    /**
     * 수정된 문서 추가
     */
    APPEND_MODIFIED_DOCS("append_modified_docs"),

    /**
     * 새 컬렉션 추가
     */
    ADD_NEW_COLLECTION("add_new_collection");

    private final String value;

    KnowledgeUpdateMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
