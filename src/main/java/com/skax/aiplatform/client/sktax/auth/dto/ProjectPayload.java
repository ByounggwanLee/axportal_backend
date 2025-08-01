package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 Payload DTO
 * 
 * <p>OpenAPI 스키마명: ProjectPayload</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "프로젝트 정보")
public class ProjectPayload {

    @JsonProperty("id")
    @Schema(description = "프로젝트 ID", required = true)
    private String id;

    @JsonProperty("name")
    @Schema(description = "프로젝트명", required = true)
    private String name;
}
