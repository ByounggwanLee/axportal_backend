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
 * 시스템 로그인 요청 DTO
 * 
 * <p>시스템 간 인증을 위한 로그인 요청 정보를 담는 객체입니다.
 * 클라이언트 시크릿을 사용하여 시스템 레벨의 액세스 토큰을 발급받습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "시스템 로그인 요청",
    description = "시스템 간 인증을 위한 로그인 요청"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "clientSecret")
public class AuthSystemLoginRequest {

    /**
     * 클라이언트 시크릿
     * 
     * <p>시스템 인증을 위한 클라이언트 시크릿입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "클라이언트 시크릿",
        example = "your-client-secret-key",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password",
        maxLength = 255
    )
    @NotBlank(message = "클라이언트 시크릿은 필수입니다.")
    @Size(max = 255, message = "클라이언트 시크릿은 255자를 초과할 수 없습니다.")
    private String clientSecret;

    /**
     * 클라이언트명
     * 
     * <p>시스템을 식별하는 클라이언트명입니다.</p>
     */
    @Schema(
        description = "클라이언트명 (시스템 식별자)",
        example = "default",
        maxLength = 50,
        defaultValue = "default"
    )
    @Size(max = 50, message = "클라이언트명은 50자를 초과할 수 없습니다.")
    @Builder.Default
    private String clientName = "default";

    /**
     * Grant Type
     * 
     * <p>OAuth2 인증 방식을 지정합니다. 시스템 로그인에서는 "client_credentials"를 사용합니다.</p>
     */
    @Schema(
        description = "OAuth2 Grant Type",
        example = "client_credentials",
        allowableValues = {"client_credentials"},
        defaultValue = "client_credentials"
    )
    @Builder.Default
    private String grantType = "client_credentials";
}
