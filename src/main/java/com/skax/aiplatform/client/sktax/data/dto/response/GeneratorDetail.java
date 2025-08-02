package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Generator 상세 정보 응답 DTO
 * 
 * <p>데이터 생성기의 상세 정보를 담는 응답 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorDetail {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

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
     * <p>훈련에 필요한 리소스 정보를 입력합니다. JSON 객체 형식으로 `cpu_quota`, `mem_quota`, `gpu_quota`를 지정하세요.</p>
     */
    @JsonProperty("resource")
    private Object resource;

    /**
     * 생성기 ID (필수)
     */
    @JsonProperty("id")
    private String id;

    /**
     * 생성기명
     */
    @JsonProperty("name")
    private String name;

    /**
     * 생성한 사용자 (필수)
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 업데이트한 사용자 (필수)
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 생성일시 (기본값: 2025-05-27T15:58:33.358888)
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 업데이트일시 (기본값: 2025-05-27T15:58:33.358902)
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
