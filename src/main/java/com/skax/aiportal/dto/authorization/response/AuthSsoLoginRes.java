package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SSO 로그인 응답 DTO
 * 
 * <p>SSO 로그인 초기화 결과를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "SSO 로그인 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthSsoLoginRes {

    /**
     * SSO 제공자로의 리디렉션 URL
     */
    @Schema(description = "SSO 제공자로의 리디렉션 URL", example = "https://sso.example.com/auth?client_id=123&redirect_uri=...")
    @JsonProperty("redirect_url")
    private String redirectUrl;

    /**
     * SSO 상태 정보
     */
    @Schema(description = "SSO 상태 정보", example = "sso_state_123456")
    @JsonProperty("state")
    private String state;
}
