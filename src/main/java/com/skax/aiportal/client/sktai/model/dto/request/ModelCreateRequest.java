package com.skax.aiportal.client.sktai.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 모델 생성 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelCreateRequest {
    
    @JsonProperty("display_name")
    private String displayName;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("size")
    private String size;
    
    @JsonProperty("token_size")
    private String tokenSize;
    
    @JsonProperty("inference_param")
    private Map<String, Object> inferenceParam;
    
    @JsonProperty("quantization")
    private Map<String, Object> quantization;
    
    @JsonProperty("dtype")
    private String dtype;
    
    @JsonProperty("serving_type")
    private String servingType;
    
    @JsonProperty("is_private")
    private Boolean isPrivate;
    
    @JsonProperty("is_valid")
    private Boolean isValid;
    
    @JsonProperty("license")
    private String license;
    
    @JsonProperty("readme")
    private String readme;
    
    @JsonProperty("path")
    private String path;
    
    @JsonProperty("provider_id")
    private String providerId;
    
    @JsonProperty("project_id")
    private String projectId;
    
    @JsonProperty("default_params")
    private Map<String, Object> defaultParams;
    
    @JsonProperty("last_version")
    private Integer lastVersion;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("languages")
    private List<ModelLanguageRequest> languages;
    
    @JsonProperty("tasks")
    private List<ModelTaskRequest> tasks;
    
    @JsonProperty("tags")
    private List<ModelTagRequest> tags;
    
    @JsonProperty("policy")
    private List<Object> policy;
}
