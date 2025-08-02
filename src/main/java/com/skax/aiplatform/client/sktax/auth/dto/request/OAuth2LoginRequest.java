package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * OpenAPI 명세: Body_login_access_token_api_v1_auth_login_post
 * OAuth2 로그인 요청
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2LoginRequest {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("scope")
    @Builder.Default
    private String scope = "";

    @JsonProperty("client_id")
    @Builder.Default
    private String clientId = "default";

    @JsonProperty("client_secret")
    private String clientSecret;
}
