package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.TaskTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataSource Task 생성 요청 DTO
 * 
 * <p>데이터소스 태스크를 생성하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTaskCreate {

    /**
     * 태스크 ID (필수)
     */
    @JsonProperty("task_id")
    private String taskId;

    /**
     * 태스크 타입
     */
    @JsonProperty("task_type")
    private TaskTypeEnum taskType;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;
}
