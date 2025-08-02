package com.skax.aiplatform.client.sktax.resource.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Namespace 상세 정보
 * 
 * <p>Namespace의 상세 정보와 사용량을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Namespace 상세 정보")
public class NamespaceDetail {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID", example = "24ba585a-02fc-43d8-b9f1-f7ca9e020fe5")
    private String projectId;

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량", example = "128")
    private Double cpuQuota;

    /**
     * 메모리 할당량
     */
    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량", example = "512")
    private Double memQuota;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량", example = "16")
    private Double gpuQuota;

    /**
     * Namespace ID
     */
    @JsonProperty("id")
    @Schema(description = "Namespace ID", example = "604a645d-8c11-498a-9083-6ce477274b4c")
    private String id;

    /**
     * Namespace 이름
     */
    @JsonProperty("name")
    @Schema(description = "Namespace 이름", example = "ns-24ba585a-02fc-43d8-b9f1-f7ca9e020fe5")
    private String name;

    /**
     * 프라이빗 볼륨 이름
     */
    @JsonProperty("private_volume_name")
    @Schema(description = "프라이빗 볼륨 이름", example = "private1")
    private String privateVolumeName;

    /**
     * 설명
     */
    @JsonProperty("description")
    @Schema(description = "설명", example = "")
    private String description;

    /**
     * 생성자
     */
    @JsonProperty("creator")
    @Schema(description = "생성자", example = "postgres")
    private String creator;

    /**
     * 수정자
     */
    @JsonProperty("modifier")
    @Schema(description = "수정자", example = "postgres")
    private String modifier;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @Schema(description = "생성일시", example = "2024-10-14T22:45:50.555411")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("modified_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @Schema(description = "수정일시", example = "2024-12-16T13:02:22.308795")
    private LocalDateTime modifiedAt;

    /**
     * CPU 사용량
     */
    @JsonProperty("cpu_used")
    @Schema(description = "CPU 사용량", example = "40", required = true)
    private Double cpuUsed;

    /**
     * 메모리 사용량
     */
    @JsonProperty("mem_used")
    @Schema(description = "메모리 사용량", example = "108.03125", required = true)
    private Double memUsed;

    /**
     * GPU 사용량
     */
    @JsonProperty("gpu_used")
    @Schema(description = "GPU 사용량", example = "5", required = true)
    private Double gpuUsed;

    /**
     * CPU 사용 가능량
     */
    @JsonProperty("cpu_usable")
    @Schema(description = "CPU 사용 가능량", example = "88", required = true)
    private Double cpuUsable;

    /**
     * 메모리 사용 가능량
     */
    @JsonProperty("mem_usable")
    @Schema(description = "메모리 사용 가능량", example = "403.96875", required = true)
    private Double memUsable;

    /**
     * GPU 사용 가능량
     */
    @JsonProperty("gpu_usable")
    @Schema(description = "GPU 사용 가능량", example = "11", required = true)
    private Double gpuUsable;
}
