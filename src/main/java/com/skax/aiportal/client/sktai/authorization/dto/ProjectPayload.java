package com.skax.aiportal.client.sktai.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 정보 DTO
 */
@Schema(description = "프로젝트 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPayload {

    /**
     * 프로젝트 ID
     */
    @Schema(description = "프로젝트 ID", example = "proj_123")
    @JsonProperty("id")
    private String id;

    /**
     * 프로젝트명
     */
    @Schema(description = "프로젝트명", example = "AI Portal Project")
    @JsonProperty("name")
    private String name;
}
