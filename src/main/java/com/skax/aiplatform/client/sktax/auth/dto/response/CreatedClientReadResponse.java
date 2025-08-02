package com.skax.aiplatform.client.sktax.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 생성 응답 DTO
 * 
 * <p>OpenAPI 스키마명: CreatedClientReadResponse</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "클라이언트 생성 응답")
public class CreatedClientReadResponse {

    @JsonProperty("client_id")
    @Schema(description = "클라이언트 ID", required = true)
    private String clientId;

    @JsonProperty("client_secret")
    @Schema(description = "클라이언트 시크릿", required = true)
    private String clientSecret;

    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID", required = true)
    private String projectId;

    @JsonProperty("project_name")
    @Schema(description = "프로젝트명", required = true)
    private String projectName;

    @JsonProperty("namespace_id")
    @Schema(description = "네임스페이스 ID", required = true)
    private String namespaceId;

    @JsonProperty("namespace_name")
    @Schema(description = "네임스페이스명", required = true)
    private String namespaceName;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", required = true)
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시", required = true)
    private String createdAt;
}
