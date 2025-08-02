package com.skax.aiplatform.client.sktax.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.model.dto.ServingTypeEnum;
import com.skax.aiplatform.client.sktax.model.dto.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Size;
import java.util.UUID;

/**
 * 모델 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelUpdateRequest {

    /**
     * 모델 표시명
     */
    @JsonProperty("display_name")
    @Size(max = 255, message = "모델 표시명은 255자를 초과할 수 없습니다")
    private String displayName;

    /**
     * 모델명 (관리용)
     */
    @JsonProperty("name")
    @Size(max = 255, message = "모델명은 255자를 초과할 수 없습니다")
    private String name;

    /**
     * 모델 타입
     */
    @JsonProperty("type")
    @Builder.Default
    private TypeEnum type = TypeEnum.LANGUAGE;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 모델 크기
     */
    @JsonProperty("size")
    @Size(max = 64, message = "모델 크기는 64자를 초과할 수 없습니다")
    private String size;

    /**
     * 토큰 크기
     */
    @JsonProperty("token_size")
    @Size(max = 64, message = "토큰 크기는 64자를 초과할 수 없습니다")
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
    @Size(max = 64, message = "데이터 타입은 64자를 초과할 수 없습니다")
    private String dtype;

    /**
     * 서빙 타입
     */
    @JsonProperty("serving_type")
    @Builder.Default
    private ServingTypeEnum servingType = ServingTypeEnum.SERVERLESS;

    /**
     * 비공개 여부
     */
    @JsonProperty("is_private")
    @Builder.Default
    private Boolean isPrivate = false;

    /**
     * 유효 여부
     */
    @JsonProperty("is_valid")
    @Builder.Default
    private Boolean isValid = true;

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
    @Size(max = 255, message = "경로는 255자를 초과할 수 없습니다")
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
}
