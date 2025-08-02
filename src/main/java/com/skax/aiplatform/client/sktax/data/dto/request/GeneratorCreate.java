package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Generator 생성 요청 DTO
 * 
 * <p>새로운 데이터 생성기를 생성하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorCreate {

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
     * 생성기명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 생성한 사용자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책
     */
    @JsonProperty("policy")
    private PolicyPayload policy;
}
