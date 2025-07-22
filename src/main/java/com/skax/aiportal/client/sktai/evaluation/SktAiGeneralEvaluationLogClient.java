package com.skax.aiportal.client.sktai.evaluation;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.evaluation.dto.request.EvaluationLogUpdateStatusRequest;
import com.skax.aiportal.client.sktai.evaluation.dto.response.EvaluationResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationLogResponse;
import com.skax.aiportal.client.sktai.evaluation.dto.response.GeneralEvaluationLogWithModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiGeneralEvaluationLogClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
public interface SktAiGeneralEvaluationLogClient {

    @GetMapping("/api/v1/evaluation-logs")
    EvaluationResponse<List<GeneralEvaluationLogWithModelResponse>> getEvaluationLogs(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                                      @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                                                      @RequestParam(value = "sort", required = false) String sort,
                                                                                      @RequestParam(value = "filter", required = false) String filter,
                                                                                      @RequestParam(value = "search", required = false) String search);

    @PutMapping("/api/v1/evaluation-logs/{id}")
    GeneralEvaluationLogResponse updateEvaluationLogStatus(@PathVariable("id") Integer id,
                                                           @RequestBody EvaluationLogUpdateStatusRequest request);
}
