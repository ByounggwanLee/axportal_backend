package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * SKT AI 사용자 등록 요청 DTO
 * 
 * <p>SKT AI 플랫폼에 새로운 사용자를 등록하기 위한 요청 정보를 담는 객체입니다.
 * 사용자 기본 정보, 역할, 속성 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "사용자 등록 요청",
    description = "SKT AI 플랫폼에 새로운 사용자를 등록하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password") // 보안상 패스워드는 로그에서 제외
public class UserRegisterRequest {

    /**
     * 사용자명
     * 
     * <p>시스템에서 사용할 고유한 사용자 식별자입니다.</p>
     */
    @Schema(
        description = "사용자명 (고유 식별자)",
        example = "john.doe",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 50
    )
    @NotBlank(message = "사용자명은 필수입니다.")
    @Size(max = 50, message = "사용자명은 50자를 초과할 수 없습니다.")
    @JsonProperty("username")
    private String username;

    /**
     * 비밀번호
     * 
     * <p>사용자 계정의 패스워드입니다. 보안상 로그에 기록되지 않습니다.</p>
     */
    @Schema(
        description = "사용자 패스워드",
        example = "SecurePassword123!",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password",
        minLength = 8,
        maxLength = 100
    )
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, max = 100, message = "비밀번호는 8-100자 사이여야 합니다.")
    @JsonProperty("password")
    private String password;

    /**
     * 이메일
     * 
     * <p>사용자의 이메일 주소입니다. 알림 발송 등에 사용됩니다.</p>
     */
    @Schema(
        description = "사용자 이메일 주소",
        example = "john.doe@example.com",
        format = "email",
        maxLength = 100
    )
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다.")
    @JsonProperty("email")
    private String email;

    /**
     * 이름
     * 
     * <p>사용자의 실제 이름입니다.</p>
     */
    @Schema(
        description = "사용자 이름",
        example = "John",
        maxLength = 50
    )
    @Size(max = 50, message = "이름은 50자를 초과할 수 없습니다.")
    @JsonProperty("first_name")
    private String firstName;

    @Schema(description = "성")
    @JsonProperty("last_name")
    private String lastName;

    @Schema(description = "역할 목록")
    @JsonProperty("roles")
    private List<String> roles;

    @Schema(description = "그룹 목록")
    @JsonProperty("groups")
    private List<String> groups;
}

