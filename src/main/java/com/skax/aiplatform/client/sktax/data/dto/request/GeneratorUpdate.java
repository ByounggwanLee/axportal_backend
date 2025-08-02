package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생성기 업데이트 요청 DTO
 * 
 * <p>기존 생성기를 수정할 때 사용하는 요청 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorUpdate {
    
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
     * 설명
     */
    @JsonProperty("description")
    private String description;
    
    /**
     * 생성기 타입
     */
    @JsonProperty("type")
    private String type;
    
    /**
     * 데이터셋 ID
     */
    @JsonProperty("dataset_id")
    private String datasetId;
    
    /**
     * 모델 ID
     */
    @JsonProperty("model_id")
    private String modelId;
    
    /**
     * 설정 정보
     */
    @JsonProperty("config")
    private Object config;
}
