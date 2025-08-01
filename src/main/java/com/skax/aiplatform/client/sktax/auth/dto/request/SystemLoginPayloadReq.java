package com.skax.aiplatform.client.sktax.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 시스템 로그인 요청 DTO
 * 
 * <p>시스템에서 사용자 정보를 업데이트하고 액세스 토큰을 발급받기 위한 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "시스템 로그인 요청")
public class SystemLoginPayloadReq {

    @NotBlank(message = "사용자명은 필수입니다")
    @JsonProperty("username")
    @Schema(description = "사용자명", example = "admin", required = true)
    private String username;

    @JsonProperty("roles")
    @Schema(description = "사용자 역할 목록")
    @Builder.Default
    private List<Object> roles = List.of();

    @JsonProperty("groups")
    @Schema(description = "사용자 그룹 목록")
    @Builder.Default
    private List<Object> groups = List.of();
}
