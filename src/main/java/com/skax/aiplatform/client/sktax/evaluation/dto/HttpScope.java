package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * HTTP 스코프 enum
 * OpenAPI 명세: {"type": "string", "enum": ["GET", "POST", "PUT", "DELETE"]}
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum HttpScope {
    /** GET 메서드 */
    GET("GET"),
    /** POST 메서드 */
    POST("POST"),
    /** PUT 메서드 */
    PUT("PUT"),
    /** DELETE 메서드 */
    DELETE("DELETE");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
