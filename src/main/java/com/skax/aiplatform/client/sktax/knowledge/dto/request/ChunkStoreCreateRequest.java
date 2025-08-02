package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.ChunkStoreType;
import com.skax.aiplatform.client.sktax.knowledge.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * ChunkStore 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChunkStoreCreateRequest {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * ChunkStore 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * ChunkStore 타입
     */
    @JsonProperty("type")
    private ChunkStoreType type;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책 설정
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
