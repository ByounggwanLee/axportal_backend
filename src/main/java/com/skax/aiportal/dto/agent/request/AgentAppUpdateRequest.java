package com.skax.aiportal.dto.agent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 수정 요청 DTO
 * 
 * <p>Agent 애플리케이션 수정을 위한 요청 데이터를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentAppUpdateRequest {

    /**
     * 앱 이름
     */
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
    private String[] modelList;

    /**
     * 서빙 타입
     */
    private String servingType;

    /**
     * 레지스트리 URL
     */
    private String registryUrl;

    /**
     * 이미지 태그
     */
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
