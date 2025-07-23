package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 액세스 토큰 응답 DTO
 * 
 * <p>SKT AI 인증 API의 기본 토큰 응답을 위한 DTO입니다.
 * OAuth2 표준에 따라 액세스 토큰, 리프레시 토큰 및 관련 메타데이터를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "액세스 토큰 응답",
    description = "SKT AI 플랫폼의 인증 성공 시 반환되는 토큰 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"}) // 보안상 토큰은 로그에서 제외
public class AccessTokenResponse {

    /**
     * 액세스 토큰
     * 
     * <p>API 호출 시 인증을 위해 사용되는 액세스 토큰입니다.</p>
     */
    @Schema(
        description = "API 인증용 액세스 토큰",
        example = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
        format = "jwt"
    )
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 만료 시간 (초)
     * 
     * <p>액세스 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "액세스 토큰 만료 시간 (초 단위)",
        example = "3600",
        minimum = "1"
    )
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * 리프레시 토큰
     * 
     * <p>액세스 토큰 갱신을 위해 사용되는 리프레시 토큰입니다.</p>
     */
    @Schema(
        description = "토큰 갱신용 리프레시 토큰",
        example = "def50200a1b2c3d4e5f6...",
        format = "jwt"
    )
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 리프레시 토큰 만료 시간 (초)
     * 
     * <p>리프레시 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "리프레시 토큰 만료 시간 (초 단위)",
        example = "86400",
        minimum = "1"
    )
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    /**
     * 토큰 타입 (예: Bearer)
     * 
     * <p>토큰의 타입을 나타냅니다. 일반적으로 'Bearer'입니다.</p>
     */
    @Schema(
        description = "토큰 타입",
        example = "Bearer",
        defaultValue = "Bearer",
        allowableValues = {"Bearer"}
    )
    @JsonProperty("token_type")
    private String tokenType;
}
