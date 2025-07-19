package com.skax.aiportal.client.sktai.authorization.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKT AI 토큰 갱신 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "SKT AI 토큰 갱신 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshResponse {

    @Schema(description = "액세스 토큰")
    @JsonProperty("access_token")
    private String accessToken;

    @Schema(description = "토큰 만료 시간 (초)")
    @JsonProperty("expires_in")
    private Integer expiresIn;

    @Schema(description = "리프레시 토큰")
    @JsonProperty("refresh_token")
    private String refreshToken;

    @Schema(description = "리프레시 토큰 만료 시간 (초)")
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    @Schema(description = "토큰 타입")
    @JsonProperty("token_type")
    private String tokenType;

    @Schema(description = "프로젝트 목록")
    @JsonProperty("projects")
    private List<ProjectPayload> projects;
}
