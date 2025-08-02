package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 검증 오류
 * 
 * <p>Agent Gateway API 요청 시 발생하는 검증 오류 정보를 정의합니다.</p>
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
    @Schema(description = "오류 상세 정보 목록")
    private List<ValidationError> detail;
}
