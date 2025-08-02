package com.skax.aiplatform.client.sktax.agentgateway.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentOutput;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Gateway Batch 응답
 * 
 * <p>Agent 일괄 처리 결과를 담는 응답 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent Gateway Batch 응답")
public class AgentBatchResponse {

    /**
     * 출력 결과 목록
     */
    @JsonProperty("output")
    @Schema(description = "Agent 일괄 처리 출력 결과 목록")
    private List<AgentOutput> output;
}
