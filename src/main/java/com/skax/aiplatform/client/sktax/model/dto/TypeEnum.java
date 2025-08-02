package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 모델 타입 열거형
 * SKT AX Model API의 모델 타입을 정의합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public enum TypeEnum {
    
    /**
     * 언어 모델
     */
    LANGUAGE("language"),
    
    /**
     * 임베딩 모델
     */
    EMBEDDING("embedding"),
    
    /**
     * 이미지 모델
     */
    IMAGE("image"),
    
    /**
     * 멀티모달 모델
     */
    MULTIMODAL("multimodal"),
    
    /**
     * 리랭크 모델
     */
    RERANKER("reranker"),
    
    /**
     * STT (Speech to Text) 모델
     */
    STT("stt"),
    
    /**
     * TTS (Text to Speech) 모델
     */
    TTS("tts"),
    
    /**
     * 오디오 모델
     */
    AUDIO("audio"),
    
    /**
     * 코드 모델
     */
    CODE("code"),
    
    /**
     * 비전 모델
     */
    VISION("vision"),
    
    /**
     * 비디오 모델
     */
    VIDEO("video");
    
    private final String value;
    
    TypeEnum(String value) {
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
