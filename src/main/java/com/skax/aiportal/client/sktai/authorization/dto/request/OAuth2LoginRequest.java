package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password") // 보안상 패스워드는 로그에서 제외
public class OAuth2LoginRequest {

    /**
     * 사용자명
     */
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(max = 100, message = "사용자명은 100자 이하여야 합니다")
    @JsonProperty("username")
    private String username;

    /**
     * 비밀번호
     */
    @NotBlank(message = "비밀번호는 필수입니다")
    @Size(max = 200, message = "비밀번호는 200자 이하여야 합니다")
    @JsonProperty("password")
    private String password;

    /**
     * 클라이언트 ID
     */
    @NotBlank(message = "클라이언트 ID는 필수입니다")
    @Size(max = 100, message = "클라이언트 ID는 100자 이하여야 합니다")
    @JsonProperty("client_id")
    private String clientId;

    /**
     * 인증 방식 (항상 "password")
     */
    @NotBlank(message = "인증 방식은 필수입니다")
    @JsonProperty("grant_type")
    private String grantType;
}
