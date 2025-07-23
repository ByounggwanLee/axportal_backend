package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * OAuth2 로그인 요청 DTO
 * 
 * <p>OAuth2 패스워드 플로우를 사용한 로그인 요청 정보를 담는 DTO입니다.
 * 사용자명, 비밀번호, 클라이언트 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "OAuth2 로그인 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password") // 보안상 패스워드는 로그에서 제외
public class AuthLoginReq {

    /**
     * 사용자명
     */
    @Schema(description = "사용자명", example = "admin", maxLength = 100)
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(max = 100, message = "사용자명은 100자 이하여야 합니다")
    @JsonProperty("username")
    private String username;

    /**
     * 비밀번호
     */
    @Schema(description = "비밀번호", example = "aisnb", maxLength = 200)
    @NotBlank(message = "비밀번호는 필수입니다")
    @Size(max = 200, message = "비밀번호는 200자 이하여야 합니다")
    @JsonProperty("password")
    private String password;

    /**
     * 클라이언트 ID
     */
    @Schema(description = "클라이언트 ID", example = "default", maxLength = 100)
    @NotBlank(message = "클라이언트 ID는 필수입니다")
    @Size(max = 100, message = "클라이언트 ID는 100자 이하여야 합니다")
    @JsonProperty("client_id")
    private String clientId;

    /**
     * 인증 방식 (항상 "password")
     */
    @Schema(description = "인증 방식", example = "password", allowableValues = {"password"})
    @NotBlank(message = "인증 방식은 필수입니다")
    @JsonProperty("grant_type")
    private String grantType;
}
