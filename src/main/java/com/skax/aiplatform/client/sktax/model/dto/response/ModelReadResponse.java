package com.skax.aiplatform.client.sktax.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.model.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 모델 조회 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelReadResponse {

    /**
     * 모델 표시명
     */
    @JsonProperty("display_name")
    private String displayName;

    /**
     * 모델명 (관리용)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 모델 타입
     */
    @JsonProperty("type")
    private TypeEnum type;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 모델 크기
     */
    @JsonProperty("size")
    private String size;

    /**
     * 토큰 크기
     */
    @JsonProperty("token_size")
    private String tokenSize;

    /**
     * 추론 파라미터
     */
    @JsonProperty("inference_param")
    private Object inferenceParam;

    /**
     * 양자화 정보
     */
    @JsonProperty("quantization")
    private Object quantization;

    /**
     * 데이터 타입
     */
    @JsonProperty("dtype")
    private String dtype;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    private ServingTypeEnum servingType;

    /**
     * 비공개 여부
     */
    @JsonProperty("is_private")
    private Boolean isPrivate;

    /**
     * 유효 여부
     */
    @JsonProperty("is_valid")
    private Boolean isValid;

    /**
     * 라이선스
     */
    @JsonProperty("license")
    private String license;

    /**
     * README
     */
    @JsonProperty("readme")
    private String readme;

    /**
     * 모델 파일 경로
     */
    @JsonProperty("path")
    private String path;

    /**
     * 제공자 ID
     */
    @JsonProperty("provider_id")
    private UUID providerId;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 기본 파라미터
     */
    @JsonProperty("default_params")
    private Object defaultParams;

    /**
     * 최신 버전
     */
    @JsonProperty("last_version")
    private Integer lastVersion;

    /**
     * ID
     */
    @JsonProperty("id")
    private UUID id;

    /**
     * 제공자명
     */
    @JsonProperty("provider_name")
    private String providerName;

    /**
     * 지원 언어 목록
     */
    @JsonProperty("languages")
    @Builder.Default
    private List<ModelLanguageBase> languages = List.of();

    /**
     * 태스크 목록
     */
    @JsonProperty("tasks")
    @Builder.Default
    private List<ModelTaskBase> tasks = List.of();

    /**
     * 태그 목록
     */
    @JsonProperty("tags")
    @Builder.Default
    private List<ModelTagBase> tags = List.of();

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
}
