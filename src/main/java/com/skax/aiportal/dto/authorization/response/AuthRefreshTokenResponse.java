package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 토큰 갱신 응답 DTO
 * 
 * <p>리프레시 토큰을 사용한 액세스 토큰 갱신 완료 후 반환되는 응답 정보를 담는 객체입니다.
 * 새로운 액세스 토큰과 관련 정보를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "토큰 갱신 응답",
    description = "리프레시 토큰을 통한 액세스 토큰 갱신 완료 후 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"accessToken", "refreshToken"})
public class AuthRefreshTokenResponse {

    /**
     * 새로운 액세스 토큰
     * 
     * <p>갱신된 새로운 액세스 토큰입니다. 보안상 로깅에서 제외됩니다.</p>
     */
    @Schema(
        description = "갱신된 새로운 액세스 토큰",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
        format = "jwt"
    )
    private String accessToken;

    /**
     * 새로운 리프레시 토큰
     * 
     * <p>갱신된 새로운 리프레시 토큰입니다. 보안상 로깅에서 제외됩니다.
     * 일부 경우에는 기존 리프레시 토큰을 재사용하거나 새로 발급할 수 있습니다.</p>
     */
    @Schema(
        description = "갱신된 새로운 리프레시 토큰 (선택사항)",
        example = "refresh_token_new_example",
        format = "jwt"
    )
    private String refreshToken;

    /**
     * 토큰 타입
     * 
     * <p>토큰의 타입입니다. 일반적으로 "Bearer"입니다.</p>
     */
    @Schema(
        description = "토큰 타입",
        example = "Bearer",
        defaultValue = "Bearer"
    )
    @Builder.Default
    private String tokenType = "Bearer";

    /**
     * 토큰 만료 시간 (초)
     * 
     * <p>새로운 액세스 토큰의 유효 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "새로운 액세스 토큰 만료 시간 (초)",
        example = "3600",
        minimum = "1"
    )
    private Long expiresIn;

    /**
     * 권한 범위
     * 
     * <p>갱신된 토큰의 권한 범위입니다. 원래 토큰과 같거나 더 제한적일 수 있습니다.</p>
     */
    @Schema(
        description = "갱신된 토큰의 권한 범위 (공백으로 구분)",
        example = "read write user:profile"
    )
    private String scope;

    /**
     * 사용자 ID
     * 
     * <p>토큰을 갱신한 사용자의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "토큰 갱신 사용자의 고유 식별자",
        example = "user123"
    )
    private String userId;

    /**
     * 클라이언트명
     * 
     * <p>토큰 갱신을 요청한 클라이언트명입니다.</p>
     */
    @Schema(
        description = "토큰 갱신 요청 클라이언트명",
        example = "default"
    )
    private String clientName;

    /**
     * 토큰 발급 시간
     * 
     * <p>새로운 토큰이 발급된 시간입니다.</p>
     */
    @Schema(
        description = "새로운 토큰 발급 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime issuedAt;

    /**
     * 토큰 만료 시간
     * 
     * <p>새로운 액세스 토큰이 만료되는 시간입니다.</p>
     */
    @Schema(
        description = "새로운 액세스 토큰 만료 시간",
        example = "2025-07-23T11:30:00"
    )
    private LocalDateTime expiredAt;

    /**
     * 이전 토큰 무효화 여부
     * 
     * <p>이전 액세스 토큰이 무효화되었는지 여부입니다.</p>
     */
    @Schema(
        description = "이전 액세스 토큰 무효화 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean previousTokenRevoked = true;

    /**
     * 갱신 횟수
     * 
     * <p>해당 리프레시 토큰으로 갱신한 횟수입니다.</p>
     */
    @Schema(
        description = "토큰 갱신 횟수",
        example = "3",
        minimum = "1"
    )
    private Integer refreshCount;

    /**
     * JTI (JWT ID)
     * 
     * <p>새로운 JWT 토큰의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "새로운 JWT 토큰 고유 식별자",
        example = "new_jwt_id_123456"
    )
    private String jti;

    /**
     * 갱신 성공 여부
     * 
     * <p>토큰 갱신이 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "토큰 갱신 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>토큰 갱신 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "토큰 갱신 결과 메시지",
        example = "액세스 토큰이 성공적으로 갱신되었습니다."
    )
    private String message;
}
