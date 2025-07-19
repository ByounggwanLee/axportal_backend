package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 역할 응답 DTO
 */
@Schema(description = "역할 정보")
@Getter
@Builder 
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {

    @Schema(description = "역할 ID")
    @JsonProperty("id")
    private String id;

    @Schema(description = "역할명")
    @JsonProperty("name")
    private String name;

    @Schema(description = "역할 설명")
    @JsonProperty("description")
    private String description;
}