package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import jakarta.validation.constraints.NotBlank;

/**
 * 데이터소스 작업 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼의 데이터소스 작업 생성 요청 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataSourceTaskCreateRequest {

    /**
     * 작업 ID
     */
    @NotBlank(message = "작업 ID는 필수입니다")
    @JsonProperty("task_id")
    private String taskId;

    /**
     * 작업 타입
     */
    @JsonProperty("task_type")
    private String taskType;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;
}
