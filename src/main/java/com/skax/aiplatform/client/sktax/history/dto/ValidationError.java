package com.skax.aiplatform.client.sktax.history.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ValidationError
 * 
 * <p>개별 검증 오류 정보를 나타내는 DTO</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationError {

    /**
     * 오류 위치 정보 (문자열 또는 정수의 배열)
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
