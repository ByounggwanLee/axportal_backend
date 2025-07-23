package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * OAuth2 로그인 응답 DTO
 * 
 * <p>OAuth2 인증 성공 후 반환되는 토큰 정보를 담는 응답 객체입니다.
 * 사용자 인증이 완료된 후 액세스 토큰과 관련 정보를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "OAuth2 로그인 응답",
    description = "OAuth2 인증 성공 후 토큰 정보 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"})
public class AuthLoginResponse {

    /**
     * 액세스 토큰
     * 
     * <p>API 호출에 사용되는 액세스 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "API 호출용 액세스 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        format = "jwt"
    )
    private String accessToken;

    /**
     * 리프레시 토큰
     * 
     * <p>액세스 토큰 갱신용 리프레시 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "토큰 갱신용 리프레시 토큰",
        example = "refresh_token_example",
        format = "jwt"
    )
    private String refreshToken;

    /**
     * 토큰 타입
     * 
     * <p>토큰의 타입입니다. 일반적으로 "Bearer"입니다.</p>
     */
    @Schema(
        description = "토큰 타입",
        example = "Bearer",
        defaultValue = "Bearer"
    )
    @Builder.Default
    private String tokenType = "Bearer";

    /**
     * 토큰 만료 시간 (초)
     * 
     * <p>액세스 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "액세스 토큰 만료 시간 (초)",
        example = "3600",
        minimum = "1"
    )
    private Long expiresIn;

    /**
     * 권한 범위
     * 
     * <p>부여된 권한의 범위를 나타냅니다.</p>
     */
    @Schema(
        description = "부여된 권한 범위 (공백으로 구분)",
        example = "read write user:profile"
    )
    private String scope;

    /**
     * 사용자 ID
     * 
     * <p>인증된 사용자의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "인증된 사용자의 고유 식별자",
        example = "user123"
    )
    private String userId;

    /**
     * 사용자명
     * 
     * <p>인증된 사용자의 이름입니다.</p>
     */
    @Schema(
        description = "인증된 사용자명",
        example = "홍길동"
    )
    private String username;

    /**
     * 사용자 이메일
     * 
     * <p>인증된 사용자의 이메일 주소입니다.</p>
     */
    @Schema(
        description = "인증된 사용자의 이메일 주소",
        example = "user@example.com",
        format = "email"
    )
    private String email;

    /**
     * 토큰 발급 시간
     * 
     * <p>토큰이 발급된 시간입니다.</p>
     */
    @Schema(
        description = "토큰 발급 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     * 
     * <p>액세스 토큰이 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "액세스 토큰 만료 시간",
        example = "2025-07-23T11:30:00"
    )
    private LocalDateTime expiredAt;

    /**
     * 인증 성공 여부
     * 
     * <p>인증이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "인증 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>인증 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "인증 결과 메시지",
        example = "로그인이 성공했습니다."
    )
    private String message;
}
