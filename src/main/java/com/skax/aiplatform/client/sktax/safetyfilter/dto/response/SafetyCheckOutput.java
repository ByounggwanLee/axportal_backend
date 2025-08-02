package com.skax.aiplatform.client.sktax.safetyfilter.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 안전성 검사 결과 응답 DTO
 * 발화에 대한 유해성 판정 결과를 반환합니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SafetyCheckOutput {

    /**
     * 안전 여부
     */
    @JsonProperty("is_safe")
    private Boolean isSafe;

    /**
     * 리다이렉션 메시지
     */
    @JsonProperty("redirection_message")
    private String redirectionMessage;

    /**
     * 실행 시간
     */
    @JsonProperty("execution_time")
    private Double executionTime;

    /**
     * 금지어 목록
     */
    @JsonProperty("stopword")
    private List<Object> stopword; // 다양한 타입이 올 수 있음
}
