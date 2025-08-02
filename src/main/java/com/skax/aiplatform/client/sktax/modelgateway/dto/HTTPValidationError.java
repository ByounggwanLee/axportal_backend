package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP Validation Error DTO
 * 
 * <p>HTTP 유효성 검사 오류를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "HTTP 유효성 검사 오류 DTO")
public class HTTPValidationError {

    /**
     * 오류 상세 정보
     */
    @Schema(description = "유효성 검사 오류 상세 정보 목록")
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
