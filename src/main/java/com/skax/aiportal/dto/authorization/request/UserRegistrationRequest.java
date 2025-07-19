package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 사용자 등록 요청 DTO
 * 
 * <p>사용자 회원가입 요청 시 사용하는 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

    /**
     * 사용자명
     */
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(min = 3, max = 20, message = "사용자명은 3자 이상 20자 이하로 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "사용자명은 영문, 숫자, 언더스코어만 사용할 수 있습니다")
    private String username;

    /**
     * 이메일
     */
    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식을 입력해주세요")
    private String email;

    /**
     * 비밀번호
     */
    @NotBlank(message = "비밀번호는 필수입니다")
    @Size(min = 8, max = 50, message = "비밀번호는 8자 이상 50자 이하로 입력해주세요")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", 
            message = "비밀번호는 대소문자, 숫자, 특수문자를 포함해야 합니다")
    private String password;

    /**
     * 비밀번호 확인
     */
    @NotBlank(message = "비밀번호 확인은 필수입니다")
    @JsonProperty("password_confirm")
    private String passwordConfirm;

    /**
     * 사용자 실명
     */
    @NotBlank(message = "이름은 필수입니다")
    @Size(max = 50, message = "이름은 50자 이하로 입력해주세요")
    private String name;

    /**
     * 전화번호
     */
    @Pattern(regexp = "^01[0-9]-\\d{4}-\\d{4}$", message = "올바른 전화번호 형식을 입력해주세요 (예: 010-1234-5678)")
    @JsonProperty("phone_number")
    private String phoneNumber;
}
