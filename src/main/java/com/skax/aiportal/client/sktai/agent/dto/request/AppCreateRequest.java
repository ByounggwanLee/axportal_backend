package com.skax.aiportal.client.sktai.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Agent App 생성 요청 DTO
 * 
 * <p>SKT AI Agent 플랫폼에서 새로운 앱을 생성하기 위한 요청 정보를 담는 객체입니다.
 * 앱의 기본 정보, 배포 설정, 그래프 정보 등을 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "Agent App 생성 요청",
    description = "SKT AI Agent 플랫폼에서 새로운 앱을 생성하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppCreateRequest {

    /**
     * 앱 이름
     * 
     * <p>생성할 앱의 이름입니다.</p>
     */
    @Schema(
        description = "앱 이름",
        example = "AI 챗봇 앱",
        requiredMode = Schema.RequiredMode.REQUIRED,
        maxLength = 100
    )
    @NotBlank(message = "앱 이름은 필수입니다.")
    @Size(max = 100, message = "앱 이름은 100자를 초과할 수 없습니다.")
    private String name;

    /**
     * 앱 설명
     * 
     * <p>앱의 용도와 기능에 대한 설명입니다.</p>
     */
    @Schema(
        description = "앱 설명",
        example = "고객 상담을 위한 AI 챗봇 애플리케이션",
        maxLength = 500
    )
    @Size(max = 500, message = "앱 설명은 500자를 초과할 수 없습니다.")
    private String description;

    /**
     * 버전 설명
     * 
     * <p>앱 버전에 대한 설명입니다.</p>
     */
    @Schema(
        description = "버전 설명",
        example = "초기 버전 - 기본 대화 기능",
        maxLength = 255
    )
    @JsonProperty("version_description")
    @Size(max = 255, message = "버전 설명은 255자를 초과할 수 없습니다.")
    private String versionDescription;

    /**
     * 배포 대상 ID (agent, tool 등)
     * 
     * <p>앱이 배포될 대상의 고유 식별자입니다.</p>
     */
    @Schema(
        description = "배포 대상 ID (agent, tool 등)",
        example = "agent-12345",
        maxLength = 50
    )
    @JsonProperty("target_id")
    private String targetId;

    /**
     * 배포 대상 타입 (agent_graph, agent_form)
     * 
     * <p>배포 대상의 타입을 지정합니다.</p>
     */
    @Schema(
        description = "배포 대상 타입",
        example = "agent_graph",
        allowableValues = {"agent_graph", "agent_form"}
    )
    @JsonProperty("target_type")
    private String targetType;

    /**
     * 서빙 타입 (shared, standalone)
     * 
     * <p>앱의 서빙 방식을 지정합니다.</p>
     */
    @Schema(
        description = "서빙 타입",
        example = "shared",
        allowableValues = {"shared", "standalone"},
        defaultValue = "shared"
    )
    @JsonProperty("serving_type")
    @Builder.Default
    private String servingType = "shared";

    /**
     * CPU 요청량
     * 
     * <p>컨테이너에서 요청할 CPU 리소스량입니다 (millicores).</p>
     */
    @Schema(
        description = "CPU 요청량 (millicores)",
        example = "500",
        minimum = "100",
        maximum = "4000"
    )
    @JsonProperty("cpu_request")
    private Integer cpuRequest;

    /**
     * CPU 제한량
     * 
     * <p>컨테이너에서 사용할 수 있는 최대 CPU 리소스량입니다 (millicores).</p>
     */
    @Schema(
        description = "CPU 제한량 (millicores)",
        example = "1000",
        minimum = "100",
        maximum = "8000"
    )
    @JsonProperty("cpu_limit")
    private Integer cpuLimit;

    /**
     * 메모리 요청량
     * 
     * <p>컨테이너에서 요청할 메모리 리소스량입니다 (MiB).</p>
     */
    @Schema(
        description = "메모리 요청량 (MiB)",
        example = "256",
        minimum = "128",
        maximum = "4096"
    )
    @JsonProperty("mem_request")
    private Integer memRequest;

    /**
     * 메모리 제한량
     * 
     * <p>컨테이너에서 사용할 수 있는 최대 메모리 리소스량입니다 (MiB).</p>
     */
    @Schema(
        description = "메모리 제한량 (MiB)",
        example = "512",
        minimum = "128",
        maximum = "8192"
    )
    @JsonProperty("mem_limit")
    private Integer memLimit;

    /**
     * GPU 요청량
     * 
     * <p>컨테이너에서 요청할 GPU 리소스량입니다.</p>
     */
    @Schema(
        description = "GPU 요청량",
        example = "0",
        minimum = "0",
        maximum = "4"
    )
    @JsonProperty("gpu_request")
    private Integer gpuRequest;

    /**
     * GPU 제한량
     * 
     * <p>컨테이너에서 사용할 수 있는 최대 GPU 리소스량입니다.</p>
     */
    @Schema(
        description = "GPU 제한량",
        example = "1",
        minimum = "0",
        maximum = "8"
    )
    @JsonProperty("gpu_limit")
    private Integer gpuLimit;

    /**
     * 최소 복제본 수
     * 
     * <p>자동 스케일링 시 유지할 최소 인스턴스 수입니다.</p>
     */
    @Schema(
        description = "최소 복제본 수",
        example = "1",
        minimum = "0",
        maximum = "10"
    )
    @JsonProperty("min_replicas")
    private Integer minReplicas;

    /**
     * 최대 복제본 수
     * 
     * <p>자동 스케일링 시 확장할 최대 인스턴스 수입니다.</p>
     */
    @Schema(
        description = "최대 복제본 수",
        example = "3",
        minimum = "1",
        maximum = "20"
    )
    @JsonProperty("max_replicas")
    private Integer maxReplicas;

    /**
     * 코어당 워커 수
     * 
     * <p>CPU 코어당 생성할 워커 프로세스의 수입니다.</p>
     */
    @Schema(
        description = "코어당 워커 수",
        example = "3",
        minimum = "1",
        maximum = "10",
        defaultValue = "3"
    )
    @JsonProperty("workers_per_core")
    @Builder.Default
    private Integer workersPerCore = 3;
}
