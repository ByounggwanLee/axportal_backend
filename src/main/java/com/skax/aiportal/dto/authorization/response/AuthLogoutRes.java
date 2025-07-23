package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 로그아웃 응답 DTO
 * 
 * <p>로그아웃 처리 결과를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "로그아웃 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthLogoutRes {

    /**
     * 로그아웃 성공 여부
     */
    @Schema(description = "로그아웃 성공 여부", example = "true")
    @JsonProperty("success")
    private Boolean success;

    /**
     * 로그아웃 처리 메시지
     */
    @Schema(description = "로그아웃 처리 메시지", example = "로그아웃이 성공적으로 처리되었습니다.")
    @JsonProperty("message")
    private String message;

    /**
     * 로그아웃된 사용자명
     */
    @Schema(description = "로그아웃된 사용자명", example = "testuser")
    @JsonProperty("username")
    private String username;
}
