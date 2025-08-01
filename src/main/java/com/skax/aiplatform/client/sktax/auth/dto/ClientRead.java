package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 읽기 DTO
 * 
 * <p>OpenAPI 스키마명: ClientRead</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "클라이언트 읽기")
public class ClientRead {

    @JsonProperty("project")
    @Schema(description = "프로젝트 정보", required = true)
    private ProjectPayload project;

    @JsonProperty("namespace")
    @Schema(description = "네임스페이스 정보")
    private Namespace namespace;
}
