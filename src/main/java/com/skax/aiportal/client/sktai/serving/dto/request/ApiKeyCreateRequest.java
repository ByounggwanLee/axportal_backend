package com.skax.aiportal.client.sktai.serving.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * API 키 생성 요청 DTO
 * 
 * API 키를 생성하기 위한 요청 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyCreateRequest {

    /**
     * API 키 이름
     */
    @NotBlank(message = "API 키 이름은 필수입니다")
    @JsonProperty("name")
    private String name;

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
}
