package com.skax.aiportal.dto.authorization.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SSO 콜백 응답 DTO
 * 
 * <p>SSO 제공자로부터의 콜백 처리 결과를 담는 DTO입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "SSO 콜백 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthSsoCallbackRes {

    /**
     * 콜백 처리 성공 여부
     */
    @Schema(description = "콜백 처리 성공 여부", example = "true")
    @JsonProperty("success")
    private Boolean success;

    /**
     * 콜백 처리 메시지
     */
    @Schema(description = "콜백 처리 메시지", example = "SSO 콜백이 성공적으로 처리되었습니다.")
    @JsonProperty("message")
    private String message;

    /**
     * 사용자 데이터
     */
    @Schema(description = "사용자 데이터", example = "{\"user_id\":\"123\",\"email\":\"user@example.com\"}")
    @JsonProperty("user_data")
    private String userData;
}
