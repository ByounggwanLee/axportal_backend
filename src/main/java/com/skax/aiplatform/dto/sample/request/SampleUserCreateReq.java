package com.skax.aiplatform.dto.sample.request;

import com.skax.aiplatform.entity.sample.SampleUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 샘플 사용자 생성 요청 DTO
 * 
 * <p>새로운 사용자를 생성할 때 사용하는 요청 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "샘플 사용자 생성 요청")
public class SampleUserCreateReq {

    @Schema(description = "사용자명", example = "john_doe", required = true)
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(min = 3, max = 50, message = "사용자명은 3-50자 사이여야 합니다")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "사용자명은 영문, 숫자, 언더스코어만 허용됩니다")
    private String username;

    @Schema(description = "이메일", example = "john.doe@example.com", required = true)
    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    @Size(max = 100, message = "이메일은 100자 이하여야 합니다")
    private String email;

    @Schema(description = "패스워드", example = "password123!", required = true)
    @NotBlank(message = "패스워드는 필수입니다")
    @Size(min = 8, max = 100, message = "패스워드는 8-100자 사이여야 합니다")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]", 
             message = "패스워드는 대소문자, 숫자, 특수문자를 포함해야 합니다")
    private String password;

    @Schema(description = "전체 이름", example = "John Doe")
    @Size(max = 100, message = "전체 이름은 100자 이하여야 합니다")
    private String fullName;

    @Schema(description = "전화번호", example = "010-1234-5678")
    @Size(max = 20, message = "전화번호는 20자 이하여야 합니다")
    @Pattern(regexp = "^[0-9-+()\\s]*$", message = "올바른 전화번호 형식이 아닙니다")
    private String phone;

    @Schema(description = "나이", example = "30")
    @Min(value = 1, message = "나이는 1 이상이어야 합니다")
    @Max(value = 150, message = "나이는 150 이하여야 합니다")
    private Integer age;

    @Schema(description = "사용자 상태", example = "ACTIVE")
    private SampleUser.UserStatus status;
}
