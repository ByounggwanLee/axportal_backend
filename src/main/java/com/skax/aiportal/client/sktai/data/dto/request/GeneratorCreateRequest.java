package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 데이터 생성기 생성 요청 DTO
 * 
 * <p>SKT AI 플랫폼에서 새로운 데이터 생성기를 생성할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorCreateRequest {

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
     * 생성기 설명
     */
    private String description;

    /**
     * 리소스 정보
     * CPU, 메모리, GPU 할당량을 JSON 객체 형태로 지정
     */
    private Object resource;

    /**
     * 생성기 이름
     */
    @NotBlank(message = "생성기 이름은 필수입니다")
    private String name;

    /**
     * 생성자
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 정책 페이로드
     */
    private Object policy;
}
