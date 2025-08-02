package com.skax.aiplatform.client.sktax.resource.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Resource Check 응답
 * 
 * <p>Task 실행 시 Resource 확인 결과를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resource Check 응답")
public class ResourceCheckRes {

    /**
     * Namespace 이름
     */
    @JsonProperty("namespace")
    @Schema(description = "Namespace 이름", example = "ns-7d21dc00-cc80-43d9-8707-fa747b98d13")
    private String namespace;

    /**
     * Pod 라벨
     */
    @JsonProperty("pod_label")
    @Schema(description = "Pod 라벨", example = "[\"tasktype=serving\"]")
    private List<String> podLabel;

    /**
     * Node 라벨
     */
    @JsonProperty("node_label")
    @Schema(description = "Node 라벨", example = "[\"nodetype=task\",\"gputype=H100\"]")
    private List<String> nodeLabel;
}
