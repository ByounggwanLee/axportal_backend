package com.skax.aiportal.client.sktai.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

/**
 * SKT AI 시스템 로그인 요청 DTO
 * 
 * <p>시스템 간 인증을 위한 로그인 요청 정보를 담는 객체입니다.
 * 사용자 정보를 업데이트하고 시스템 토큰을 발급받는 데 사용됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "시스템 로그인 요청",
    description = "SKT AI 플랫폼의 시스템 간 인증을 위한 로그인 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemLoginRequest {

    /**
     * 사용자명
     * 
     * <p>시스템 로그인을 위한 사용자 식별자입니다.</p>
     */
    @Schema(
        description = "시스템 사용자명",
        example = "system_user",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "사용자명은 필수입니다.")
    @JsonProperty("username")
    private String username;

    /**
     * 역할 목록
     * 
     * <p>사용자에게 할당된 역할(Role) 목록입니다. 빈 목록이 기본값입니다.</p>
     */
    @Schema(
        description = "사용자 역할 목록",
        example = "[]",
        defaultValue = "[]"
    )
    @JsonProperty("roles")
    @Builder.Default
    private List<Object> roles = List.of();

    /**
     * 그룹 목록
     * 
     * <p>사용자가 소속된 그룹(Group) 목록입니다. 빈 목록이 기본값입니다.</p>
     */
    @Schema(
        description = "사용자 그룹 목록",
        example = "[]",
        defaultValue = "[]"
    )
    @JsonProperty("groups")
    @Builder.Default
    private List<Object> groups = List.of();
}
