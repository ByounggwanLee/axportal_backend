package com.skax.aiplatform.client.sktax.resource.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 노드 리소스 정보
 * 
 * <p>클러스터 노드의 리소스 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "노드 리소스 정보")
public class NodeResource {

    /**
     * 노드 이름
     */
    @JsonProperty("node_name")
    @Schema(description = "노드 이름", example = "set3-h06-svr42")
    private String nodeName;

    /**
     * 노드 라벨
     */
    @JsonProperty("node_label")
    @Schema(description = "노드 라벨", example = "[\"nodetype=task\",\"gputype=H100\"]")
    private List<String> nodeLabel;

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량", example = "96")
    private Double cpuQuota;

    /**
     * 메모리 할당량
     */
    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량", example = "1007.4")
    private Double memQuota;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량", example = "8")
    private Double gpuQuota;

    /**
     * CPU 사용량
     */
    @JsonProperty("cpu_used")
    @Schema(description = "CPU 사용량", example = "8.4")
    private Double cpuUsed;

    /**
     * 메모리 사용량
     */
    @JsonProperty("mem_used")
    @Schema(description = "메모리 사용량", example = "32.16")
    private Double memUsed;

    /**
     * GPU 사용량
     */
    @JsonProperty("gpu_used")
    @Schema(description = "GPU 사용량", example = "2")
    private Double gpuUsed;

    /**
     * CPU 사용 가능량
     */
    @JsonProperty("cpu_usable")
    @Schema(description = "CPU 사용 가능량", example = "87.6")
    private Double cpuUsable;

    /**
     * 메모리 사용 가능량
     */
    @JsonProperty("mem_usable")
    @Schema(description = "메모리 사용 가능량", example = "975.24")
    private Double memUsable;

    /**
     * GPU 사용 가능량
     */
    @JsonProperty("gpu_usable")
    @Schema(description = "GPU 사용 가능량", example = "6")
    private Double gpuUsable;
}
