package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 유효성 검증 오류 DTO
 * 
 * <p>OpenAPI 스키마명: ValidationError</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "유효성 검증 오류")
public class ValidationError {

    @JsonProperty("loc")
    @Schema(description = "오류 위치", required = true)
    private List<Object> loc;

    @JsonProperty("msg")
    @Schema(description = "오류 메시지", required = true)
    private String msg;

    @JsonProperty("type")
    @Schema(description = "오류 타입", required = true)
    private String type;
}
