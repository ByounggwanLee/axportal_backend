package com.skax.aiplatform.dto.auth.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * JWT 토큰 응답 DTO
 * 
 * <p>JWT 토큰 정보를 담는 응답 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "JWT 토큰 응답")
public class JwtTokenRes {

    @Schema(description = "토큰 타입", example = "Bearer")
    @JsonProperty("token_type")
    private String tokenType;

    @Schema(description = "Access Token", example = "eyJhbGciOiJIUzUxMiJ9...")
    @JsonProperty("access_token")
    private String accessToken;

    @Schema(description = "Refresh Token", example = "eyJhbGciOiJIUzUxMiJ9...")
    @JsonProperty("refresh_token")
    private String refreshToken;

    @Schema(description = "Access Token 만료 시간 (초)", example = "3600")
    @JsonProperty("expires_in")
    private Long expiresIn;

    @Schema(description = "토큰 발급 시간", example = "2025-08-01T16:30:00")
    @JsonProperty("issued_at")
    private LocalDateTime issuedAt;

    @Schema(description = "Access Token 만료 시간", example = "2025-08-01T17:30:00")
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;

    /**
     * JWT 토큰 응답 생성
     * 
     * @param accessToken Access Token
     * @param refreshToken Refresh Token
     * @param expiresInMillis Access Token 만료 시간 (밀리초)
     * @return JwtTokenRes
     */
    public static JwtTokenRes of(String accessToken, String refreshToken, long expiresInMillis) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiresAt = now.plusSeconds(expiresInMillis / 1000);
        
        return JwtTokenRes.builder()
                .tokenType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresIn(expiresInMillis / 1000)
                .issuedAt(now)
                .expiresAt(expiresAt)
                .build();
    }
}
