package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Generator DTO
 * 
 * <p>데이터 생성기 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Generator {

    /**
     * 생성기 ID (필수)
     */
    @JsonProperty("id")
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 생성기명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 레지스트리 URL
     */
    @JsonProperty("registry_url")
    private String registryUrl;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 리소스 설정
     */
    @JsonProperty("resource")
    private Object resource;

    /**
     * 삭제 여부 (필수)
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 생성일시 (필수)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (필수)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
