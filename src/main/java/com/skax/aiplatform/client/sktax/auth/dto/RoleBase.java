package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 역할 기본 정보 DTO
 * 
 * <p>OpenAPI 스키마명: RoleBase</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "역할 기본 정보")
public class RoleBase {

    @JsonProperty("id")
    @Schema(description = "역할 ID", required = true)
    private String id;

    @JsonProperty("name")
    @Schema(description = "역할명", required = true)
    private String name;

    @JsonProperty("description")
    @Schema(description = "설명")
    private String description;
}
