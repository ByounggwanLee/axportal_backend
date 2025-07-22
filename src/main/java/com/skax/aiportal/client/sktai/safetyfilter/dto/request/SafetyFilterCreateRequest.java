package com.skax.aiportal.client.sktai.safetyfilter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.safetyfilter.dto.BasePolicyPayload;
import com.skax.aiportal.client.sktai.safetyfilter.dto.ValidTagType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 안전 필터 생성 요청 DTO
 * 
 * 새로운 안전 필터를 생성하기 위한 요청 정보를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SafetyFilterCreateRequest {

    /**
     * 금지어 (필수)
     */
    @NotBlank(message = "금지어는 필수입니다")
    @Size(max = 255, message = "금지어는 255자 이하여야 합니다")
    @JsonProperty("stopword")
    private String stopword;

    /**
     * 라벨 (기본값: unsafe_user_defined)
     */
    @Size(max = 255, message = "라벨은 255자 이하여야 합니다")
    @JsonProperty("label")
    private String label;

    /**
     * 카테고리 (선택사항)
     */
    @Size(max = 255, message = "카테고리는 255자 이하여야 합니다")
    @JsonProperty("category")
    private String category;

    /**
     * 예외 소스 목록 (선택사항)
     */
    @Size(max = 255, message = "예외 소스는 255자 이하여야 합니다")
    @JsonProperty("except_sources")
    private String exceptSources;

    /**
     * 유효 태그 타입 (기본값: ALL)
     */
    @JsonProperty("valid_tags")
    private ValidTagType validTags;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 정책 (필수)
     */
    @NotNull(message = "정책은 필수입니다")
    @JsonProperty("policy")
    private List<BasePolicyPayload> policy;
}
