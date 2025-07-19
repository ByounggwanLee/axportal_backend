package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 인증 토큰 응답 DTO
 * 
 * <p>액세스 토큰 발급 응답 정보를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "인증 토큰 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenResponse {

    /**
     * 액세스 토큰
     */
    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 리프레시 토큰
     */
    @Schema(description = "리프레시 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 토큰 타입
     */
    @Schema(description = "토큰 타입", example = "Bearer")
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 토큰 만료 시간 (초)
     */
    @Schema(description = "토큰 만료 시간 (초)", example = "3600")
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 스코프
     */
    @Schema(description = "토큰 스코프", example = "read write")
    @JsonProperty("scope")
    private String scope;

    /**
     * 토큰 발급 시간
     */
    @Schema(description = "토큰 발급 시간")
    @JsonProperty("issued_at")
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     */
    @Schema(description = "토큰 만료 시간")
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
}
