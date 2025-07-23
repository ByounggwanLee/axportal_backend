package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * OAuth2 패스워드 로그인 요청 DTO
 * 
 * <p>SKT AI 인증 API의 OAuth2 패스워드 플로우 로그인 요청을 위한 DTO입니다.
 * OAuth2 표준에 따라 grant_type, username, password 등의 필드를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "OAuth2 패스워드 로그인 요청",
    description = "SKT AI 플랫폼의 OAuth2 패스워드 플로우 인증을 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password", "clientSecret"}) // 보안상 민감한 정보는 로그에서 제외
public class OAuth2LoginRequest {

    /**
     * Grant 타입 (고정값: password)
     * 
     * <p>OAuth2 패스워드 플로우를 위한 고정값입니다.</p>
     */
    @Schema(
        description = "OAuth2 Grant 타입",
        example = "password",
        defaultValue = "password",
        requiredMode = Schema.RequiredMode.REQUIRED,
        allowableValues = {"password"}
    )
    @JsonProperty("grant_type")
    @Builder.Default
    private String grantType = "password";

    /**
     * 사용자명
     * 
     * <p>SKT AI 플랫폼에 등록된 사용자의 로그인 아이디입니다.</p>
     */
    @Schema(
        description = "사용자명 (로그인 ID)",
        example = "user@example.com",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "사용자명은 필수입니다.")
    private String username;

    /**
     * 비밀번호
     * 
     * <p>사용자 계정의 패스워드입니다. 보안상 로그에 기록되지 않습니다.</p>
     */
    @Schema(
        description = "사용자 패스워드",
        example = "password123!",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password",
        minLength = 8,
        maxLength = 50
    )
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    /**
     * 스코프
     * 
     * <p>OAuth2 인증 스코프입니다. 기본값은 빈 문자열입니다.</p>
     */
    @Schema(
        description = "OAuth2 인증 스코프",
        example = "",
        defaultValue = ""
    )
    @Builder.Default
    private String scope = "";

    /**
     * 클라이언트 ID (프로젝트명)
     * 
     * <p>인증을 요청하는 클라이언트의 식별자입니다.</p>
     */
    @Schema(
        description = "클라이언트 ID (프로젝트명)",
        example = "default",
        defaultValue = "default",
        maxLength = 50
    )
    @JsonProperty("client_id")
    @Builder.Default
    private String clientId = "default";

    /**
     * 클라이언트 시크릿
     * 
     * <p>클라이언트 인증을 위한 시크릿 키입니다. 보안상 로그에 기록되지 않습니다.</p>
     */
    @Schema(
        description = "클라이언트 시크릿",
        example = "client-secret-key",
        format = "password",
        maxLength = 255
    )
    @JsonProperty("client_secret")
    private String clientSecret;
}
