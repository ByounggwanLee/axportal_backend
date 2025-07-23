package com.skax.aiportal.dto.authorization.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 로그아웃 요청 DTO
 * 
 * <p>현재 세션을 종료하고 인증 토큰을 무효화하는 로그아웃 요청 정보를 담는 객체입니다.
 * Access Token과 Refresh Token을 모두 무효화합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "로그아웃 요청",
    description = "현재 세션 종료 및 토큰 무효화 요청"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"})
public class AuthLogoutRequest {

    /**
     * 액세스 토큰
     * 
     * <p>현재 인증 세션의 액세스 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "무효화할 액세스 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "jwt"
    )
    @NotBlank(message = "액세스 토큰은 필수입니다.")
    @Size(max = 2048, message = "액세스 토큰은 2048자를 초과할 수 없습니다.")
    private String accessToken;

    /**
     * 리프레시 토큰
     * 
     * <p>토큰 갱신용 리프레시 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "무효화할 리프레시 토큰",
        example = "refresh_token_example",
        format = "jwt"
    )
    @Size(max = 2048, message = "리프레시 토큰은 2048자를 초과할 수 없습니다.")
    private String refreshToken;

    /**
     * 클라이언트명
     * 
     * <p>로그아웃을 요청하는 클라이언트를 식별하는 이름입니다.</p>
     */
    @Schema(
        description = "클라이언트명 (로그아웃 요청 시스템 식별자)",
        example = "default",
        maxLength = 50,
        defaultValue = "default"
    )
    @Size(max = 50, message = "클라이언트명은 50자를 초과할 수 없습니다.")
    @Builder.Default
    private String clientName = "default";

    /**
     * 로그아웃 후 리다이렉트 URL
     * 
     * <p>로그아웃 완료 후 사용자를 리다이렉트할 URL입니다.</p>
     */
    @Schema(
        description = "로그아웃 후 리다이렉트할 URL",
        example = "https://example.com/logout-success",
        format = "uri"
    )
    @Size(max = 500, message = "리다이렉트 URL은 500자를 초과할 수 없습니다.")
    private String redirectUri;
}
