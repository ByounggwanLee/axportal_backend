package com.skax.aiplatform.dto.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 토큰 갱신 요청 DTO
 * 
 * <p>Access Token 갱신을 위한 요청 데이터를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "토큰 갱신 요청")
public class RefreshTokenReq {

    @NotBlank(message = "Refresh Token은 필수입니다")
    @Schema(description = "Refresh Token", example = "eyJhbGciOiJIUzUxMiJ9...")
    private String refreshToken;
}
