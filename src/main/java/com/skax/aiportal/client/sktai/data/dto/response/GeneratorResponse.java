package com.skax.aiportal.client.sktai.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 데이터 생성기 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터 생성기 정보를 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
public class GeneratorResponse {

    /**
     * 생성기 ID
     */
    private String id;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 생성기 이름
     */
    private String name;

    /**
     * 레지스트리 URL
     */
    @JsonProperty("registry_url")
    private String registryUrl;

    /**
     * 생성기 설명
     */
    private String description;

    /**
     * 리소스 정보
     */
    private Object resource;

    /**
     * 삭제 여부
     */
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

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
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @JsonProperty("updated_by")
    private String updatedBy;
}
