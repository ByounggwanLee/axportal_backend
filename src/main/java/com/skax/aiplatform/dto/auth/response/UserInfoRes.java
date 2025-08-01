package com.skax.aiplatform.dto.auth.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 사용자 정보 응답 DTO
 * 
 * <p>인증된 사용자의 정보를 담는 응답 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 정보 응답")
public class UserInfoRes {

    @Schema(description = "사용자명", example = "admin")
    private String username;

    @Schema(description = "사용자 권한 목록", example = "[\"ROLE_USER\", \"ROLE_ADMIN\"]")
    private List<String> authorities;

    @Schema(description = "사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "이메일", example = "admin@example.com")
    private String email;

    @Schema(description = "이름", example = "관리자")
    private String name;
}
