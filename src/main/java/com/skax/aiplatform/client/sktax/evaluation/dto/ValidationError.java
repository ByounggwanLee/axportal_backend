package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 유효성 검증 오류 정보
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {

    /**
     * 오류 위치
     */
    @JsonProperty("loc")
    private List<Object> location;

    /**
     * 오류 메시지
     */
    @JsonProperty("msg")
    private String message;

    /**
     * 오류 타입
     */
    @JsonProperty("type")
    private String type;
}
