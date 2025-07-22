package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.RagEvaluationTaskCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sktAiRagEvaluationTaskClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
public interface SktAiRagEvaluationTaskClient {

    @PostMapping("/api/v1/rag-evaluation-tasks")
    RagEvaluationTaskResponse createRagEvaluationTask(@RequestBody RagEvaluationTaskCreateRequest request);
}
