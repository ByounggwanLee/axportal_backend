package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI 로그인 요청 DTO
 * 
 * <p>OAuth2 Password Grant를 사용한 로그인 요청 정보입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 로그인 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    /**
     * Grant Type (항상 "password")
     */
    @Schema(description = "Grant Type", example = "password", required = true)
    @JsonProperty("grant_type")
    @Builder.Default
    private String grantType = "password";

    /**
     * 사용자명
     */
    @Schema(description = "사용자명", example = "admin", required = true)
    @JsonProperty("username")
    private String username;

    /**
     * 비밀번호
     */
    @Schema(description = "비밀번호", example = "password123", required = true)
    @JsonProperty("password")
    private String password;

    /**
     * 스코프 (선택사항)
     */
    @Schema(description = "권한 스코프", example = "")
    @JsonProperty("scope")
    @Builder.Default
    private String scope = "";

    /**
     * 클라이언트 ID (프로젝트명)
     */
    @Schema(description = "클라이언트 ID (프로젝트명)", example = "default")
    @JsonProperty("client_id")
    @Builder.Default
    private String clientId = "default";

    /**
     * 클라이언트 시크릿 (선택사항)
     */
    @Schema(description = "클라이언트 시크릿")
    @JsonProperty("client_secret")
    private String clientSecret;
}
