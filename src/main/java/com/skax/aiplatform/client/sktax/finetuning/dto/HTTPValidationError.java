package com.skax.aiplatform.client.sktax.finetuning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 검증 오류 DTO
 * Fine-tuning API의 HTTP 검증 오류를 정의합니다.
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
     * 오류 상세 목록
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
