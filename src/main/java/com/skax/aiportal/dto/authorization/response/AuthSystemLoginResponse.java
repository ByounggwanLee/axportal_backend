package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 시스템 로그인 응답 DTO
 * 
 * <p>시스템 간 인증 완료 후 반환되는 토큰 정보를 담는 응답 객체입니다.
 * 클라이언트 자격 증명을 통한 시스템 레벨 액세스 토큰을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "시스템 로그인 응답",
    description = "시스템 간 인증 완료 후 토큰 정보 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "accessToken")
public class AuthSystemLoginResponse {

    /**
     * 액세스 토큰
     * 
     * <p>시스템 API 호출에 사용되는 액세스 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "시스템 API 호출용 액세스 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        format = "jwt"
    )
    private String accessToken;

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
        example = "7200",
        minimum = "1"
    )
    private Long expiresIn;

    /**
     * 권한 범위
     * 
     * <p>시스템에 부여된 권한의 범위를 나타냅니다.</p>
     */
    @Schema(
        description = "시스템에 부여된 권한 범위 (공백으로 구분)",
        example = "system:read system:write admin:manage"
    )
    private String scope;

    /**
     * 클라이언트 ID
     * 
     * <p>인증된 시스템 클라이언트의 식별자입니다.</p>
     */
    @Schema(
        description = "인증된 시스템 클라이언트 식별자",
        example = "system_client_123"
    )
    private String clientId;

    /**
     * 클라이언트명
     * 
     * <p>인증된 시스템 클라이언트의 이름입니다.</p>
     */
    @Schema(
        description = "인증된 시스템 클라이언트명",
        example = "AI Portal System"
    )
    private String clientName;

    /**
     * Grant Type
     * 
     * <p>사용된 OAuth2 인증 방식입니다.</p>
     */
    @Schema(
        description = "사용된 OAuth2 Grant Type",
        example = "client_credentials",
        defaultValue = "client_credentials"
    )
    @Builder.Default
    private String grantType = "client_credentials";

    /**
     * 발급자
     * 
     * <p>토큰을 발급한 인증 서버의 식별자입니다.</p>
     */
    @Schema(
        description = "토큰 발급자 (Issuer)",
        example = "https://auth.example.com",
        format = "uri"
    )
    private String issuer;

    /**
     * 대상 오디언스
     * 
     * <p>토큰의 대상 오디언스입니다.</p>
     */
    @Schema(
        description = "토큰 대상 오디언스",
        example = "https://api.example.com",
        format = "uri"
    )
    private String audience;

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
        example = "2025-07-23T12:30:00"
    )
    private LocalDateTime expiredAt;

    /**
     * JTI (JWT ID)
     * 
     * <p>JWT 토큰의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "JWT 토큰 고유 식별자",
        example = "jwt_id_123456"
    )
    private String jti;

    /**
     * 인증 성공 여부
     * 
     * <p>시스템 인증이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "시스템 인증 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>시스템 인증 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "시스템 인증 결과 메시지",
        example = "시스템 인증이 성공했습니다."
    )
    private String message;
}
