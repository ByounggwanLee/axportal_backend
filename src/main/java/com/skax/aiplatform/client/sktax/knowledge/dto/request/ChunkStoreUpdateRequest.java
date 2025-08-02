package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.ChunkStoreType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * ChunkStore 수정 요청 DTO
 * OpenAPI 스키마: ChunkStoreUpdate
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChunkStoreUpdateRequest {

    @JsonProperty("project_id")
    private String projectId;

    @NotBlank(message = "name은 필수입니다")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "type은 필수입니다")
    @JsonProperty("type")
    @Builder.Default
    private ChunkStoreType type = ChunkStoreType.OPENSEARCH;

    @NotNull(message = "connection_info는 필수입니다")
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_by")
    private String updatedBy;
}
