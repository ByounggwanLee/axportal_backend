package com.skax.aiportal.client.sktai.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 서빙 모델 뷰 응답 DTO
 * 
 * 서빙 가능한 모델 정보에 대한 응답 데이터를 담습니다.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServingModelViewResponse {

    /**
     * 모델 ID
     */
    @JsonProperty("id")
    private String id;

    /**
     * 모델 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 모델 타입
     */
    @JsonProperty("model_type")
    private String modelType;

    /**
     * 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 모델 크기
     */
    @JsonProperty("model_size")
    private String modelSize;

    /**
     * 매개변수 수
     */
    @JsonProperty("parameter_count")
    private String parameterCount;

    /**
     * 버전 목록
     */
    @JsonProperty("versions")
    private java.util.List<ModelVersionInfo> versions;

    /**
     * 라벨
     */
    @JsonProperty("labels")
    private Object labels;

    /**
     * 생성일시
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * 수정일시
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * 모델 버전 정보
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ModelVersionInfo {

        /**
         * 버전 ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 버전 번호
         */
        @JsonProperty("version")
        private String version;

        /**
         * 설명
         */
        @JsonProperty("description")
        private String description;

        /**
         * 상태
         */
        @JsonProperty("status")
        private String status;

        /**
         * 생성일시
         */
        @JsonProperty("created_at")
        private String createdAt;

        /**
         * 기본 버전 여부
         */
        @JsonProperty("is_default")
        private Boolean isDefault;
    }
}
