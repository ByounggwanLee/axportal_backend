package com.skax.aiplatform.client.sktax.evaluation;

import com.skax.aiplatform.client.sktax.evaluation.dto.request.EvaluationTaskCreateRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.request.TaskFailedRequest;
import com.skax.aiplatform.client.sktax.evaluation.dto.response.EvaluationTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * SKT Ax Evaluation Tasks API Client
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-evaluation-tasks",
    url = "${client.sktax.evaluation.url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiplatform.client.sktax.config.SktAxFeignConfig.class
)
public interface SktAxEvaluationTasksClient {

    /**
     * 평가 태스크 생성 및 시작
     */
    @PostMapping("/api/v1/evaluation-tasks")
    EvaluationTaskResponse createEvaluationTask(@RequestBody EvaluationTaskCreateRequest request);

    /**
     * 태스크 실패 상태 업데이트
     */
    @PutMapping("/api/v1/evaluation-tasks/{refId}/status")
    void updateTaskStatus(
        @PathVariable String refId,
        @RequestBody TaskFailedRequest request
    );
}
