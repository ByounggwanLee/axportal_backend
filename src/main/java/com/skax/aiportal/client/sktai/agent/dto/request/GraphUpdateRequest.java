package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graph 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphUpdateRequest {

    /**
     * 그래프 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 그래프 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 그래프 태그 목록
     */
    @JsonProperty("tag_list")
    private List<String> tagList;

    /**
     * Agent 그래프 데이터
     */
    @JsonProperty("agent_graph")
    private GraphCreateRequest.AgentGraphData agentGraph;

    /**
     * 그래프 카테고리
     */
    @JsonProperty("category")
    private String category;
}
