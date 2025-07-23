package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * SKT AI 토큰 갱신 응답 DTO
 * 
 * <p>리프레시 토큰을 사용하여 새로운 액세스 토큰을 발급받는 요청에 대한 응답 객체입니다.
 * 새로운 액세스 토큰과 함께 만료 시간, 리프레시 토큰 정보, 사용 가능한 프로젝트 목록을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "토큰 갱신 응답",
    description = "리프레시 토큰을 사용한 새로운 액세스 토큰 발급 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"})
public class TokenRefreshResponse {

    /**
     * 액세스 토큰
     * 
     * <p>새로 발급된 JWT 액세스 토큰입니다. API 요청시 Authorization 헤더에 포함되어야 합니다.</p>
     */
    @Schema(
        description = "새로 발급된 JWT 액세스 토큰 (Bearer 타입)",
        example = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
        pattern = "^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+$",
        format = "jwt"
    )
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 토큰 만료 시간 (초)
     * 
     * <p>액세스 토큰의 유효 기간을 초 단위로 표현합니다.</p>
     */
    @Schema(
        description = "액세스 토큰의 만료 시간 (초)",
        example = "3600",
        minimum = "1",
        maximum = "86400"
    )
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * 리프레시 토큰
     * 
     * <p>새로운 액세스 토큰 발급을 위한 리프레시 토큰입니다. 
     * 보안상 클라이언트에서는 안전한 저장소에 보관해야 합니다.</p>
     */
    @Schema(
        description = "새로 발급된 리프레시 토큰 (선택적)",
        example = "eyJhbGciOiJSUzI1NiIsInR5cCI...",
        pattern = "^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+$",
        format = "jwt"
    )
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 리프레시 토큰 만료 시간 (초)
     * 
     * <p>리프레시 토큰의 유효 기간을 초 단위로 표현합니다.</p>
     */
    @Schema(
        description = "리프레시 토큰의 만료 시간 (초)",
        example = "2592000",
        minimum = "3600",
        maximum = "7776000"
    )
    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    /**
     * 토큰 타입
     * 
     * <p>발급된 토큰의 타입을 나타냅니다. 일반적으로 "Bearer"입니다.</p>
     */
    @Schema(
        description = "토큰 타입 (Bearer 고정)",
        example = "Bearer",
        allowableValues = {"Bearer"}
    )
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 프로젝트 목록
     * 
     * <p>사용자가 접근 가능한 프로젝트 목록입니다. 
     * 토큰과 함께 제공되어 사용자의 권한 범위를 명시합니다.</p>
     */
    @Schema(
        description = "사용자가 접근 가능한 프로젝트 목록",
        implementation = ProjectPayload.class
    )
    @JsonProperty("projects")
    private List<ProjectPayload> projects;
}
