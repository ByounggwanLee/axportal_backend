package com.skax.aiportal.client.sktai.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
