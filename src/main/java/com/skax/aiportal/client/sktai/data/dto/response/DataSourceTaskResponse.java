package com.skax.aiportal.client.sktai.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

/**
 * 데이터소스 작업 응답 DTO
 * 
 * <p>SKT AI 플랫폼의 데이터소스 작업 정보를 담는 응답 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataSourceTaskResponse {

    /**
     * 작업 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 데이터소스 ID
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;

    /**
     * 작업 타입
     */
    @JsonProperty("task_type")
    private String taskType;

    /**
     * 작업 상태
     */
    @JsonProperty("status")
    @Builder.Default
    private String status = "pending";

    /**
     * 오류 메시지
     */
    @JsonProperty("error_message")
    private String errorMessage;

    /**
     * 생성 일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정 일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
