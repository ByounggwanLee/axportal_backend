package com.skax.aiportal.client.sktai.authorization.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 로그인 요청 DTO
 * 
 * <p>SKT AI 플랫폼의 OAuth2 패스워드 플로우 로그인 요청 정보를 담는 객체입니다.
 * 사용자명과 패스워드를 통해 인증을 수행합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "로그인 요청 정보", 
    description = "SKT AI 플랫폼의 OAuth2 패스워드 플로우 로그인을 위한 사용자 인증 정보"
)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "password") // 보안상 패스워드는 로그에서 제외
public class LoginRequest {
    
    /**
     * 사용자명 (로그인 ID)
     * 
     * <p>SKT AI 플랫폼에 등록된 사용자의 로그인 아이디입니다.</p>
     */
    @Schema(
        description = "사용자명 (로그인 ID)", 
        example = "user@example.com",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "아이디는 필수입니다.")
    private String username;
    
    /**
     * 패스워드
     * 
     * <p>사용자 계정의 패스워드입니다. 보안상 로그에 기록되지 않습니다.</p>
     */
    @Schema(
        description = "사용자 패스워드", 
        example = "password123!",
        requiredMode = Schema.RequiredMode.REQUIRED,
        format = "password",
        minLength = 8,
        maxLength = 50
    )
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
