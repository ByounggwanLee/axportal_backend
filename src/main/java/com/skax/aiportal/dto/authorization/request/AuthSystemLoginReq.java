package com.skax.aiportal.dto.authorization.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 시스템 로그인 요청 DTO
 * 
 * <p>시스템 간 인증을 위한 로그인 요청 정보를 담는 DTO입니다.
 * 클라이언트 시크릿과 클라이언트 이름을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "시스템 로그인 요청")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "clientSecret") // 보안상 시크릿은 로그에서 제외
public class AuthSystemLoginReq {

    /**
     * 클라이언트 시크릿
     */
    @Schema(description = "클라이언트 시크릿", example = "client-secret-123", maxLength = 200)
    @NotBlank(message = "클라이언트 시크릿은 필수입니다")
    @Size(max = 200, message = "클라이언트 시크릿은 200자 이하여야 합니다")
    @JsonProperty("client_secret")
    private String clientSecret;

    /**
     * 클라이언트 이름
     */
    @Schema(description = "클라이언트 이름", example = "backend-service", maxLength = 100)
    @NotBlank(message = "클라이언트 이름은 필수입니다")
    @Size(max = 100, message = "클라이언트 이름은 100자 이하여야 합니다")
    @JsonProperty("client_name")
    private String clientName;
}
