package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 비밀번호 변경 요청 DTO
 * 
 * <p>OpenAPI 스키마명: ChangePasswordRequest</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "비밀번호 변경 요청")
public class ChangePasswordReq {

    @JsonProperty("current_password")
    @Schema(description = "현재 비밀번호", required = true)
    private String currentPassword;

    @JsonProperty("new_password")
    @Schema(description = "새 비밀번호", required = true)
    private String newPassword;

    @JsonProperty("confirm_password")
    @Schema(description = "비밀번호 확인", required = true)
    private String confirmPassword;
}
