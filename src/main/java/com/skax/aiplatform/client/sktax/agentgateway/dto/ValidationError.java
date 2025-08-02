package com.skax.aiplatform.client.sktax.agentgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 검증 오류
 * 
 * <p>개별 필드의 검증 오류 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "검증 오류")
public class ValidationError {

    /**
     * 오류 위치
     */
    @JsonProperty("loc")
    @NotNull
    @Schema(description = "오류 위치")
    private List<Object> loc;

    /**
     * 오류 메시지
     */
    @JsonProperty("msg")
    @NotBlank
    @Schema(description = "오류 메시지")
    private String msg;

    /**
     * 오류 타입
     */
    @JsonProperty("type")
    @NotBlank
    @Schema(description = "오류 타입")
    private String type;
}
