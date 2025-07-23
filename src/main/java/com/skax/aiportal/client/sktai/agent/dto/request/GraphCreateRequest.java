package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Agent Graph 생성 요청 DTO
 * 
 * <p>SKT AI Agent 플랫폼에서 새로운 그래프를 생성하기 위한 요청 정보를 담는 객체입니다.
 * 그래프의 노드, 엣지, 변수, 메타데이터 등을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "Agent Graph 생성 요청",
    description = "SKT AI Agent 플랫폼에서 새로운 그래프를 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GraphCreateRequest {

    /**
     * 그래프 이름
     * 
     * <p>생성할 그래프의 이름입니다.</p>
     */
    @Schema(
        description = "그래프 이름",
        example = "고객 상담 봇 그래프",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "그래프 이름은 필수입니다.")
    @Size(max = 100, message = "그래프 이름은 100자를 초과할 수 없습니다.")
    @JsonProperty("name")
    private String name;

    /**
     * 그래프 설명
     * 
     * <p>그래프의 용도와 기능에 대한 설명입니다.</p>
     */
    @Schema(
        description = "그래프 설명",
        example = "고객 문의를 처리하는 대화형 AI 에이전트 그래프",
        maxLength = 500
    )
    @Size(max = 500, message = "그래프 설명은 500자를 초과할 수 없습니다.")
    @JsonProperty("description")
    private String description;

    /**
     * 그래프 태그 목록
     * 
     * <p>그래프를 분류하기 위한 태그들입니다.</p>
     */
    @Schema(
        description = "그래프 태그 목록",
        example = "[\"chatbot\", \"customer-service\", \"ai\"]"
    )
    @JsonProperty("tag_list")
    private List<String> tagList;

    /**
     * Agent 그래프 데이터
     * 
     * <p>그래프의 구조를 정의하는 데이터입니다.</p>
     */
    @Schema(
        description = "Agent 그래프 데이터 (노드, 엣지, 변수, 메타데이터 포함)",
        implementation = AgentGraphData.class
    )
    @JsonProperty("agent_graph")
    private AgentGraphData agentGraph;

    /**
     * 그래프 카테고리
     * 
     * <p>그래프의 분류 카테고리입니다.</p>
     */
    @Schema(
        description = "그래프 카테고리",
        example = "chatbot",
        maxLength = 50
    )
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
