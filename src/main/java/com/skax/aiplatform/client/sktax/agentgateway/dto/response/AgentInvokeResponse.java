package com.skax.aiplatform.client.sktax.agentgateway.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agentgateway.dto.AgentOutput;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Gateway Invoke 응답
 * 
 * <p>Agent 실행 결과를 담는 응답 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Agent Gateway Invoke 응답")
public class AgentInvokeResponse {

    /**
     * 출력 결과
     */
    @JsonProperty("output")
    @Schema(description = "Agent 실행 출력 결과")
    private AgentOutput output;
}
