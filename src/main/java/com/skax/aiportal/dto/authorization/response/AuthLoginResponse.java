package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 인증 로그인 응답 DTO
 * 
 * <p>사용자 로그인 성공 시 반환하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginResponse {

    /**
     * 액세스 토큰
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 리프레시 토큰
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
     * 사용자 ID
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 사용자명
     */
    private String username;

    /**
     * 사용자 이메일
     */
    private String email;

    /**
     * 사용자 역할
     */
    private String role;

    /**
     * 로그인 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("login_time")
    private LocalDateTime loginTime;

    /**
     * 마지막 로그인 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("last_login_time")
    private LocalDateTime lastLoginTime;
}
