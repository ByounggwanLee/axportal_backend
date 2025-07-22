package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkTaskFilesDeleteRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * SKT AI Evaluation API - 모델 벤치마크 관리 Feign 클라이언트
 * 모델 벤치마크 생성, 조회 및 태스크 파일 관리
 */
@FeignClient(
    name = "skt-ai-model-benchmark",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelBenchmarkClient {
    
    /**
     * 모델 벤치마크 생성
     */
    @PostMapping("/api/v1/model-benchmarks")
    ModelBenchmarkReadResponse createModelBenchmark(@RequestBody ModelBenchmarkCreateRequest request);
    
    /**
     * 모델 벤치마크 목록 조회
     */
    @GetMapping("/api/v1/model-benchmarks")
    EvaluationResponse<List<ModelBenchmarkReadResponse>> getModelBenchmarks(
        @RequestParam(name = "page", defaultValue = "1") Integer page,
        @RequestParam(name = "size", defaultValue = "20") Integer size,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "filter", required = false) String filter,
        @RequestParam(name = "search", required = false) String search
    );
    
    /**
     * 모델 벤치마크 상세 조회
     */
    @GetMapping("/api/v1/model-benchmarks/{id}")
    ModelBenchmarkReadResponse getModelBenchmark(@PathVariable("id") Integer id);
    
    /**
     * 모델 벤치마크 태스크 파일 업로드
     */
    @PostMapping(value = "/api/v1/model-benchmarks/{id}/task-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object uploadTaskFiles(
        @PathVariable("id") Integer id,
        @RequestPart("files") List<MultipartFile> files
    );
    
    /**
     * 모델 벤치마크 태스크 파일 목록 조회
     */
    @GetMapping("/api/v1/model-benchmarks/{id}/task-files")
    ModelBenchmarkTaskFilesResponse getTaskFiles(@PathVariable("id") Integer id);
    
    /**
     * 모델 벤치마크 태스크 파일 삭제
     */
    @DeleteMapping("/api/v1/model-benchmarks/{id}/task-files")
    Object deleteTaskFiles(
        @PathVariable("id") Integer id,
        @RequestBody ModelBenchmarkTaskFilesDeleteRequest request
    );
}
