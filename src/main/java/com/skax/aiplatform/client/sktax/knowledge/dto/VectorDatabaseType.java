package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Vector Database Type 열거형
 * 
 * <p>Knowledge 서비스에서 지원하는 벡터 데이터베이스 유형을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum VectorDatabaseType {
    MILVUS("Milvus"),
    AZURE_AI_SEARCH("AzureAISearch"),
    AZURE_AI_SEARCH_SHARED("AzureAISearchShared"),
    OPENSEARCH("OpenSearch");

    private final String value;

    VectorDatabaseType(String value) {
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
