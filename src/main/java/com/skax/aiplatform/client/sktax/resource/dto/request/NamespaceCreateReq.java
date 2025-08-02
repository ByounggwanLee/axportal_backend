package com.skax.aiplatform.client.sktax.resource.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 네임스페이스 생성 요청
 * 
 * <p>새로운 네임스페이스 생성을 위한 요청 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "네임스페이스 생성 요청")
public class NamespaceCreateReq {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    @Schema(description = "프로젝트 ID", example = "629b5f03-d2bc-405b-b601-73168fc92e73", required = true)
    private String projectId;

    /**
     * CPU 할당량
     */
    @JsonProperty("cpu_quota")
    @Schema(description = "CPU 할당량", example = "4", required = true)
    private Double cpuQuota;

    /**
     * 메모리 할당량
     */
    @JsonProperty("mem_quota")
    @Schema(description = "메모리 할당량", example = "16", required = true)
    private Double memQuota;

    /**
     * GPU 할당량
     */
    @JsonProperty("gpu_quota")
    @Schema(description = "GPU 할당량", example = "1", required = true)
    private Double gpuQuota;

    /**
     * 프라이빗 볼륨명
     */
    @JsonProperty("private_volume_name")
    @Schema(description = "프라이빗 볼륨명", example = "private1")
    private String privateVolumeName;
}
