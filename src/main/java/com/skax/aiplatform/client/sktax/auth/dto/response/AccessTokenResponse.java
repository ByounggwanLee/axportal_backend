package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 액세스 토큰 응답 DTO
 * 
 * <p>OpenAPI 스키마명: AccessTokenResponse</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "액세스 토큰 응답")
public class AccessTokenResponse {

    @JsonProperty("access_token")
    @Schema(description = "액세스 토큰", required = true)
    private String accessToken;

    @JsonProperty("expires_in")
    @Schema(description = "토큰 만료 시간(초)", required = true)
    private Integer expiresIn;

    @JsonProperty("refresh_token")
    @Schema(description = "리프레시 토큰", required = true)
    private String refreshToken;

    @JsonProperty("refresh_expires_in")
    @Schema(description = "리프레시 토큰 만료 시간(초)", required = true)
    private Integer refreshExpiresIn;

    @JsonProperty("token_type")
    @Schema(description = "토큰 타입", required = true)
    private String tokenType;
}
