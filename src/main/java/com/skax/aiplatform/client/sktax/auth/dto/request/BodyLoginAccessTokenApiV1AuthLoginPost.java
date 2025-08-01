package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 액세스 토큰 요청 Body DTO
 * 
 * <p>OAuth2 Password Grant 방식을 사용한 로그인 요청 데이터를 전송합니다.</p>
 * <p>OpenAPI 스키마명: Body_login_access_token_api_v1_auth_login_post</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 액세스 토큰 요청 Body")
public class BodyLoginAccessTokenApiV1AuthLoginPost {

    @NotBlank(message = "Grant type은 필수입니다")
    @JsonProperty("grant_type")
    @Schema(description = "Grant 타입", pattern = "password", required = true)
    @Builder.Default
    private String grantType = "password";

    @NotBlank(message = "사용자명은 필수입니다")
    @JsonProperty("username")
    @Schema(description = "사용자명", required = true)
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다")
    @JsonProperty("password")
    @Schema(description = "비밀번호", required = true)
    private String password;

    @JsonProperty("scope")
    @Schema(description = "접근 범위", defaultValue = "")
    @Builder.Default
    private String scope = "";

    @JsonProperty("client_id")
    @Schema(description = "클라이언트 ID", defaultValue = "default")
    @Builder.Default
    private String clientId = "default";

    @JsonProperty("client_secret")
    @Schema(description = "클라이언트 시크릿")
    private String clientSecret;
}
