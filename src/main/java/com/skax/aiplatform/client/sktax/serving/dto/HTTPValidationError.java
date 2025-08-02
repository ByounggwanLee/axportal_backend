package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP Validation Error DTO
 * HTTP 검증 오류 정보를 나타내는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HTTPValidationError {

    /**
     * 오류 상세 정보 목록
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
