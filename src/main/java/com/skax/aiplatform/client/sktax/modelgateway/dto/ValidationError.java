package com.skax.aiplatform.client.sktax.modelgateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Validation Error DTO
 * 
 * <p>유효성 검사 오류를 위한 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "유효성 검사 오류 DTO")
public class ValidationError {

    /**
     * 오류 위치
     */
    @Schema(description = "오류가 발생한 위치", required = true)
    @JsonProperty("loc")
    @NotNull(message = "오류 위치는 필수입니다")
    private List<Object> loc;

    /**
     * 오류 메시지
     */
    @Schema(description = "오류 메시지", required = true)
    @JsonProperty("msg")
    @NotBlank(message = "오류 메시지는 필수입니다")
    private String msg;

    /**
     * 오류 타입
     */
    @Schema(description = "오류 타입", required = true)
    @JsonProperty("type")
    @NotBlank(message = "오류 타입은 필수입니다")
    private String type;
}
