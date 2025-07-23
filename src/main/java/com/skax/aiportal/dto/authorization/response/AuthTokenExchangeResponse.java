package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 토큰 교환 응답 DTO
 * 
 * <p>OAuth2 Token Exchange 완료 후 반환되는 응답 정보를 담는 객체입니다.
 * 기존 토큰을 새로운 형태의 토큰으로 교환한 결과를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "토큰 교환 응답",
    description = "OAuth2 Token Exchange 완료 후 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"})
public class AuthTokenExchangeResponse {

    /**
     * 교환된 액세스 토큰
     * 
     * <p>교환 결과로 발급된 새로운 액세스 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "교환된 새로운 액세스 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        format = "jwt"
    )
    private String accessToken;

    /**
     * 발급된 토큰 타입
     * 
     * <p>교환 결과로 발급된 토큰의 타입을 URN 형태로 나타냅니다.</p>
     */
    @Schema(
        description = "발급된 토큰 타입",
        example = "urn:ietf:params:oauth:token-type:access_token",
        allowableValues = {
            "urn:ietf:params:oauth:token-type:access_token",
            "urn:ietf:params:oauth:token-type:refresh_token",
            "urn:ietf:params:oauth:token-type:id_token",
            "urn:ietf:params:oauth:token-type:jwt"
        }
    )
    private String issuedTokenType;

    /**
     * Bearer 토큰 타입
     * 
     * <p>HTTP Authorization 헤더에서 사용할 토큰 타입입니다.</p>
     */
    @Schema(
        description = "Bearer 토큰 타입",
        example = "Bearer",
        defaultValue = "Bearer"
    )
    @Builder.Default
    private String tokenType = "Bearer";

    /**
     * 토큰 만료 시간 (초)
     * 
     * <p>교환된 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "교환된 토큰 만료 시간 (초)",
        example = "3600",
        minimum = "1"
    )
    private Long expiresIn;

    /**
     * 리프레시 토큰
     * 
     * <p>교환 결과로 발급된 리프레시 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "교환 결과로 발급된 리프레시 토큰 (선택사항)",
        example = "exchanged_refresh_token_example",
        format = "jwt"
    )
    private String refreshToken;

    /**
     * 권한 범위
     * 
     * <p>교환된 토큰의 권한 범위입니다.</p>
     */
    @Schema(
        description = "교환된 토큰의 권한 범위 (공백으로 구분)",
        example = "read write api:access"
    )
    private String scope;

    /**
     * 대상 오디언스
     * 
     * <p>교환된 토큰의 대상 오디언스입니다.</p>
     */
    @Schema(
        description = "교환된 토큰의 대상 오디언스",
        example = "https://api.example.com",
        format = "uri"
    )
    private String audience;

    /**
     * 주체 (Subject)
     * 
     * <p>교환된 토큰의 주체를 나타냅니다.</p>
     */
    @Schema(
        description = "교환된 토큰의 주체",
        example = "user123"
    )
    private String subject;

    /**
     * 대행자 (Actor)
     * 
     * <p>대리 인증이 있는 경우 대행자 정보입니다.</p>
     */
    @Schema(
        description = "대행자 정보 (선택사항)",
        example = "admin_user"
    )
    private String actor;

    /**
     * 클라이언트명
     * 
     * <p>토큰 교환을 요청한 클라이언트명입니다.</p>
     */
    @Schema(
        description = "토큰 교환 요청 클라이언트명",
        example = "default"
    )
    private String clientName;

    /**
     * 발급자
     * 
     * <p>교환된 토큰의 발급자입니다.</p>
     */
    @Schema(
        description = "교환된 토큰의 발급자",
        example = "https://auth.example.com",
        format = "uri"
    )
    private String issuer;

    /**
     * 토큰 발급 시간
     * 
     * <p>교환된 토큰이 발급된 시간입니다.</p>
     */
    @Schema(
        description = "교환된 토큰 발급 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     * 
     * <p>교환된 토큰이 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "교환된 토큰 만료 시간",
        example = "2025-07-23T11:30:00"
    )
    private LocalDateTime expiredAt;

    /**
     * JTI (JWT ID)
     * 
     * <p>교환된 JWT 토큰의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "교환된 JWT 토큰 고유 식별자",
        example = "exchanged_jwt_id_123456"
    )
    private String jti;

    /**
     * 원본 토큰 참조
     * 
     * <p>교환 전 원본 토큰의 참조 정보입니다.</p>
     */
    @Schema(
        description = "원본 토큰 참조 정보",
        example = "original_token_ref_123"
    )
    private String originalTokenReference;

    /**
     * 교환 성공 여부
     * 
     * <p>토큰 교환이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "토큰 교환 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>토큰 교환 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "토큰 교환 결과 메시지",
        example = "토큰이 성공적으로 교환되었습니다."
    )
    private String message;
}
