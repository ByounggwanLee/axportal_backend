package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * SSO 로그인 응답 DTO
 * 
 * <p>SSO(Single Sign-On) 인증 프로세스 시작 후 반환되는 응답 정보를 담는 객체입니다.
 * 클라이언트를 SSO 인증 페이지로 리다이렉트하기 위한 정보를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "SSO 로그인 응답",
    description = "SSO 인증 프로세스 시작 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthSsoLoginResponse {

    /**
     * SSO 인증 URL
     * 
     * <p>사용자를 리다이렉트할 SSO 인증 페이지 URL입니다.</p>
     */
    @Schema(
        description = "SSO 인증 페이지 URL",
        example = "https://sso.example.com/auth?client_id=123&redirect_uri=...",
        format = "uri"
    )
    private String authorizationUrl;

    /**
     * 상태값
     * 
     * <p>CSRF 공격 방지를 위한 상태값입니다. 콜백 시 검증에 사용됩니다.</p>
     */
    @Schema(
        description = "CSRF 방지용 상태값",
        example = "abc123def456"
    )
    private String state;

    /**
     * 세션 타임아웃 (초)
     * 
     * <p>SSO 인증 세션의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "SSO 세션 타임아웃 (초)",
        example = "1800",
        minimum = "1"
    )
    private Long sessionTimeout;

    /**
     * 클라이언트 ID
     * 
     * <p>SSO 인증에 사용되는 클라이언트 식별자입니다.</p>
     */
    @Schema(
        description = "SSO 클라이언트 식별자",
        example = "sso-client-123"
    )
    private String clientId;

    /**
     * 요청 범위
     * 
     * <p>SSO 인증에서 요청하는 권한 범위입니다.</p>
     */
    @Schema(
        description = "요청 권한 범위 (공백으로 구분)",
        example = "openid profile email"
    )
    private String scope;

    /**
     * 응답 타입
     * 
     * <p>OAuth2 응답 타입입니다. 일반적으로 "code"입니다.</p>
     */
    @Schema(
        description = "OAuth2 응답 타입",
        example = "code",
        defaultValue = "code"
    )
    @Builder.Default
    private String responseType = "code";

    /**
     * 리다이렉트 URI
     * 
     * <p>SSO 인증 완료 후 콜백받을 URI입니다.</p>
     */
    @Schema(
        description = "인증 완료 후 콜백 URI",
        example = "https://app.example.com/auth/callback",
        format = "uri"
    )
    private String redirectUri;

    /**
     * 요청 생성 시간
     * 
     * <p>SSO 인증 요청이 생성된 시간입니다.</p>
     */
    @Schema(
        description = "SSO 인증 요청 생성 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime createdAt;

    /**
     * 만료 시간
     * 
     * <p>SSO 인증 요청이 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "SSO 인증 요청 만료 시간",
        example = "2025-07-23T11:00:00"
    )
    private LocalDateTime expiredAt;

    /**
     * 성공 여부
     * 
     * <p>SSO 인증 요청 생성이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "SSO 인증 요청 생성 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>SSO 인증 요청 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "SSO 인증 요청 결과 메시지",
        example = "SSO 인증 페이지로 리다이렉트해주세요."
    )
    private String message;
}
