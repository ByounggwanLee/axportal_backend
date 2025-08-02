package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 태스크 실패 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskFailedRequest {
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("workflow_id")
    private String workflowId;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("ref_id")
    private String refId;
}
