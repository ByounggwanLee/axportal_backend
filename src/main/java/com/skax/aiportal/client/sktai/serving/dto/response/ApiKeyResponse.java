package com.skax.aiportal.client.sktai.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * API 키 응답 DTO
 * 
 * API 키 정보에 대한 응답 데이터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyResponse {

    /**
     * API 키 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * API 키 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * API 키 (생성 시에만 반환)
     */
    @JsonProperty("api_key")
    private String apiKey;

    /**
     * API 키 프리픽스 (목록 조회 시)
     */
    @JsonProperty("api_key_prefix")
    private String apiKeyPrefix;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 만료일 (YYYY-MM-DD 형식)
     */
    @JsonProperty("expiry_date")
    private String expiryDate;

    /**
     * 스코프 목록
     */
    @JsonProperty("scopes")
    private java.util.List<String> scopes;

    /**
     * 활성 상태
     */
    @JsonProperty("is_active")
    private Boolean isActive;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * 마지막 사용일시
     */
    @JsonProperty("last_used_at")
    private String lastUsedAt;

    /**
     * 생성자 ID
     */
    @JsonProperty("creator_id")
    private String creatorId;

    /**
     * 조직 ID
     */
    @JsonProperty("organization_id")
    private String organizationId;
}
