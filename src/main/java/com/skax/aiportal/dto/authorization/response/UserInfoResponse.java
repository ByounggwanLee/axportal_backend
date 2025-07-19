package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 사용자 정보 응답 DTO
 * 
 * <p>사용자 정보 조회 시 반환하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    /**
     * 사용자 ID
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 사용자명
     */
    private String username;

    /**
     * 이메일
     */
    private String email;

    /**
     * 사용자 실명
     */
    private String name;

    /**
     * 전화번호
     */
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * 역할 목록
     */
    private List<String> roles;

    /**
     * 권한 목록
     */
    private List<String> permissions;

    /**
     * 계정 활성화 여부
     */
    @JsonProperty("is_active")
    private Boolean isActive;

    /**
     * 계정 잠금 여부
     */
    @JsonProperty("is_locked")
    private Boolean isLocked;

    /**
     * 이메일 인증 여부
     */
    @JsonProperty("is_email_verified")
    private Boolean isEmailVerified;

    /**
     * 계정 생성 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 계정 수정 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 마지막 로그인 시간
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("last_login_at")
    private LocalDateTime lastLoginAt;

    /**
     * 비밀번호 변경 필요 여부
     */
    @JsonProperty("password_change_required")
    private Boolean passwordChangeRequired;
}
