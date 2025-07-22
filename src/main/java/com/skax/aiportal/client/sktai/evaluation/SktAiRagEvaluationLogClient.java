package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.RagEvaluationLogUpdateStatusRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationLogResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.RagEvaluationLogWithModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiRagEvaluationLogClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiRagEvaluationLogClient {

    @GetMapping("/api/v1/rag-evaluation-logs")
    EvaluationResponse<List<RagEvaluationLogWithModelResponse>> getRagEvaluationLogs(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                                     @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                                     @RequestParam(value = "sort", required = false) String sort,
                                                                                     @RequestParam(value = "filter", required = false) String filter,
                                                                                     @RequestParam(value = "search", required = false) String search);

    @PutMapping("/api/v1/rag-evaluation-logs/{id}")
    RagEvaluationLogResponse updateRagEvaluationLogStatus(@PathVariable("id") Integer id,
                                                          @RequestBody RagEvaluationLogUpdateStatusRequest request);
}
