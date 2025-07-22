package com.skax.aiportal.client.sktai.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 배포 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppDeployRequest {

    /**
     * 배포 대상 ID
     */
    @JsonProperty("target_id")
    private String targetId;

    /**
     * 배포 대상 타입 (agent_graph, agent_form)
     */
    @JsonProperty("target_type")
    private String targetType;

    /**
     * 버전 설명
     */
    @JsonProperty("version_description")
    private String versionDescription;

    /**
     * 서빙 타입 (shared, standalone)
     */
    @JsonProperty("serving_type")
    @Builder.Default
    private String servingType = "shared";

    /**
     * CPU 요청량
     */
    @JsonProperty("cpu_request")
    private Integer cpuRequest;

    /**
     * CPU 제한량
     */
    @JsonProperty("cpu_limit")
    private Integer cpuLimit;

    /**
     * 메모리 요청량
     */
    @JsonProperty("mem_request")
    private Integer memRequest;

    /**
     * 메모리 제한량
     */
    @JsonProperty("mem_limit")
    private Integer memLimit;

    /**
     * GPU 요청량
     */
    @JsonProperty("gpu_request")
    private Integer gpuRequest;

    /**
     * GPU 제한량
     */
    @JsonProperty("gpu_limit")
    private Integer gpuLimit;

    /**
     * 최소 복제본 수
     */
    @JsonProperty("min_replicas")
    private Integer minReplicas;

    /**
     * 최대 복제본 수
     */
    @JsonProperty("max_replicas")
    private Integer maxReplicas;

    /**
     * 코어당 워커 수
     */
    @JsonProperty("workers_per_core")
    @Builder.Default
    private Integer workersPerCore = 3;
}
