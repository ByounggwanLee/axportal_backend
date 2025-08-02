package com.skax.aiplatform.client.sktax.resource.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 검증 오류 정보
 * 
 * <p>API 요청 검증 시 발생하는 오류 상세 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "검증 오류 정보")
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
    @NotNull
    @Schema(description = "오류 메시지")
    private String msg;

    /**
     * 오류 타입
     */
    @JsonProperty("type")
    @NotNull
    @Schema(description = "오류 타입")
    private String type;
}
