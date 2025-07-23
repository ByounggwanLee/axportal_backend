package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * SAML 메타데이터 응답 DTO
 * 
 * <p>SAML 인증에 필요한 메타데이터 정보를 담는 응답 객체입니다.
 * Service Provider 설정을 위한 메타데이터를 XML 형태로 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "SAML 메타데이터 응답",
    description = "SAML Service Provider 메타데이터 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthSamlMetadataResponse {

    /**
     * SAML 메타데이터 XML
     * 
     * <p>SAML Service Provider 설정을 위한 메타데이터 XML 문서입니다.</p>
     */
    @Schema(
        description = "SAML Service Provider 메타데이터 XML",
        example = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>...",
        contentMediaType = "application/xml"
    )
    private String metadataXml;

    /**
     * 엔티티 ID
     * 
     * <p>SAML Service Provider의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "SAML Service Provider 엔티티 ID",
        example = "https://app.example.com/saml/metadata",
        format = "uri"
    )
    private String entityId;

    /**
     * 메타데이터 유효 기간
     * 
     * <p>메타데이터의 유효 기간을 나타냅니다.</p>
     */
    @Schema(
        description = "메타데이터 유효 기간 (시간 단위)",
        example = "24",
        minimum = "1"
    )
    private Long validUntilHours;

    /**
     * 캐시 지속 시간
     * 
     * <p>메타데이터 캐시 유지 시간을 나타냅니다.</p>
     */
    @Schema(
        description = "메타데이터 캐시 지속 시간 (초)",
        example = "86400",
        minimum = "1"
    )
    private Long cacheDuration;

    /**
     * Assertion Consumer Service URL
     * 
     * <p>SAML 응답을 수신할 ACS URL입니다.</p>
     */
    @Schema(
        description = "SAML Assertion Consumer Service URL",
        example = "https://app.example.com/saml/acs",
        format = "uri"
    )
    private String acsUrl;

    /**
     * Single Logout Service URL
     * 
     * <p>SAML 로그아웃을 처리할 SLS URL입니다.</p>
     */
    @Schema(
        description = "SAML Single Logout Service URL",
        example = "https://app.example.com/saml/sls",
        format = "uri"
    )
    private String slsUrl;

    /**
     * 서명 인증서
     * 
     * <p>SAML 메시지 서명 검증용 X.509 인증서입니다.</p>
     */
    @Schema(
        description = "SAML 서명 검증용 X.509 인증서",
        example = "-----BEGIN CERTIFICATE-----\nMIIC..."
    )
    private String signingCertificate;

    /**
     * 암호화 인증서
     * 
     * <p>SAML 메시지 암호화용 X.509 인증서입니다.</p>
     */
    @Schema(
        description = "SAML 메시지 암호화용 X.509 인증서",
        example = "-----BEGIN CERTIFICATE-----\nMIIC..."
    )
    private String encryptionCertificate;

    /**
     * Name ID 형식
     * 
     * <p>지원하는 Name ID 형식 목록입니다.</p>
     */
    @Schema(
        description = "지원하는 Name ID 형식 (쉼표로 구분)",
        example = "urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress,urn:oasis:names:tc:SAML:2.0:nameid-format:persistent"
    )
    private String nameIdFormats;

    /**
     * 메타데이터 생성 시간
     * 
     * <p>메타데이터가 생성된 시간입니다.</p>
     */
    @Schema(
        description = "메타데이터 생성 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime createdAt;

    /**
     * 메타데이터 유효 만료 시간
     * 
     * <p>메타데이터가 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "메타데이터 유효 만료 시간",
        example = "2025-07-24T10:30:00"
    )
    private LocalDateTime validUntil;

    /**
     * 성공 여부
     * 
     * <p>메타데이터 생성이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "메타데이터 생성 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>메타데이터 생성 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "메타데이터 생성 결과 메시지",
        example = "SAML 메타데이터가 성공적으로 생성되었습니다."
    )
    private String message;
}
