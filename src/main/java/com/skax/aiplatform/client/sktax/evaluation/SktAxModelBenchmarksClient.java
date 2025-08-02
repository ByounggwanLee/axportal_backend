package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.ModelBenchmarkCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.request.ModelBenchmarkTaskFilesDeleteRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkListResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkResponse;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.ModelBenchmarkTaskFilesListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * SKT Ax Model Benchmarks API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-model-benchmarks",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxModelBenchmarksClient {

    /**
     * 모델 벤치마크 목록 조회
     */
    @GetMapping("/api/v1/model-benchmarks")
    ModelBenchmarkListResponse getModelBenchmarks(
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "20") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * 모델 벤치마크 생성
     */
    @PostMapping("/api/v1/model-benchmarks")
    ModelBenchmarkResponse createModelBenchmark(@RequestBody ModelBenchmarkCreateRequest request);

    /**
     * 모델 벤치마크 상세 조회
     */
    @GetMapping("/api/v1/model-benchmarks/{id}")
    ModelBenchmarkResponse getModelBenchmark(@PathVariable Integer id);

    /**
     * 모델 벤치마크 태스크 파일 업로드
     */
    @PostMapping(value = "/api/v1/model-benchmarks/{id}/task-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void uploadModelBenchmarkTaskFiles(
        @PathVariable Integer id,
        @RequestPart("files") MultipartFile[] files
    );

    /**
     * 모델 벤치마크 태스크 파일 목록 조회
     */
    @GetMapping("/api/v1/model-benchmarks/{id}/task-files")
    ModelBenchmarkTaskFilesListResponse getModelBenchmarkTaskFiles(@PathVariable Integer id);

    /**
     * 모델 벤치마크 태스크 파일 삭제
     */
    @DeleteMapping("/api/v1/model-benchmarks/{id}/task-files")
    void deleteModelBenchmarkTaskFiles(
        @PathVariable Integer id,
        @RequestBody ModelBenchmarkTaskFilesDeleteRequest request
    );
}
