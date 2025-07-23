package com.skax.aiportal.client.sktai.authorization.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 로그인 응답 DTO
 * 
 * <p>SKT AI 플랫폼의 로그인 성공 시 반환되는 응답 정보를 담는 객체입니다.
 * 액세스 토큰, 리프레시 토큰, 토큰 메타데이터 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "로그인 응답",
    description = "SKT AI 플랫폼의 로그인 성공 시 반환되는 토큰 정보"
)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"accessToken", "refreshToken"}) // 보안상 토큰은 로그에서 제외
public class LoginResponse {
    
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
    private String accessToken;
    
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
    private String refreshToken;
    
    /**
     * 토큰 타입
     * 
     * <p>토큰의 타입을 나타냅니다. 일반적으로 'Bearer'입니다.</p>
     */
    @Schema(
        description = "토큰 타입",
        example = "Bearer",
        defaultValue = "Bearer",
        allowableValues = {"Bearer"}
    )
    private String tokenType;
    
    /**
     * 토큰 만료 시간
     * 
     * <p>액세스 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "액세스 토큰 만료 시간 (초 단위)",
        example = "3600",
        minimum = "1"
    )
    private Long expiresIn;
    
    /**
     * 토큰 스코프
     * 
     * <p>토큰의 접근 범위를 나타냅니다.</p>
     */
    @Schema(
        description = "토큰 접근 스코프",
        example = "read write",
        maxLength = 200
    )
    private String scope;
}
