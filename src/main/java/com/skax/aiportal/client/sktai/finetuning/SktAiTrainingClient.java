package com.skax.aiportal.client.sktai.finetuning;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingUpdateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingResponse;

@FeignClient(name = "sktAiTrainingClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiTrainingClient {

    @PostMapping("/api/v1/finetuning/trainings")
    TrainingResponse createTraining(@RequestBody TrainingCreateRequest request);

    @GetMapping("/api/v1/finetuning/trainings")
    FinetuningResponse<List<TrainingResponse>> getTrainings(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            @RequestParam(value = "filter", required = false) String filter,
                                                            @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/finetuning/trainings/{training_id}")
    TrainingResponse getTraining(@PathVariable("training_id") String trainingId);

    @PutMapping("/api/v1/finetuning/trainings/{training_id}")
    TrainingResponse updateTraining(@PathVariable("training_id") String trainingId,
                                    @RequestBody TrainingUpdateRequest request);

    @DeleteMapping("/api/v1/finetuning/trainings/{training_id}")
    void deleteTraining(@PathVariable("training_id") String trainingId);

    @PostMapping("/api/v1/finetuning/trainings/hard-delete")
    void hardDeleteTrainings();
}
