package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * SKT AI 사용자 응답 DTO
 * 
 * <p>SKT AI 플랫폼의 사용자 정보를 반환하는 응답 객체입니다.
 * 사용자 기본 정보, 역할, 속성, 상태 등을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(
    title = "사용자 정보 응답",
    description = "SKT AI 플랫폼의 사용자 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {

    /**
     * 사용자 ID
     * 
     * <p>시스템에서 생성한 사용자의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "사용자 고유 식별자",
        example = "user-12345",
        maxLength = 50
    )
    @JsonProperty("id")
    private String id;

    /**
     * 사용자명
     * 
     * <p>사용자가 로그인할 때 사용하는 사용자명입니다.</p>
     */
    @Schema(
        description = "사용자명 (로그인 ID)",
        example = "john.doe",
        maxLength = 50
    )
    @JsonProperty("username")
    private String username;

    /**
     * 이메일
     * 
     * <p>사용자의 이메일 주소입니다.</p>
     */
    @Schema(
        description = "사용자 이메일 주소",
        example = "john.doe@example.com",
        format = "email",
        maxLength = 100
    )
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
    @JsonProperty("first_name")
    private String firstName;

    @Schema(description = "성")
    @JsonProperty("last_name")
    private String lastName;

    @Schema(description = "역할 목록")
    @JsonProperty("roles")
    private List<Object> roles;

    @Schema(description = "그룹 목록")
    @JsonProperty("groups")
    private List<Object> groups;
}
