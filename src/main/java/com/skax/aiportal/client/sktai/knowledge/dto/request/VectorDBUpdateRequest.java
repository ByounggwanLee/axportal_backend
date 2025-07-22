package com.skax.aiportal.client.sktai.knowledge.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Vector DB 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VectorDBUpdateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * Vector DB 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * Vector DB 타입 (Milvus, AzureAISearch, AzureAISearchShared, OpenSearch)
     */
    @JsonProperty("type")
    private String type;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * 기본 설정 여부
     */
    @JsonProperty("is_default")
    private Boolean isDefault;

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
