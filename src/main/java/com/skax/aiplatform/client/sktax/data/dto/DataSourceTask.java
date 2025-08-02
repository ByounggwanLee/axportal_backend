package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DataSource Task DTO
 * 
 * <p>데이터소스 태스크 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTask {

    /**
     * 태스크 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 데이터소스 ID (필수)
     */
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;

    /**
     * 태스크 타입 (필수)
     */
    @JsonProperty("task_type")
    private TaskTypeEnum taskType;

    /**
     * 상태 (기본값: pending)
     */
    @JsonProperty("status")
    @Builder.Default
    private TaskStatusEnum status = TaskStatusEnum.PENDING;

    /**
     * 오류 메시지
     */
    @JsonProperty("error_message")
    private String errorMessage;

    /**
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
