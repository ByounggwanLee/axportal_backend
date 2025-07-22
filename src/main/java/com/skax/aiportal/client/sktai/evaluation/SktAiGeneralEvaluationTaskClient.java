package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.EvaluationTaskCreateRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.request.TaskFailedRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationTaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "sktAiGeneralEvaluationTaskClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiGeneralEvaluationTaskClient {

    @PostMapping("/api/v1/evaluation-tasks")
    GeneralEvaluationTaskResponse createEvaluationTask(@RequestBody EvaluationTaskCreateRequest request);

    @PutMapping("/api/v1/evaluation-tasks/{ref_id}/status")
    Object updateEvaluationTaskStatus(@PathVariable("ref_id") String refId,
                                      @RequestBody TaskFailedRequest request);
}
