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
 * 리프레시 토큰 요청 DTO
 * 
 * <p>만료된 액세스 토큰을 리프레시 토큰으로 갱신하기 위한 요청 정보를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "리프레시 토큰 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRefreshTokenReq {

    /**
     * 리프레시 토큰
     */
    @Schema(description = "리프레시 토큰", example = "로그인에서 획득한 RefrashToken을 복사해서 넣으세요", maxLength = 1000)
    @NotBlank(message = "리프레시 토큰은 필수입니다")
    @Size(max = 1000, message = "리프레시 토큰은 1000자 이하여야 합니다")
    @JsonProperty("refresh_token")
    private String refreshToken;
}
