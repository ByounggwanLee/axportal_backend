package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Tool 응답 DTO
 * 
 * <p>Agent Tool 정보를 담는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentToolResponse {

    /**
     * Tool ID
     */
    private String id;

    /**
     * Tool 이름
     */
    private String name;

    /**
     * Tool 설명
     */
    private String description;

    /**
     * Tool 타입
     */
    private String toolType;

    /**
     * Tool 구성 정보 (JSON 형태)
     */
    private String configuration;

    /**
     * Tool 스키마 정보 (JSON 형태)
     */
    private String schema;

    /**
     * 활성화 여부
     */
    private Boolean enabled;

    /**
     * 공개 여부
     */
    private Boolean isPublic;

    /**
     * 태그 목록
     */
    private List<String> tags;

    /**
     * Tool 상태
     */
    private String status;

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    private String createdBy;

    /**
     * 수정자
     */
    private String updatedBy;

    /**
     * 버전 정보
     */
    private String version;

    /**
     * 사용 횟수
     */
    private Long usageCount;
}
