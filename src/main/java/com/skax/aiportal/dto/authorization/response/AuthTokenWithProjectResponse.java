package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 프로젝트 정보가 포함된 인증 토큰 응답 DTO
 * 
 * <p>액세스 토큰과 함께 사용자가 접근 가능한 프로젝트 정보를 포함하는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "프로젝트 정보가 포함된 인증 토큰 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenWithProjectResponse {

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
     * 토큰 만료 시간 (초)
     */
    @Schema(description = "토큰 만료 시간 (초)", example = "3600")
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 스코프
     */
    @Schema(description = "토큰 스코프", example = "read write")
    @JsonProperty("scope")
    private String scope;

    /**
     * 사용자 정보
     */
    @Schema(description = "사용자 정보")
    @JsonProperty("user")
    private UserInfo user;

    /**
     * 프로젝트 목록
     */
    @Schema(description = "접근 가능한 프로젝트 목록")
    @JsonProperty("projects")
    private List<ProjectInfo> projects;

    /**
     * 현재 선택된 프로젝트
     */
    @Schema(description = "현재 선택된 프로젝트")
    @JsonProperty("current_project")
    private ProjectInfo currentProject;

    /**
     * 토큰 발급 시간
     */
    @Schema(description = "토큰 발급 시간")
    @JsonProperty("issued_at")
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     */
    @Schema(description = "토큰 만료 시간")
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;

    /**
     * 사용자 정보 내부 클래스
     */
    @Schema(description = "사용자 정보")
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        
        @Schema(description = "사용자 ID", example = "user123")
        @JsonProperty("id")
        private String id;
        
        @Schema(description = "사용자명", example = "john_doe")
        @JsonProperty("username")
        private String username;
        
        @Schema(description = "이메일", example = "john@example.com")
        @JsonProperty("email")
        private String email;
        
        @Schema(description = "성명", example = "John Doe")
        @JsonProperty("name")
        private String name;
        
        @Schema(description = "권한 목록")
        @JsonProperty("roles")
        private List<String> roles;
    }

    /**
     * 프로젝트 정보 내부 클래스
     */
    @Schema(description = "프로젝트 정보")
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectInfo {
        
        @Schema(description = "프로젝트 ID", example = "project123")
        @JsonProperty("id")
        private String id;
        
        @Schema(description = "프로젝트명", example = "AI Portal Project")
        @JsonProperty("name")
        private String name;
        
        @Schema(description = "프로젝트 설명", example = "AI 포털 프로젝트")
        @JsonProperty("description")
        private String description;
        
        @Schema(description = "프로젝트에서의 사용자 역할")
        @JsonProperty("user_roles")
        private List<String> userRoles;
        
        @Schema(description = "프로젝트 상태", example = "ACTIVE")
        @JsonProperty("status")
        private String status;
    }
}
