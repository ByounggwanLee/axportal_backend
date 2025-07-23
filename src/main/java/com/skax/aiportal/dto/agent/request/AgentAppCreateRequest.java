package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 생성 요청 DTO
 * 
 * <p>Agent 애플리케이션 생성을 위한 요청 데이터를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentAppCreateRequest {

    /**
     * 앱 이름
     */
    @NotBlank(message = "앱 이름은 필수입니다")
    private String name;

    /**
     * 앱 설명
     */
    private String description;

    /**
     * 버전 설명
     */
    private String versionDescription;

    /**
     * 대상 타입 (agent_graph, external_graph)
     */
    private String targetType;

    /**
     * 모델 목록
     */
    @NotEmpty(message = "최소 하나의 모델이 필요합니다")
    private String[] modelList;

    /**
     * 서빙 타입
     */
    private String servingType;

    /**
     * 레지스트리 URL
     */
    @NotBlank(message = "레지스트리 URL은 필수입니다")
    private String registryUrl;

    /**
     * 이미지 태그
     */
    @NotBlank(message = "이미지 태그는 필수입니다")
    private String imageTag;

    /**
     * CPU 요청량
     */
    private Integer cpuRequest;

    /**
     * CPU 제한량
     */
    private Integer cpuLimit;

    /**
     * 메모리 요청량
     */
    private Integer memRequest;

    /**
     * 메모리 제한량
     */
    private Integer memLimit;

    /**
     * 최소 복제본 수
     */
    private Integer minReplicas;

    /**
     * 최대 복제본 수
     */
    private Integer maxReplicas;

    /**
     * 코어당 워커 수
     */
    private Integer workersPerCore;
}
