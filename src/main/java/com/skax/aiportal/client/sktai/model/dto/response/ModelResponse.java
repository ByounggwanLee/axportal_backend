package com.skax.aiportal.client.sktai.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model API 응답 래퍼 클래스
 * Model API의 모든 응답에서 사용되는 공통 응답 형식
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelResponse<T> {
    
    @JsonProperty("data")
    private T data;
    
    @JsonProperty("payload")
    private PayloadResponse payload;
}
