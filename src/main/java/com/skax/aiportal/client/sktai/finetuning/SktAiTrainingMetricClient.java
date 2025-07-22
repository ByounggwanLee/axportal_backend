package com.skax.aiportal.client.sktai.finetuning;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingMetricCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingMetricResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiTrainingMetricClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
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
