package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.auth.dto.ProjectPayload;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 프로젝트와 함께 제공되는 액세스 토큰 응답 DTO
 * 
 * <p>OpenAPI 스키마명: AccessTokenResponseWithProject</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "프로젝트 정보가 포함된 액세스 토큰 응답")
public class AccessTokenResponseWithProject {

    @JsonProperty("access_token")
    @Schema(description = "액세스 토큰", required = true)
    private String accessToken;

    @JsonProperty("expires_in")
    @Schema(description = "토큰 만료 시간(초)", required = true)
    private Integer expiresIn;

    @JsonProperty("refresh_token")
    @Schema(description = "리프레시 토큰", required = true)
    private String refreshToken;

    @JsonProperty("refresh_expires_in")
    @Schema(description = "리프레시 토큰 만료 시간(초)", required = true)
    private Integer refreshExpiresIn;

    @JsonProperty("token_type")
    @Schema(description = "토큰 타입", required = true)
    private String tokenType;

    @JsonProperty("projects")
    @Schema(description = "프로젝트 목록", required = true)
    private List<ProjectPayload> projects;
}
