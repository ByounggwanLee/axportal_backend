package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.ModelLanguageBase;
import com.skax.aiplatform.client.sktax.model.dto.ModelTagBase;
import com.skax.aiplatform.client.sktax.model.dto.ModelTaskBase;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelCreateRequest;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelUpdateRequest;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelReadResponse;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelsReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * SKT AX Model API - Models Feign Client
 * 모델 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-model-client",
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ModelClient {

    /**
     * 모델 등록
     */
    @PostMapping("/api/v1/models")
    ModelReadResponse registerModel(@RequestBody ModelCreateRequest request);

    /**
     * 모델 목록 조회
     */
    @GetMapping("/api/v1/models")
    ModelsReadResponse readModels(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "ids", required = false) String ids
    );

    /**
     * 모델 상세 조회
     */
    @GetMapping("/api/v1/models/{model_id}")
    ModelReadResponse readModel(@PathVariable("model_id") UUID modelId);

    /**
     * 모델 수정
     */
    @PutMapping("/api/v1/models/{model_id}")
    ModelReadResponse editModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody ModelUpdateRequest request
    );

    /**
     * 모델 삭제 (삭제 플래그 설정)
     */
    @DeleteMapping("/api/v1/models/{model_id}")
    void removeModel(@PathVariable("model_id") UUID modelId);

    /**
     * 모델 복구
     */
    @PutMapping("/api/v1/models/{model_id}/recovery")
    void recoverModel(@PathVariable("model_id") UUID modelId);

    /**
     * 모델에 태그 추가
     */
    @PutMapping("/api/v1/models/{model_id}/tags")
    ModelReadResponse addTagsToModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelTagBase> tags
    );

    /**
     * 모델에서 태그 제거
     */
    @DeleteMapping("/api/v1/models/{model_id}/tags")
    ModelReadResponse removeTagsFromModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelTagBase> tags
    );

    /**
     * 모델에 태스크 추가
     */
    @PutMapping("/api/v1/models/{model_id}/tasks")
    ModelReadResponse addTasksToModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelTaskBase> tasks
    );

    /**
     * 모델에서 태스크 제거
     */
    @DeleteMapping("/api/v1/models/{model_id}/tasks")
    ModelReadResponse removeTasksFromModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelTaskBase> tasks
    );

    /**
     * 모델에 언어 추가
     */
    @PutMapping("/api/v1/models/{model_id}/languages")
    ModelReadResponse addLanguagesToModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelLanguageBase> languages
    );

    /**
     * 모델에서 언어 제거
     */
    @DeleteMapping("/api/v1/models/{model_id}/languages")
    ModelReadResponse removeLanguagesFromModel(
        @PathVariable("model_id") UUID modelId,
        @RequestBody List<ModelLanguageBase> languages
    );

    /**
     * 모델 타입 목록 조회
     */
    @GetMapping("/api/v1/models/types")
    Object readModelTypes();

    /**
     * 모델 태그 목록 조회
     */
    @GetMapping("/api/v1/models/tags")
    Object readModelTags();

    /**
     * 하드 삭제 (삭제 표시된 모델들을 완전히 삭제)
     */
    @PostMapping("/api/v1/models/hard-delete")
    Object hardRemoveModel();
}
