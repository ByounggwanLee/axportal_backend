package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Evaluation API 응답 래퍼 클래스
 * Evaluation API의 모든 응답에서 사용되는 공통 응답 형식
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationResponse<T> {
    
    @JsonProperty("data")
    private T data;
    
    @JsonProperty("payload")
    private EvaluationPayloadResponse payload;
}
