package com.skax.aiplatform.client.sktax.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 유효성 검증 오류 응답
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HTTPValidationError {

    /**
     * 유효성 검증 오류 상세 목록
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
