package com.skax.aiportal.client.sktai.resource.dto.response;

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
public class ResourceAllocationResponse {

    @JsonProperty("allocation_id")
    private String allocationId;

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

    @JsonProperty("status")
    private String status;

    @JsonProperty("duration_hours")
    private Integer durationHours;

    @JsonProperty("elapsed_hours")
    private Double elapsedHours;

    @JsonProperty("remaining_hours")
    private Double remainingHours;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("usage_stats")
    private AllocationUsageStats usageStats;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("allocated_by")
    private String allocatedBy;

    @JsonProperty("allocated_at")
    private String allocatedAt;

    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("released_at")
    private String releasedAt;

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

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AllocationUsageStats {

        @JsonProperty("cpu_usage_hours")
        private Double cpuUsageHours;

        @JsonProperty("memory_usage_hours")
        private Double memoryUsageHours;

        @JsonProperty("gpu_usage_hours")
        private Double gpuUsageHours;

        @JsonProperty("storage_usage_hours")
        private Double storageUsageHours;

        @JsonProperty("total_cost")
        private Double totalCost;

        @JsonProperty("efficiency_score")
        private Double efficiencyScore;
    }
}
