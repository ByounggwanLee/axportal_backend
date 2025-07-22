package com.skax.aiportal.client.sktai.finetuning;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingMetricCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingMetricResponse;

@FeignClient(name = "sktAiTrainingMetricClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiTrainingMetricClient {

    @GetMapping("/api/v1/finetuning/trainings/{training_id}/metrics")
    FinetuningResponse<List<TrainingMetricResponse>> getTrainingMetrics(@PathVariable("training_id") String trainingId,
                                                                        @RequestParam(value = "type", defaultValue = "train") String type,
                                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                        @RequestParam(value = "size", defaultValue = "10") Integer size);

    @PostMapping("/api/v1/finetuning/trainings/{training_id}/metrics")
    void createTrainingMetrics(@PathVariable("training_id") String trainingId,
                               @RequestBody List<TrainingMetricCreateRequest> metrics);
}
