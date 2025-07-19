package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 프로젝트 포함 액세스 토큰 응답 DTO
 * 
 * <p>SKT AI 인증 API의 프로젝트 정보를 포함한 토큰 응답을 위한 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenWithProjectResponse {

    /**
     * 액세스 토큰
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 만료 시간 (초)
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * 리프레시 토큰
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 리프레시 토큰 만료 시간 (초)
     */
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    /**
     * 토큰 타입 (예: Bearer)
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 프로젝트 목록
     */
    private List<ProjectPayload> projects;

    /**
     * 프로젝트 정보 DTO
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectPayload {
        
        /**
         * 프로젝트 ID
         */
        private String id;

        /**
         * 프로젝트명
         */
        private String name;
    }
}
