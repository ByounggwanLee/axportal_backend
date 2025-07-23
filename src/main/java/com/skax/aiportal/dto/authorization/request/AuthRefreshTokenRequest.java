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
 * 토큰 갱신 요청 DTO
 * 
 * <p>리프레시 토큰을 사용하여 새로운 액세스 토큰을 발급받는 요청 정보를 담는 객체입니다.
 * 액세스 토큰이 만료되었을 때 인증을 유지하기 위해 사용됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "토큰 갱신 요청",
    description = "리프레시 토큰을 사용한 액세스 토큰 갱신 요청"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "refreshToken")
public class AuthRefreshTokenRequest {

    /**
     * 리프레시 토큰
     * 
     * <p>새로운 액세스 토큰을 발급받기 위한 리프레시 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "액세스 토큰 갱신용 리프레시 토큰",
        example = "refresh_token_example",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "jwt"
    )
    @NotBlank(message = "리프레시 토큰은 필수입니다.")
    @Size(max = 2048, message = "리프레시 토큰은 2048자를 초과할 수 없습니다.")
    private String refreshToken;

    /**
     * 클라이언트명
     * 
     * <p>토큰 갱신을 요청하는 클라이언트를 식별하는 이름입니다.</p>
     */
    @Schema(
        description = "클라이언트명 (토큰 갱신 요청 시스템 식별자)",
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
     * <p>OAuth2 인증 방식을 지정합니다. 토큰 갱신에서는 "refresh_token"을 사용합니다.</p>
     */
    @Schema(
        description = "OAuth2 Grant Type",
        example = "refresh_token",
        allowableValues = {"refresh_token"},
        defaultValue = "refresh_token"
    )
    @Builder.Default
    private String grantType = "refresh_token";

    /**
     * 스코프
     * 
     * <p>요청하는 권한 범위입니다. 원래 토큰의 스코프와 같거나 더 제한적이어야 합니다.</p>
     */
    @Schema(
        description = "요청할 권한 범위 (공백으로 구분)",
        example = "read write",
        maxLength = 255
    )
    @Size(max = 255, message = "스코프는 255자를 초과할 수 없습니다.")
    private String scope;
}
