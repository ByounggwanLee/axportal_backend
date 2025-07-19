package com.skax.aiportal.dto.authorization.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

/**
 * 시스템 로그인 요청 DTO
 * 
 * <p>시스템에서 사용자 정보를 업데이트하고 액세스 토큰을 발급받는 요청 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "시스템 로그인 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthSystemLoginRequest {

    /**
     * 사용자명
     */
    @Schema(description = "사용자명", example = "john_doe", required = true)
    @NotBlank(message = "사용자명은 필수입니다")
    private String username;

    /**
     * 이메일
     */
    @Schema(description = "이메일", example = "john@example.com", required = true)
    @Email(message = "올바른 이메일 형식이어야 합니다")
    @NotBlank(message = "이메일은 필수입니다")
    private String email;

    /**
     * 성명
     */
    @Schema(description = "성명", example = "John Doe")
    private String name;

    /**
     * 첫 번째 이름
     */
    @Schema(description = "이름", example = "John")
    private String firstName;

    /**
     * 마지막 이름
     */
    @Schema(description = "성", example = "Doe")
    private String lastName;

    /**
     * 사용자 활성화 여부
     */
    @Schema(description = "사용자 활성화 여부", example = "true")
    private Boolean enabled;

    /**
     * 이메일 인증 여부
     */
    @Schema(description = "이메일 인증 여부", example = "true")
    private Boolean emailVerified;

    /**
     * 추가 속성 (부서, 직책 등)
     */
    @Schema(description = "부서", example = "IT")
    private String department;

    /**
     * 직책
     */
    @Schema(description = "직책", example = "Developer")
    private String position;

    /**
     * 전화번호
     */
    @Schema(description = "전화번호", example = "+82-10-1234-5678")
    private String phoneNumber;
}
