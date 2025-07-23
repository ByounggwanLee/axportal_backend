package com.skax.aiportal.dto.authorization.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 로그아웃 응답 DTO
 * 
 * <p>로그아웃 처리 완료 후 반환되는 응답 정보를 담는 객체입니다.
 * 세션 종료 및 토큰 무효화 결과를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "로그아웃 응답",
    description = "로그아웃 처리 완료 후 결과 응답"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLogoutResponse {

    /**
     * 로그아웃 성공 여부
     * 
     * <p>로그아웃 처리가 성공했는지 여부를 나타냅니다.</p>
     */
    @Schema(
        description = "로그아웃 성공 여부",
        example = "true",
        defaultValue = "true"
    )
    @Builder.Default
    private Boolean success = true;

    /**
     * 응답 메시지
     * 
     * <p>로그아웃 처리 결과에 대한 메시지입니다.</p>
     */
    @Schema(
        description = "로그아웃 처리 결과 메시지",
        example = "성공적으로 로그아웃되었습니다."
    )
    private String message;

    /**
     * 무효화된 토큰 개수
     * 
     * <p>로그아웃 시 무효화된 토큰의 개수입니다.</p>
     */
    @Schema(
        description = "무효화된 토큰 개수",
        example = "2",
        minimum = "0"
    )
    private Integer revokedTokenCount;

    /**
     * 사용자 ID
     * 
     * <p>로그아웃한 사용자의 식별자입니다.</p>
     */
    @Schema(
        description = "로그아웃한 사용자 식별자",
        example = "user123"
    )
    private String userId;

    /**
     * 클라이언트명
     * 
     * <p>로그아웃을 요청한 클라이언트명입니다.</p>
     */
    @Schema(
        description = "로그아웃 요청 클라이언트명",
        example = "default"
    )
    private String clientName;

    /**
     * 세션 ID
     * 
     * <p>종료된 세션의 식별자입니다.</p>
     */
    @Schema(
        description = "종료된 세션 식별자",
        example = "session_123456"
    )
    private String sessionId;

    /**
     * 리다이렉트 URL
     * 
     * <p>로그아웃 후 리다이렉트할 URL입니다.</p>
     */
    @Schema(
        description = "로그아웃 후 리다이렉트 URL",
        example = "https://example.com/logout-success",
        format = "uri"
    )
    private String redirectUrl;

    /**
     * 로그아웃 처리 시간
     * 
     * <p>로그아웃이 처리된 시간입니다.</p>
     */
    @Schema(
        description = "로그아웃 처리 시간",
        example = "2025-07-23T10:30:00"
    )
    private LocalDateTime loggedOutAt;

    /**
     * 세션 지속 시간 (초)
     * 
     * <p>로그인부터 로그아웃까지의 세션 지속 시간을 초 단위로 나타냅니다.</p>
     */
    @Schema(
        description = "세션 지속 시간 (초)",
        example = "3600",
        minimum = "0"
    )
    private Long sessionDuration;

    /**
     * 전역 로그아웃 여부
     * 
     * <p>SSO 등에서 전역 로그아웃이 수행되었는지 여부입니다.</p>
     */
    @Schema(
        description = "전역 로그아웃 수행 여부",
        example = "false",
        defaultValue = "false"
    )
    @Builder.Default
    private Boolean globalLogout = false;

    /**
     * 정리된 리소스 목록
     * 
     * <p>로그아웃 시 정리된 리소스 목록입니다.</p>
     */
    @Schema(
        description = "정리된 리소스 목록 (쉼표로 구분)",
        example = "access_token,refresh_token,session_cache"
    )
    private String cleanedResources;

    /**
     * 다음 로그인 가능 시간
     * 
     * <p>보안상 제한이 있는 경우 다음 로그인 가능한 시간입니다.</p>
     */
    @Schema(
        description = "다음 로그인 가능 시간",
        example = "2025-07-23T10:35:00"
    )
    private LocalDateTime nextLoginAllowedAt;
}
