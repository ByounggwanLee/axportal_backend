package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 프로젝트 정보가 포함된 액세스 토큰 응답 DTO
 * 
 * <p>OAuth2 로그인, 토큰 갱신, 토큰 교환 등에서 반환되는
 * 액세스 토큰과 사용 가능한 프로젝트 목록을 담는 DTO입니다.</p>
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
public class AccessTokenWithProjectResponse {

    /**
     * 액세스 토큰
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 리프레시 토큰
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 토큰 타입 (일반적으로 "Bearer")
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 액세스 토큰 만료 시간 (초 단위)
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 리프레시 토큰 만료 시간 (초 단위)
     */
    @JsonProperty("refresh_expires_in")
    private Long refreshExpiresIn;

    /**
     * 사용 가능한 프로젝트 목록
     */
    @JsonProperty("projects")
    private List<ProjectPayload> projects;

    /**
     * 프로젝트 정보 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ProjectPayload {

        /**
         * 프로젝트 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 프로젝트 이름
         */
        @JsonProperty("name")
        private String name;

        /**
         * 프로젝트 설명
         */
        @JsonProperty("description")
        private String description;

        /**
         * 프로젝트 상태
         */
        @JsonProperty("status")
        private String status;
    }
}
