package com.skax.aiportal.dto.agent.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent FewShots 응답 DTO
 * 
 * <p>Few-shot 예시 데이터 정보를 담는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentFewShotsResponse {

    /**
     * FewShots UUID
     */
    private String uuid;

    /**
     * 프로젝트 ID
     */
    private String projectId;

    /**
     * FewShots 이름
     */
    private String name;

    /**
     * FewShots 설명
     */
    private String description;

    /**
     * 태그 목록
     */
    private List<String> tags;

    /**
     * 현재 버전 ID
     */
    private String currentVersionId;

    /**
     * 버전 설명
     */
    private String versionDescription;

    /**
     * 예시 데이터 콘텐츠
     */
    private String content;

    /**
     * 예시 아이템 개수
     */
    private Integer itemCount;

    /**
     * 공개 여부
     */
    private Boolean isPublic;

    /**
     * 활성화 여부
     */
    private Boolean isActive;

    /**
     * 상태
     */
    private String status;

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
