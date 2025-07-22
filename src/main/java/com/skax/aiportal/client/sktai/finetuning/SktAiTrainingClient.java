package com.skax.aiportal.client.sktai.finetuning;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainingUpdateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sktAiTrainingClient", url = "${sktai.base-url}", configuration = SktAiClientConfig.class)
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
