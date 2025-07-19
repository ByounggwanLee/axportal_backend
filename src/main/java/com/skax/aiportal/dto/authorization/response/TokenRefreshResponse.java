package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 토큰 갱신 응답 DTO
 * 
 * <p>토큰 갱신 성공 시 반환하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshResponse {

    /**
     * 새로운 액세스 토큰
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 새로운 리프레시 토큰
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 토큰 타입
     */
    @JsonProperty("token_type")
    @Builder.Default
    private String tokenType = "Bearer";

    /**
     * 토큰 만료 시간 (초)
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 토큰 발급 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("issued_at")
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
}
