package com.skax.aiportal.client.sktai.model;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.model.dto.request.ModelPromoteRequest;
import com.skax.aiportal.client.sktai.model.dto.request.ModelVersionCreateRequest;
import com.skax.aiportal.client.sktai.model.dto.request.ModelVersionUpdateRequest;
import com.skax.aiportal.client.sktai.model.dto.response.ModelReadResponse;
import com.skax.aiportal.client.sktai.model.dto.response.ModelResponse;
import com.skax.aiportal.client.sktai.model.dto.response.ModelVersionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI Model API - 모델 버전 관리 Feign 클라이언트
 * 모델 버전 생성, 조회, 수정, 삭제, 프로모션
 */
@FeignClient(
    name = "skt-ai-model-version",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelVersionClient {
    
    /**
     * 모델 버전 생성
     */
    @PostMapping("/api/v1/models/{modelId}/versions")
    ModelVersionResponse createModelVersion(
        @PathVariable("modelId") String modelId,
        @RequestBody ModelVersionCreateRequest request
    );
    
    /**
     * 모델의 버전 목록 조회
     */
    @GetMapping("/api/v1/models/{modelId}/versions")
    ModelResponse<List<ModelVersionResponse>> getModelVersions(
        @PathVariable("modelId") String modelId,
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "10") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search,
        @RequestParam(name = "ids", required = false) String ids
    );
    
    /**
     * 특정 버전 조회 (버전 ID로)
     */
    @GetMapping("/api/v1/models/versions/{versionId}")
    ModelVersionResponse getVersion(@PathVariable("versionId") String versionId);
    
    /**
     * 모델의 특정 버전 조회
     */
    @GetMapping("/api/v1/models/{modelId}/versions/{versionId}")
    ModelVersionResponse getModelVersion(
        @PathVariable("modelId") String modelId,
        @PathVariable("versionId") String versionId
    );
    
    /**
     * 모델 버전 수정
     */
    @PutMapping("/api/v1/models/{modelId}/versions/{versionId}")
    ModelVersionResponse updateModelVersion(
        @PathVariable("modelId") String modelId,
        @PathVariable("versionId") String versionId,
        @RequestBody ModelVersionUpdateRequest request
    );
    
    /**
     * 모델 버전 삭제
     */
    @DeleteMapping("/api/v1/models/{modelId}/versions/{versionId}")
    void deleteModelVersion(
        @PathVariable("modelId") String modelId,
        @PathVariable("versionId") String versionId
    );
    
    /**
     * 버전을 베이스 모델로 프로모션
     */
    @PutMapping("/api/v1/models/versions/{versionId}/promote")
    ModelReadResponse promoteVersionToBaseModel(
        @PathVariable("versionId") String versionId,
        @RequestBody ModelPromoteRequest request
    );
}
