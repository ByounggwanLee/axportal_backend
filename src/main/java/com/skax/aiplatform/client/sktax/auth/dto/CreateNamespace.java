package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 네임스페이스 생성 DTO
 * 
 * <p>OpenAPI 스키마명: CreateNamespace</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "네임스페이스 생성")
public class CreateNamespace {

    @JsonProperty("namespace_name")
    @Schema(description = "네임스페이스명", required = true)
    private String namespaceName;

    @JsonProperty("namespace_description")
    @Schema(description = "네임스페이스 설명")
    private String namespaceDescription;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태", defaultValue = "true")
    @Builder.Default
    private Boolean isActive = true;
}
