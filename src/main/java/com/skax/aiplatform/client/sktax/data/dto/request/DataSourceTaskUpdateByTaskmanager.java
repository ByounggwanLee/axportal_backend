package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataSource Task 태스크매니저에 의한 업데이트 요청 DTO
 * 
 * <p>태스크매니저가 데이터소스 태스크를 업데이트하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTaskUpdateByTaskmanager {

    /**
     * 태스크 상태 (필수)
     */
    @JsonProperty("status")
    private String status;

    /**
     * 메시지 (기본값: "")
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
     * 타입 (필수)
     */
    @JsonProperty("type")
    private String type;
}
