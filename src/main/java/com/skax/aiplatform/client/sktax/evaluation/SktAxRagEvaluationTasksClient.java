package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.RagEvaluationTaskCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.RagEvaluationTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SKT Ax RAG Evaluation Tasks API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-rag-evaluation-tasks",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxRagEvaluationTasksClient {

    /**
     * RAG 평가 태스크 저장 및 시작
     */
    @PostMapping("/api/v1/rag-evaluation-tasks")
    RagEvaluationTaskResponse createRagEvaluationTask(@RequestBody RagEvaluationTaskCreateRequest request);
}
