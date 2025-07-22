package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graph 실행 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphRunRequest {

    /**
     * 그래프 실행에 사용할 변수 맵
     */
    @JsonProperty("variables")
    private Map<String, Object> variables;

    /**
     * 시작 노드 ID
     */
    @JsonProperty("start_node_id")
    private String startNodeId;

    /**
     * 실행 모드 (sync, async)
     */
    @JsonProperty("execution_mode")
    private String executionMode;

    /**
     * 최대 실행 시간 (초)
     */
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * 디버그 모드 여부
     */
    @JsonProperty("debug")
    private Boolean debug;
}
