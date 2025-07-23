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
 * 토큰 교환 요청 DTO
 * 
 * <p>기존 토큰을 다른 형태의 토큰으로 교환하는 요청 정보를 담는 객체입니다.
 * OAuth2 Token Exchange 플로우를 구현하며, 다양한 토큰 타입 간의 변환을 지원합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "토큰 교환 요청",
    description = "OAuth2 Token Exchange를 통한 토큰 변환 요청"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"subjectToken", "actorToken"})
public class AuthTokenExchangeRequest {

    /**
     * 교환할 주체 토큰
     * 
     * <p>교환 대상이 되는 원본 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "교환할 원본 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "jwt"
    )
    @NotBlank(message = "주체 토큰은 필수입니다.")
    @Size(max = 2048, message = "주체 토큰은 2048자를 초과할 수 없습니다.")
    private String subjectToken;

    /**
     * 주체 토큰 타입
     * 
     * <p>교환할 원본 토큰의 타입을 지정합니다.</p>
     */
    @Schema(
        description = "주체 토큰의 타입",
        example = "urn:ietf:params:oauth:token-type:access_token",
        requiredMode = Schema.RequiredMode.REQUIRED,
        allowableValues = {
            "urn:ietf:params:oauth:token-type:access_token",
            "urn:ietf:params:oauth:token-type:refresh_token",
            "urn:ietf:params:oauth:token-type:id_token",
            "urn:ietf:params:oauth:token-type:jwt"
        }
    )
    @NotBlank(message = "주체 토큰 타입은 필수입니다.")
    @Size(max = 100, message = "주체 토큰 타입은 100자를 초과할 수 없습니다.")
    private String subjectTokenType;

    /**
     * 요청하는 토큰 타입
     * 
     * <p>교환 후 받고자 하는 토큰의 타입을 지정합니다.</p>
     */
    @Schema(
        description = "요청할 토큰 타입",
        example = "urn:ietf:params:oauth:token-type:access_token",
        allowableValues = {
            "urn:ietf:params:oauth:token-type:access_token",
            "urn:ietf:params:oauth:token-type:refresh_token",
            "urn:ietf:params:oauth:token-type:id_token",
            "urn:ietf:params:oauth:token-type:jwt"
        }
    )
    @Size(max = 100, message = "요청 토큰 타입은 100자를 초과할 수 없습니다.")
    private String requestedTokenType;

    /**
     * 대행자 토큰
     * 
     * <p>대리 인증을 위한 액터 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "대행자(액터) 토큰 (선택사항)",
        example = "actor_token_example",
        format = "jwt"
    )
    @Size(max = 2048, message = "대행자 토큰은 2048자를 초과할 수 없습니다.")
    private String actorToken;

    /**
     * 대행자 토큰 타입
     * 
     * <p>대행자 토큰의 타입을 지정합니다.</p>
     */
    @Schema(
        description = "대행자 토큰의 타입",
        example = "urn:ietf:params:oauth:token-type:access_token",
        allowableValues = {
            "urn:ietf:params:oauth:token-type:access_token",
            "urn:ietf:params:oauth:token-type:jwt"
        }
    )
    @Size(max = 100, message = "대행자 토큰 타입은 100자를 초과할 수 없습니다.")
    private String actorTokenType;

    /**
     * 스코프
     * 
     * <p>요청하는 권한 범위입니다.</p>
     */
    @Schema(
        description = "요청할 권한 범위 (공백으로 구분)",
        example = "read write",
        maxLength = 255
    )
    @Size(max = 255, message = "스코프는 255자를 초과할 수 없습니다.")
    private String scope;

    /**
     * 대상 오디언스
     * 
     * <p>토큰의 대상 오디언스를 지정합니다.</p>
     */
    @Schema(
        description = "토큰의 대상 오디언스",
        example = "https://api.example.com",
        format = "uri",
        maxLength = 255
    )
    @Size(max = 255, message = "오디언스는 255자를 초과할 수 없습니다.")
    private String audience;

    /**
     * 클라이언트명
     * 
     * <p>토큰 교환을 요청하는 클라이언트를 식별하는 이름입니다.</p>
     */
    @Schema(
        description = "클라이언트명 (토큰 교환 요청 시스템 식별자)",
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
     * <p>OAuth2 인증 방식을 지정합니다. 토큰 교환에서는 "urn:ietf:params:oauth:grant-type:token-exchange"를 사용합니다.</p>
     */
    @Schema(
        description = "OAuth2 Grant Type",
        example = "urn:ietf:params:oauth:grant-type:token-exchange",
        allowableValues = {"urn:ietf:params:oauth:grant-type:token-exchange"},
        defaultValue = "urn:ietf:params:oauth:grant-type:token-exchange"
    )
    @Builder.Default
    private String grantType = "urn:ietf:params:oauth:grant-type:token-exchange";
}
