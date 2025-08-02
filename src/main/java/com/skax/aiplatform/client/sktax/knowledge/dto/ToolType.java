package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tool Type 열거형
 * 
 * <p>Knowledge 서비스에서 지원하는 도구 유형을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public enum ToolType {
    
    /**
     * Azure Document Intelligence
     */
    AZURE_DOCUMENT_INTELLIGENCE("AzureDocumentIntelligence"),
    
    /**
     * Naver OCR
     */
    NAVER_OCR("NaverOCR"),
    
    /**
     * Docling
     */
    DOCLING("Docling"),
    
    /**
     * Synapsoft DA
     */
    SYNAPSOFT_DA("SynapsoftDA"),
    
    /**
     * VLM OCR
     */
    VLM_OCR("VLMOCR");

    private final String value;

    ToolType(String value) {
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
