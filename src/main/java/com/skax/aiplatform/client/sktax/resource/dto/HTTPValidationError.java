package com.skax.aiplatform.client.sktax.resource.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * HTTP 검증 오류
 * 
 * <p>HTTP 요청 검증 시 발생하는 오류 응답을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "HTTP 검증 오류")
public class HTTPValidationError {

    /**
     * 오류 상세 정보 목록
     */
    @JsonProperty("detail")
    @Valid
    @Schema(description = "오류 상세 정보 목록")
    private List<ValidationError> detail;
}
