package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.auth.dto.ValidationError;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 유효성 검증 오류 응답 DTO
 * 
 * <p>OpenAPI 스키마명: HTTPValidationError</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "HTTP 유효성 검증 오류")
public class HTTPValidationError {

    @JsonProperty("detail")
    @Schema(description = "오류 상세 정보")
    private List<ValidationError> detail;
}
