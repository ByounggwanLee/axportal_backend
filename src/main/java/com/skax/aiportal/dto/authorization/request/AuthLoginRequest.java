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
 * OAuth2 로그인 요청 DTO
 * 
 * <p>사용자 이름과 비밀번호를 사용한 OAuth2 패스워드 플로우 로그인 요청 정보를 담는 객체입니다.
 * SKT AI 플랫폼 인증을 위한 필수 정보들을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "OAuth2 로그인 요청",
    description = "OAuth2 패스워드 플로우를 통한 사용자 인증 요청"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class AuthLoginRequest {

    /**
     * 사용자명
     * 
     * <p>SKT AI 플랫폼에 등록된 사용자의 로그인 ID입니다.</p>
     */
    @Schema(
        description = "사용자명 (로그인 ID)",
        example = "john.doe",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 50
    )
    @NotBlank(message = "사용자명은 필수입니다.")
    @Size(max = 50, message = "사용자명은 50자를 초과할 수 없습니다.")
    private String username;

    /**
     * 비밀번호
     * 
     * <p>사용자의 로그인 비밀번호입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "사용자 비밀번호",
        example = "mySecretPassword123!",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password",
        minLength = 8,
        maxLength = 100
    )
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, max = 100, message = "비밀번호는 8자 이상 100자 이하여야 합니다.")
    private String password;

    /**
     * 클라이언트 ID
     * 
     * <p>OAuth2 클라이언트 식별자입니다.</p>
     */
    @Schema(
        description = "OAuth2 클라이언트 ID",
        example = "web-client",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "클라이언트 ID는 필수입니다.")
    @Size(max = 100, message = "클라이언트 ID는 100자를 초과할 수 없습니다.")
    private String clientId;

    /**
     * Grant Type
     * 
     * <p>OAuth2 인증 방식을 지정합니다. 일반적으로 "password"를 사용합니다.</p>
     */
    @Schema(
        description = "OAuth2 Grant Type",
        example = "password",
        allowableValues = {"password", "authorization_code", "client_credentials"},
        defaultValue = "password"
    )
    @Builder.Default
    private String grantType = "password";
}
