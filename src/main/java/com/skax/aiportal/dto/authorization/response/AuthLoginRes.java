package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * OAuth2 로그인 응답 DTO
 * 
 * <p>OAuth2 로그인 성공 시 반환되는 토큰 정보와 프로젝트 목록을 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "OAuth2 로그인 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthLoginRes {

    /**
     * 액세스 토큰
     */
    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 리프레시 토큰
     */
    @Schema(description = "리프레시 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 토큰 타입
     */
    @Schema(description = "토큰 타입", example = "Bearer")
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 액세스 토큰 만료 시간 (초)
     */
    @Schema(description = "액세스 토큰 만료 시간(초)", example = "3600")
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 리프레시 토큰 만료 시간 (초)
     */
    @Schema(description = "리프레시 토큰 만료 시간(초)", example = "86400")
    @JsonProperty("refresh_expires_in")
    private Long refreshExpiresIn;

    /**
     * 사용 가능한 프로젝트 목록
     */
    @Schema(description = "사용 가능한 프로젝트 목록")
    @JsonProperty("projects")
    private List<ProjectInfo> projects;

    /**
     * 프로젝트 정보 내부 클래스
     */
    @Schema(description = "프로젝트 정보")
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ProjectInfo {

        /**
         * 프로젝트 ID
         */
        @Schema(description = "프로젝트 ID", example = "project-001")
        @JsonProperty("id")
        private String id;

        /**
         * 프로젝트 이름
         */
        @Schema(description = "프로젝트 이름", example = "AI 챗봇 프로젝트")
        @JsonProperty("name")
        private String name;

        /**
         * 프로젝트 설명
         */
        @Schema(description = "프로젝트 설명", example = "고객 상담용 AI 챗봇 개발 프로젝트")
        @JsonProperty("description")
        private String description;

        /**
         * 프로젝트 상태
         */
        @Schema(description = "프로젝트 상태", example = "ACTIVE")
        @JsonProperty("status")
        private String status;
    }
}
