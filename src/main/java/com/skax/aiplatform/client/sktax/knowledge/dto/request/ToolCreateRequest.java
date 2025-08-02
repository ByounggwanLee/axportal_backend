package com.skax.aiplatform.client.sktax.knowledge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.ToolType;
import com.skax.aiplatform.client.sktax.knowledge.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Tool 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolCreateRequest {

    /**
     * Tool 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 연결 정보
     */
    @JsonProperty("connection_info")
    private Map<String, Object> connectionInfo;

    /**
     * Tool 타입
     */
    @JsonProperty("type")
    private ToolType type;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

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
