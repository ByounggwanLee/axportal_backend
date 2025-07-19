package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import jakarta.validation.constraints.NotBlank;

/**
 * 데이터소스 작업 업데이트 요청 DTO (TaskManager용)
 * 
 * <p>TaskManager에 의한 데이터소스 작업 상태 업데이트 요청 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataSourceTaskUpdateByTaskmanagerRequest {

    /**
     * 작업 상태
     */
    @NotBlank(message = "작업 상태는 필수입니다")
    @JsonProperty("status")
    private String status;

    /**
     * 메시지
     */
    @JsonProperty("message")
    @Builder.Default
    private String message = "";

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    private String workflowId;

    /**
     * 작업 타입
     */
    @NotBlank(message = "작업 타입은 필수입니다")
    @JsonProperty("type")
    private String type;
}
