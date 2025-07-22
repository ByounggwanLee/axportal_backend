package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.ModelBenchmarkTaskCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.ModelBenchmarkTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SKT AI Evaluation API - 모델 벤치마크 태스크 관리 Feign 클라이언트
 * 모델 벤치마크 태스크 생성 및 실행
 */
@FeignClient(
    name = "skt-ai-model-benchmark-task",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelBenchmarkTaskClient {
    
    /**
     * 모델 벤치마크 태스크 저장 및 시작
     */
    @PostMapping("/api/v1/model-benchmark-tasks")
    ModelBenchmarkTaskResponse createAndStartTask(@RequestBody ModelBenchmarkTaskCreateRequest request);
}
