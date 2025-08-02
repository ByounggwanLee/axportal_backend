package com.skax.aiplatform.client.sktax.knowledge.dto;

/**
 * Repository 저장소 스코프 Enum
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum RepoStorage {
    /**
     * 공개 저장소
     */
    PUBLIC("public"),

    /**
     * 비공개 저장소
     */
    PRIVATE("private");

    private final String value;

    RepoStorage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
