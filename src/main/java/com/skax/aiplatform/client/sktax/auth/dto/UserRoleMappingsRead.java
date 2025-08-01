package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 사용자 역할 매핑 읽기 DTO
 * 
 * <p>OpenAPI 스키마명: UserRoleMappingsRead</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 역할 매핑 읽기")
public class UserRoleMappingsRead {

    @JsonProperty("data")
    @Schema(description = "프로젝트 역할 데이터 목록", required = true)
    private List<ProjectRoles> data;

    @JsonProperty("payload")
    @Schema(description = "페이로드 정보", required = true)
    private Payload payload;
}
