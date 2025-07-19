package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OAuth2 패스워드 로그인 요청 DTO
 * 
 * <p>SKT AI 인증 API의 OAuth2 패스워드 플로우 로그인 요청을 위한 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2LoginRequest {

    /**
     * Grant 타입 (고정값: password)
     */
    @JsonProperty("grant_type")
    @Builder.Default
    private String grantType = "password";

    /**
     * 사용자명
     */
    private String username;

    /**
     * 비밀번호
     */
    private String password;

    /**
     * 스코프
     */
    @Builder.Default
    private String scope = "";

    /**
     * 클라이언트 ID (프로젝트명)
     */
    @JsonProperty("client_id")
    @Builder.Default
    private String clientId = "default";

    /**
     * 클라이언트 시크릿
     */
    @JsonProperty("client_secret")
    private String clientSecret;
}
