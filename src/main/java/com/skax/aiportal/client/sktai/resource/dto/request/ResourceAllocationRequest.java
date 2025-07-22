package com.skax.aiportal.client.sktai.resource.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceAllocationRequest {

    @JsonProperty("resource_id")
    private String resourceId;

    @JsonProperty("allocation_type")
    private String allocationType;

    @JsonProperty("target_id")
    private String targetId;

    @JsonProperty("target_type")
    private String targetType;

    @JsonProperty("allocation_config")
    private AllocationConfig allocationConfig;

    @JsonProperty("duration_hours")
    private Integer durationHours;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AllocationConfig {

        @JsonProperty("cpu_allocation")
        private Double cpuAllocation;

        @JsonProperty("memory_allocation")
        private Double memoryAllocation;

        @JsonProperty("gpu_allocation")
        private Double gpuAllocation;

        @JsonProperty("storage_allocation")
        private Double storageAllocation;

        @JsonProperty("exclusive_access")
        private Boolean exclusiveAccess;

        @JsonProperty("preemptible")
        private Boolean preemptible;
    }
}
