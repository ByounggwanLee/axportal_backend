package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 네임스페이스 기본 정보 DTO
 * 
 * <p>OpenAPI 스키마명: NamespaceBase</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "네임스페이스 기본 정보")
public class NamespaceBase {

    @JsonProperty("namespace_id")
    @Schema(description = "네임스페이스 ID")
    private Long namespaceId;

    @JsonProperty("namespace_name")
    @Schema(description = "네임스페이스명")
    private String namespaceName;

    @JsonProperty("namespace_description")
    @Schema(description = "네임스페이스 설명")
    private String namespaceDescription;

    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID")
    private Long projectId;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태")
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "수정 일시")
    private String updatedAt;
}
