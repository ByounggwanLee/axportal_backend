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
public class RagEvaluationResultUpdateRequest {

    @JsonProperty("rag_evaluation_log_id")
    private Integer ragEvaluationLogId;

    @JsonProperty("policy")
    private Object policy;
}
