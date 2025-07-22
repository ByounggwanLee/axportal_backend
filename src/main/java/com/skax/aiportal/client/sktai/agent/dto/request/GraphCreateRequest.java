package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graph 생성 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphCreateRequest {

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
    private AgentGraphData agentGraph;

    /**
     * 그래프 카테고리
     */
    @JsonProperty("category")
    private String category;

    /**
     * Agent 그래프 데이터 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AgentGraphData {

        /**
         * 그래프 노드 목록
         */
        @JsonProperty("nodes")
        private List<GraphNode> nodes;

        /**
         * 그래프 엣지 목록
         */
        @JsonProperty("edges")
        private List<GraphEdge> edges;

        /**
         * 그래프 변수 목록
         */
        @JsonProperty("variables")
        private List<GraphVariable> variables;

        /**
         * 그래프 메타데이터
         */
        @JsonProperty("meta")
        private GraphMeta meta;
    }

    /**
     * 그래프 노드 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraphNode {

        /**
         * 노드 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 노드 타입
         */
        @JsonProperty("type")
        private String type;

        /**
         * 노드 이름
         */
        @JsonProperty("name")
        private String name;

        /**
         * 노드 데이터
         */
        @JsonProperty("data")
        private Object data;

        /**
         * 노드 위치
         */
        @JsonProperty("position")
        private NodePosition position;

        /**
         * 부모 노드 ID
         */
        @JsonProperty("parentId")
        private String parentId;

        /**
         * 확장 여부
         */
        @JsonProperty("expandParent")
        private Boolean expandParent;
    }

    /**
     * 그래프 엣지 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraphEdge {

        /**
         * 엣지 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 소스 노드 ID
         */
        @JsonProperty("source")
        private String source;

        /**
         * 타겟 노드 ID
         */
        @JsonProperty("target")
        private String target;

        /**
         * 소스 핸들
         */
        @JsonProperty("sourceHandle")
        private String sourceHandle;

        /**
         * 타겟 핸들
         */
        @JsonProperty("targetHandle")
        private String targetHandle;

        /**
         * 엣지 타입
         */
        @JsonProperty("type")
        private String type;

        /**
         * 엣지 데이터
         */
        @JsonProperty("data")
        private Object data;
    }

    /**
     * 그래프 변수 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraphVariable {

        /**
         * 변수 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 변수 이름
         */
        @JsonProperty("name")
        private String name;

        /**
         * 변수 타입
         */
        @JsonProperty("type")
        private String type;

        /**
         * 변수 값
         */
        @JsonProperty("value")
        private Object value;

        /**
         * 변수 설명
         */
        @JsonProperty("description")
        private String description;

        /**
         * 필수 여부
         */
        @JsonProperty("required")
        private Boolean required;
    }

    /**
     * 그래프 메타데이터 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GraphMeta {

        /**
         * 그래프 버전
         */
        @JsonProperty("version")
        private String version;

        /**
         * 생성 타임스탬프
         */
        @JsonProperty("createdAt")
        private String createdAt;

        /**
         * 수정 타임스탬프
         */
        @JsonProperty("updatedAt")
        private String updatedAt;

        /**
         * 추가 메타데이터
         */
        @JsonProperty("additional")
        private Object additional;
    }

    /**
     * 노드 위치 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NodePosition {

        /**
         * X 좌표
         */
        @JsonProperty("x")
        private Double x;

        /**
         * Y 좌표
         */
        @JsonProperty("y")
        private Double y;
    }
}
