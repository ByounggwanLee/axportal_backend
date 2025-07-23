package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * SKT AI 사용자 정보 수정 요청 DTO
 * 
 * <p>기존 사용자의 프로필 정보를 수정하기 위한 요청 객체입니다.
 * 이메일, 이름, 성 등의 기본 정보를 업데이트할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "사용자 정보 수정 요청",
    description = "기존 사용자의 프로필 정보 수정을 위한 요청 데이터"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateRequest {

    /**
     * 이메일 주소
     * 
     * <p>사용자의 새로운 이메일 주소입니다. 유효한 이메일 형식이어야 합니다.</p>
     */
    @Schema(
        description = "사용자 이메일 주소 (선택적)",
        example = "john.doe@example.com",
        format = "email",
        maxLength = 100
    )
    @Email(message = "유효한 이메일 형식이어야 합니다")
    @Size(max = 100, message = "이메일은 100자 이하여야 합니다")
    @JsonProperty("email")
    private String email;

    /**
     * 이름
     * 
     * <p>사용자의 이름(First Name)입니다.</p>
     */
    @Schema(
        description = "사용자 이름 (선택적)",
        example = "John",
        maxLength = 50
    )
    @Size(max = 50, message = "이름은 50자 이하여야 합니다")
    @JsonProperty("first_name")
    private String firstName;

    /**
     * 성
     * 
     * <p>사용자의 성(Last Name)입니다.</p>
     */
    @Schema(
        description = "사용자 성 (선택적)",
        example = "Doe",
        maxLength = 50
    )
    @Size(max = 50, message = "성은 50자 이하여야 합니다")
    @JsonProperty("last_name")
    private String lastName;
}
