package com.skax.aiplatform.client.sktax.resource.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceResource;
import com.skax.aiplatform.client.sktax.resource.dto.NodeResource;
import com.skax.aiplatform.client.sktax.resource.dto.TaskPolicy;
import com.skax.aiplatform.client.sktax.resource.dto.TaskQuota;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Task Resource 조회 응답
 * 
 * <p>Task 실행 전 Resource 조회 결과를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Task Resource 조회 응답")
public class TaskResourceRes {

    /**
     * 노드 리소스 목록
     */
    @JsonProperty("node_resource")
    @Valid
    @Schema(description = "노드 리소스 목록")
    private List<NodeResource> nodeResource;

    /**
     * Namespace 리소스
     */
    @JsonProperty("namespace_resource")
    @Valid
    @Schema(description = "Namespace 리소스")
    private NamespaceResource namespaceResource;

    /**
     * Task 정책
     */
    @JsonProperty("task_policy")
    @Valid
    @Schema(description = "Task 정책")
    private TaskPolicy taskPolicy;

    /**
     * Task 할당량
     */
    @JsonProperty("task_quota")
    @Valid
    @Schema(description = "Task 할당량")
    private TaskQuota taskQuota;
}
