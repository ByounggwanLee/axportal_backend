package com.skax.aiplatform.client.sktax.resource.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Namespace 정보
 * 
 * <p>Namespace의 기본 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Namespace 정보")
public class Namespace {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID", example = "629b5f03-d2bc-405b-b601-73168fc92e73")
    private String projectId;

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu_quota")
    @NotNull
    @Schema(description = "CPU 할당량", example = "4")
    private Double cpuQuota;

    /**
     * 메모리 할당량
     */
    @JsonProperty("mem_quota")
    @NotNull
    @Schema(description = "메모리 할당량", example = "32")
    private Double memQuota;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu_quota")
    @NotNull
    @Schema(description = "GPU 할당량", example = "1")
    private Double gpuQuota;

    /**
     * Namespace ID
     */
    @JsonProperty("id")
    @Schema(description = "Namespace ID", example = "361a7756-104b-4c6f-8c17-5265f34de8c3")
    private String id;

    /**
     * Namespace 이름
     */
    @JsonProperty("name")
    @Schema(description = "Namespace 이름", example = "ns-629b5f03-d2bc-405b-b601-73168fc92e73")
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
    @Schema(description = "설명", example = "test")
    private String description;

    /**
     * 생성자
     */
    @JsonProperty("creator")
    @NotNull
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
    @Schema(description = "생성일시", example = "2024-09-30T11:13:35.841000")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("modified_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @Schema(description = "수정일시", example = "2024-10-02T11:34:50.050624")
    private LocalDateTime modifiedAt;
}
