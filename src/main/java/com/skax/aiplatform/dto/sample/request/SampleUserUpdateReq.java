package com.skax.aiplatform.dto.sample.request;

import com.skax.aiplatform.entity.sample.SampleUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 샘플 사용자 수정 요청 DTO
 * 
 * <p>기존 사용자 정보를 수정할 때 사용하는 요청 데이터 전송 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "샘플 사용자 수정 요청")
public class SampleUserUpdateReq {

    @Schema(description = "이메일", example = "john.doe@example.com")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    @Size(max = 100, message = "이메일은 100자 이하여야 합니다")
    private String email;

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

    /**
     * 유효한 필드가 있는지 확인
     * 
     * @return 유효한 필드 존재 여부
     */
    public boolean hasValidFields() {
        return email != null || fullName != null || phone != null || age != null || status != null;
    }
}
