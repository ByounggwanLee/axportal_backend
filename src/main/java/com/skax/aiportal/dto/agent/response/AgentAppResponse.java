package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 응답 DTO
 * 
 * <p>Agent 애플리케이션 정보를 담는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentAppResponse {

    /**
     * App ID
     */
    private String id;

    /**
     * 앱 이름
     */
    private String name;

    /**
     * 앱 설명
     */
    private String description;

    /**
     * 대상 타입
     */
    private String targetType;

    /**
     * 모델 목록
     */
    private List<String> modelList;

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

    /**
     * 상태
     */
    private String status;

    /**
     * 버전
     */
    private String version;

    /**
     * 생성자
     */
    private String createdBy;

    /**
     * 수정자
     */
    private String updatedBy;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;

    /**
     * 삭제 여부
     */
    private Boolean isDeleted;
}
