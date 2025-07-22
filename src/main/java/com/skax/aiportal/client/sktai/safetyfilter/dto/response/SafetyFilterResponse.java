package com.skax.aiportal.client.sktai.safetyfilter.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.safetyfilter.dto.BasePolicyPayload;
import com.skax.aiportal.client.sktai.safetyfilter.dto.ValidTagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 안전 필터 응답 DTO
 * 
 * 안전 필터 정보를 반환합니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFilterResponse {

    /**
     * 금지어
     */
    @JsonProperty("stopword")
    private String stopword;

    /**
     * 라벨
     */
    @JsonProperty("label")
    private String label;

    /**
     * 카테고리
     */
    @JsonProperty("category")
    private String category;

    /**
     * 예외 소스 목록
     */
    @JsonProperty("except_sources")
    private String exceptSources;

    /**
     * 유효 태그 타입
     */
    @JsonProperty("valid_tags")
    private ValidTagType validTags;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 안전 필터 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 정책
     */
    @JsonProperty("policy")
    private List<BasePolicyPayload> policy;
}
