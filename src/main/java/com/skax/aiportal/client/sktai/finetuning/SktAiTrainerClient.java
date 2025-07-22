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

import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainerCreateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.request.TrainerUpdateRequest;
import com.skax.aiportal.client.sktai.finetuning.dto.response.FinetuningResponse;
import com.skax.aiportal.client.sktai.finetuning.dto.response.TrainerResponse;

@FeignClient(name = "sktAiTrainerClient", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        com.skax.aiportal.client.sktai.config.SktAiClientConfig.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor.class,
        com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor.class
})
public interface SktAiTrainerClient {

    @PostMapping("/api/v1/finetuning/trainers")
    TrainerResponse createTrainer(@RequestBody TrainerCreateRequest request);

    @GetMapping("/api/v1/finetuning/trainers")
    FinetuningResponse<List<TrainerResponse>> getTrainers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam(value = "sort", required = false) String sort,
                                                          @RequestParam(value = "filter", required = false) String filter,
                                                          @RequestParam(value = "search", required = false) String search);

    @GetMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerResponse getTrainer(@PathVariable("trainer_id") String trainerId);

    @PutMapping("/api/v1/finetuning/trainers/{trainer_id}")
    TrainerResponse updateTrainer(@PathVariable("trainer_id") String trainerId,
                                  @RequestBody TrainerUpdateRequest request);

    @DeleteMapping("/api/v1/finetuning/trainers/{trainer_id}")
    void deleteTrainer(@PathVariable("trainer_id") String trainerId);

    @PostMapping("/api/v1/finetuning/trainers/hard-delete")
    void hardDeleteTrainers();
}
