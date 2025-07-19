package com.skax.aiportal.client.sktai.authorization.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AI 로그인 응답 DTO
 * 
 * <p>
 * 로그인 성공 시 반환되는 토큰 정보입니다.
 * </p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 로그인 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    /**
     * 액세스 토큰
     */
    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJSUzI1NiIsInR5cCI...")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 만료 시간 (초)
     */
    @Schema(description = "토큰 만료 시간 (초)", example = "3600")
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * 리프레시 토큰
     */
    @Schema(description = "리프레시 토큰", example = "def50200...")
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 리프레시 토큰 만료 시간 (초)
     */
    @Schema(description = "리프레시 토큰 만료 시간 (초)", example = "2592000")
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    /**
     * 토큰 타입
     */
    @Schema(description = "토큰 타입", example = "Bearer")
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 프로젝트 목록 (토큰에 포함된 프로젝트)
     */
    @Schema(description = "프로젝트 목록")
    @JsonProperty("projects") 
    private List<ProjectPayload> projects;
}
