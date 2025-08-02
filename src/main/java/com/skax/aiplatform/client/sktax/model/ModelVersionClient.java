package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelVersionCreateRequest;
import com.skax.aiplatform.client.sktax.model.dto.request.ModelVersionUpdateRequest;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelVersionReadResponse;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelVersionsReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Model API - Model Versions Feign Client
 * 모델 버전 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-model-version-client", 
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ModelVersionClient {

    /**
     * 모델 버전 등록
     */
    @PostMapping("/api/v1/models/{model_id}/versions")
    ModelVersionReadResponse registerModelVersion(
        @PathVariable("model_id") UUID modelId,
        @RequestBody ModelVersionCreateRequest request
    );

    /**
     * 모델 버전 목록 조회
     */
    @GetMapping("/api/v1/models/{model_id}/versions")
    ModelVersionsReadResponse readModelVersions(
        @PathVariable("model_id") UUID modelId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * 모델 버전 상세 조회
     */
    @GetMapping("/api/v1/models/{model_id}/versions/{version_id}")
    ModelVersionReadResponse readModelVersion(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("version_id") UUID versionId
    );

    /**
     * 모델 버전 수정
     */
    @PutMapping("/api/v1/models/{model_id}/versions/{version_id}")
    ModelVersionReadResponse editModelVersion(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("version_id") UUID versionId,
        @RequestBody ModelVersionUpdateRequest request
    );

    /**
     * 모델 버전 삭제 (삭제 플래그 설정)
     */
    @DeleteMapping("/api/v1/models/{model_id}/versions/{version_id}")
    void removeModelVersion(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("version_id") UUID versionId
    );

    /**
     * 모델 버전 복구
     */
    @PostMapping("/api/v1/models/{model_id}/versions/{version_id}/recovery")
    void recoveryModelVersion(
        @PathVariable("model_id") UUID modelId,
        @PathVariable("version_id") UUID versionId
    );
}
