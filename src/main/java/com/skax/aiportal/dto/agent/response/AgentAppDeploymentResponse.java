package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 배포 응답 DTO
 * 
 * <p>Agent 애플리케이션 배포 정보를 담는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentAppDeploymentResponse {

    /**
     * 배포 ID
     */
    private String id;

    /**
     * App ID
     */
    private String appId;

    /**
     * 배포 버전
     */
    private String version;

    /**
     * 버전 설명
     */
    private String versionDescription;

    /**
     * 배포 상태
     */
    private String status;

    /**
     * 대상 타입
     */
    private String targetType;

    /**
     * 이미지 정보
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
     * 현재 복제본 수
     */
    private Integer currentReplicas;

    /**
     * 생성자
     */
    private String createdBy;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;
}
