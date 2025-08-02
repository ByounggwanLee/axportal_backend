package com.skax.aiplatform.client.sktax.history.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTPValidationError
 * 
 * <p>HTTP 검증 오류 응답을 나타내는 DTO</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HTTPValidationError {

    /**
     * 상세 오류 정보 목록
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
