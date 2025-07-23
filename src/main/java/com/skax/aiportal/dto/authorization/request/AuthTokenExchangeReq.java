package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 토큰 교환 요청 DTO
 * 
 * <p>현재 토큰을 다른 클라이언트용 토큰으로 교환하기 위한 요청 정보를 담는 DTO입니다.
 * 마이크로서비스 간 토큰 전달 시 사용됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "토큰 교환 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthTokenExchangeReq {

    /**
     * 교환할 대상 클라이언트 이름
     */
    @Schema(description = "교환할 대상 클라이언트 이름", example = "mobile-app", maxLength = 100)
    @NotBlank(message = "교환할 대상 클라이언트 이름은 필수입니다")
    @Size(max = 100, message = "교환할 대상 클라이언트 이름은 100자 이하여야 합니다")
    @JsonProperty("to_exchange_client_name")
    private String toExchangeClientName;
}