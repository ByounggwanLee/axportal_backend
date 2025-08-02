package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Generator 기본 DTO
 * 
 * <p>데이터 생성기의 기본 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorBase {

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
}
