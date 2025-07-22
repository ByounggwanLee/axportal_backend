package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Chunk Store 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChunkStoreUpdateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * Chunk Store 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * Chunk Store 타입 (SystemDB, OpenSearch)
     */
    @JsonProperty("type")
    private String type;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
