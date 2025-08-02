package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OpenAPI 명세: HTTPValidationError
 * HTTP 검증 오류
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HTTPValidationError {

    @JsonProperty("detail")
    private List<ValidationError> detail;
}
