package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * SAML 로그인 폼 응답 DTO
 * 
 * <p>SAML 인증을 위한 로그인 폼 정보를 담는 응답 객체입니다.
 * Identity Provider로 POST할 HTML 폼과 관련 정보를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "SAML 로그인 폼 응답",
    description = "SAML Identity Provider 로그인 폼 정보 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthSamlLoginFormResponse {

    /**
     * HTML 폼 데이터
     * 
     * <p>Identity Provider로 자동 제출할 HTML 폼입니다.</p>
     */
    @Schema(
        description = "Identity Provider로 제출할 HTML 폼",
        example = "<form method=\"post\" action=\"https://idp.example.com/sso\">...</form>",
        contentMediaType = "text/html"
    )
    private String htmlForm;

    /**
     * SAML 요청 XML
     * 
     * <p>Identity Provider로 전송할 SAML AuthnRequest XML입니다.</p>
     */
    @Schema(
        description = "SAML AuthnRequest XML",
        example = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>...",
        contentMediaType = "application/xml"
    )
    private String samlRequest;

    /**
     * Identity Provider URL
     * 
     * <p>SAML 요청을 POST할 Identity Provider의 SSO URL입니다.</p>
     */
    @Schema(
        description = "Identity Provider SSO URL",
        example = "https://idp.example.com/sso",
        format = "uri"
    )
    private String idpSsoUrl;

    /**
     * 릴레이 상태
     * 
     * <p>인증 완료 후 원래 요청을 복원하기 위한 상태 정보입니다.</p>
     */
    @Schema(
        description = "인증 완료 후 상태 복원용 RelayState",
        example = "original_request_state_123"
    )
    private String relayState;

    /**
     * 요청 ID
     * 
     * <p>SAML AuthnRequest의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "SAML AuthnRequest 고유 식별자",
        example = "saml_request_id_123456"
    )
    private String requestId;

    /**
     * 발급자
     * 
     * <p>SAML 요청을 발급한 Service Provider의 엔티티 ID입니다.</p>
     */
    @Schema(
        description = "Service Provider 엔티티 ID (Issuer)",
        example = "https://app.example.com/saml/metadata",
        format = "uri"
    )
    private String issuer;

    /**
     * 목적지
     * 
     * <p>SAML 요청의 목적지 URL입니다.</p>
     */
    @Schema(
        description = "SAML 요청 목적지 URL",
        example = "https://idp.example.com/sso",
        format = "uri"
    )
    private String destination;

    /**
     * Assertion Consumer Service URL
     * 
     * <p>인증 완료 후 SAML 응답을 수신할 URL입니다.</p>
     */
    @Schema(
        description = "SAML 응답 수신용 ACS URL",
        example = "https://app.example.com/saml/acs",
        format = "uri"
    )
    private String acsUrl;

    /**
     * Name ID 정책
     * 
     * <p>요청하는 Name ID의 형식 정책입니다.</p>
     */
    @Schema(
        description = "Name ID 형식 정책",
        example = "urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress"
    )
    private String nameIdPolicy;

    /**
     * 폼 필드 정보
     * 
     * <p>HTML 폼에 포함될 필드들의 키-값 쌍입니다.</p>
     */
    @Schema(
        description = "HTML 폼 필드 정보 (키-값 쌍)",
        example = "{\"SAMLRequest\": \"base64_encoded_request\", \"RelayState\": \"state_value\"}"
    )
    private Map<String, String> formFields;

    /**
     * 자동 제출 여부
     * 
     * <p>JavaScript를 통해 폼을 자동으로 제출할지 여부입니다.</p>
     */
    @Schema(
        description = "JavaScript 자동 폼 제출 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean autoSubmit = true;

    /**
     * 세션 타임아웃 (초)
     * 
     * <p>SAML 인증 세션의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "SAML 인증 세션 타임아웃 (초)",
        example = "1800",
        minimum = "1"
    )
    private Long sessionTimeout;

    /**
     * 요청 생성 시간
     * 
     * <p>SAML 인증 요청이 생성된 시간입니다.</p>
     */
    @Schema(
        description = "SAML 인증 요청 생성 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime createdAt;

    /**
     * 요청 만료 시간
     * 
     * <p>SAML 인증 요청이 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "SAML 인증 요청 만료 시간",
        example = "2025-07-23T11:00:00"
    )
    private LocalDateTime expiredAt;

    /**
     * 성공 여부
     * 
     * <p>SAML 로그인 폼 생성이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "SAML 로그인 폼 생성 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>SAML 로그인 폼 생성 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "SAML 로그인 폼 생성 결과 메시지",
        example = "SAML 로그인 폼이 성공적으로 생성되었습니다."
    )
    private String message;
}
