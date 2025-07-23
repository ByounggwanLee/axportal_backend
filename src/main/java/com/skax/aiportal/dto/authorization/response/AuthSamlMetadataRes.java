package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SAML 메타데이터 응답 DTO
 * 
 * <p>SAML Identity Provider의 메타데이터 정보를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "SAML 메타데이터 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthSamlMetadataRes {

    /**
     * SAML 메타데이터 XML
     */
    @Schema(description = "SAML 메타데이터 XML", example = "<EntityDescriptor>...</EntityDescriptor>")
    @JsonProperty("metadata")
    private String metadata;

    /**
     * SAML Entity ID
     */
    @Schema(description = "SAML Entity ID", example = "https://idp.example.com/saml/metadata")
    @JsonProperty("entity_id")
    private String entityId;

    /**
     * SSO URL
     */
    @Schema(description = "SSO URL", example = "https://idp.example.com/saml/sso")
    @JsonProperty("sso_url")
    private String ssoUrl;
}
