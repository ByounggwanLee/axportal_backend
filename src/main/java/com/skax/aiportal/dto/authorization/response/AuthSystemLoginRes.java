package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 시스템 로그인 응답 DTO
 * 
 * <p>시스템 간 인증 성공 시 반환되는 토큰 정보를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "시스템 로그인 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthSystemLoginRes {

    /**
     * 시스템 액세스 토큰
     */
    @Schema(description = "시스템 액세스 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 타입
     */
    @Schema(description = "토큰 타입", example = "Bearer")
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 토큰 만료 시간 (초)
     */
    @Schema(description = "토큰 만료 시간(초)", example = "3600")
    @JsonProperty("expires_in")
    private Long expiresIn;
}
