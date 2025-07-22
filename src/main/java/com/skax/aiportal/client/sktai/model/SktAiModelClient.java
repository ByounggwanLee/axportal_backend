package com.skax.aiportal.client.sktai.model;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.model.dto.request.*;
import com.skax.aiportal.client.sktai.model.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model API - 모델 관리 Feign 클라이언트
 * 모델 생성, 조회, 수정, 삭제 및 모델 속성 관리
 */
@FeignClient(
    name = "skt-ai-model",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelClient {
    
    /**
     * 모델 생성
     */
    @PostMapping("/api/v1/models")
    ModelReadResponse createModel(@RequestBody ModelCreateRequest request);
    
    /**
     * 모델 목록 조회
     */
    @GetMapping("/api/v1/models")
    ModelResponse<List<ModelReadResponse>> getModels(
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "10") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search,
        @RequestParam(name = "ids", required = false) String ids
    );
    
    /**
     * 모델 상세 조회
     */
    @GetMapping("/api/v1/models/{modelId}")
    ModelReadResponse getModel(@PathVariable("modelId") String modelId);
    
    /**
     * 모델 수정
     */
    @PutMapping("/api/v1/models/{modelId}")
    ModelReadResponse updateModel(
        @PathVariable("modelId") String modelId,
        @RequestBody ModelUpdateRequest request
    );
    
    /**
     * 모델 삭제 (소프트 삭제)
     */
    @DeleteMapping("/api/v1/models/{modelId}")
    void deleteModel(@PathVariable("modelId") String modelId);
    
    /**
     * 모델 복구
     */
    @PutMapping("/api/v1/models/{modelId}/recovery")
    void recoverModel(@PathVariable("modelId") String modelId);
    
    /**
     * 모델에 태그 추가
     */
    @PutMapping("/api/v1/models/{modelId}/tags")
    ModelReadResponse addTagsToModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelTagRequest> tags
    );
    
    /**
     * 모델에서 태그 제거
     */
    @DeleteMapping("/api/v1/models/{modelId}/tags")
    ModelReadResponse removeTagsFromModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelTagRequest> tags
    );
    
    /**
     * 모델에 태스크 추가
     */
    @PutMapping("/api/v1/models/{modelId}/tasks")
    ModelReadResponse addTasksToModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelTaskRequest> tasks
    );
    
    /**
     * 모델에서 태스크 제거
     */
    @DeleteMapping("/api/v1/models/{modelId}/tasks")
    ModelReadResponse removeTasksFromModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelTaskRequest> tasks
    );
    
    /**
     * 모델에 언어 추가
     */
    @PutMapping("/api/v1/models/{modelId}/languages")
    ModelReadResponse addLanguagesToModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelLanguageRequest> languages
    );
    
    /**
     * 모델에서 언어 제거
     */
    @DeleteMapping("/api/v1/models/{modelId}/languages")
    ModelReadResponse removeLanguagesFromModel(
        @PathVariable("modelId") String modelId,
        @RequestBody List<ModelLanguageRequest> languages
    );
    
    /**
     * 모델 타입 목록 조회
     */
    @GetMapping("/api/v1/models/types")
    Object getModelTypes();
    
    /**
     * 모델 태그 목록 조회
     */
    @GetMapping("/api/v1/models/tags")
    Object getModelTags();
    
    /**
     * 하드 삭제 (실제 삭제)
     */
    @PostMapping("/api/v1/models/hard-delete")
    Object hardDeleteModels();
}
