package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 액세스 토큰 응답 DTO
 * 
 * <p>시스템 로그인 등에서 반환되는 기본 액세스 토큰 정보를 담는 DTO입니다.
 * 프로젝트 정보는 포함하지 않습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessTokenResponse {

    /**
     * 액세스 토큰
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 타입 (일반적으로 "Bearer")
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 토큰 만료 시간 (초 단위)
     */
    @JsonProperty("expires_in")
    private Long expiresIn;
}
