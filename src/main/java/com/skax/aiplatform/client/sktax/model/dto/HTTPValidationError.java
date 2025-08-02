package com.skax.aiplatform.client.sktax.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 검증 오류 DTO
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
     * 검증 오류 상세 정보
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
