package com.skax.aiportal.client.sktai.resource.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponse {

    @JsonProperty("resource_id")
    private String resourceId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("resource_type")
    private String resourceType;

    @JsonProperty("config")
    private ResourceConfig config;

    @JsonProperty("quota_limits")
    private QuotaLimits quotaLimits;

    @JsonProperty("access_control")
    private AccessControl accessControl;

    @JsonProperty("monitoring_config")
    private MonitoringConfig monitoringConfig;

    @JsonProperty("status")
    private String status;

    @JsonProperty("health_status")
    private String healthStatus;

    @JsonProperty("usage_stats")
    private UsageStats usageStats;

    @JsonProperty("allocations")
    private List<AllocationInfo> allocations;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("enabled")
    private Boolean enabled;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResourceConfig {

        @JsonProperty("cpu_cores")
        private Integer cpuCores;

        @JsonProperty("memory_gb")
        private Integer memoryGb;

        @JsonProperty("gpu_count")
        private Integer gpuCount;

        @JsonProperty("gpu_type")
        private String gpuType;

        @JsonProperty("storage_gb")
        private Integer storageGb;

        @JsonProperty("network_bandwidth")
        private String networkBandwidth;

        @JsonProperty("availability_zone")
        private String availabilityZone;

        @JsonProperty("auto_scaling")
        private Boolean autoScaling;

        @JsonProperty("custom_properties")
        private Map<String, Object> customProperties;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuotaLimits {

        @JsonProperty("max_cpu_hours")
        private Integer maxCpuHours;

        @JsonProperty("max_memory_hours")
        private Integer maxMemoryHours;

        @JsonProperty("max_gpu_hours")
        private Integer maxGpuHours;

        @JsonProperty("max_storage_gb")
        private Integer maxStorageGb;

        @JsonProperty("max_concurrent_jobs")
        private Integer maxConcurrentJobs;

        @JsonProperty("daily_limit")
        private Integer dailyLimit;

        @JsonProperty("monthly_limit")
        private Integer monthlyLimit;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccessControl {

        @JsonProperty("public_access")
        private Boolean publicAccess;

        @JsonProperty("allowed_users")
        private List<String> allowedUsers;

        @JsonProperty("allowed_groups")
        private List<String> allowedGroups;

        @JsonProperty("permissions")
        private List<String> permissions;

        @JsonProperty("access_schedule")
        private AccessSchedule accessSchedule;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccessSchedule {

        @JsonProperty("start_time")
        private String startTime;

        @JsonProperty("end_time")
        private String endTime;

        @JsonProperty("timezone")
        private String timezone;

        @JsonProperty("allowed_days")
        private List<String> allowedDays;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonitoringConfig {

        @JsonProperty("metrics_enabled")
        private Boolean metricsEnabled;

        @JsonProperty("alerts_enabled")
        private Boolean alertsEnabled;

        @JsonProperty("threshold_cpu")
        private Double thresholdCpu;

        @JsonProperty("threshold_memory")
        private Double thresholdMemory;

        @JsonProperty("threshold_gpu")
        private Double thresholdGpu;

        @JsonProperty("notification_channels")
        private List<String> notificationChannels;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UsageStats {

        @JsonProperty("cpu_usage_percentage")
        private Double cpuUsagePercentage;

        @JsonProperty("memory_usage_percentage")
        private Double memoryUsagePercentage;

        @JsonProperty("gpu_usage_percentage")
        private Double gpuUsagePercentage;

        @JsonProperty("storage_usage_percentage")
        private Double storageUsagePercentage;

        @JsonProperty("current_allocations")
        private Integer currentAllocations;

        @JsonProperty("total_usage_hours")
        private Double totalUsageHours;

        @JsonProperty("cost_accumulated")
        private Double costAccumulated;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AllocationInfo {

        @JsonProperty("allocation_id")
        private String allocationId;

        @JsonProperty("target_id")
        private String targetId;

        @JsonProperty("target_type")
        private String targetType;

        @JsonProperty("allocation_type")
        private String allocationType;

        @JsonProperty("status")
        private String status;

        @JsonProperty("allocated_at")
        private String allocatedAt;

        @JsonProperty("expires_at")
        private String expiresAt;
    }
}
