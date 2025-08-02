package com.skax.aiplatform.client.sktax.finetuning;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.finetuning.dto.TrainingMetricTypeEnum;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainingCreate;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainingMetricCreate;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainingTaskCallback;
import com.skax.aiplatform.client.sktax.finetuning.dto.request.TrainingUpdate;
import com.skax.aiplatform.client.sktax.finetuning.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * SKT AX Fine-tuning API - Training Feign Client
 * 파인튜닝 훈련 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-finetuning-training-client",
    url = "${skt-ax.finetuning.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface TrainingClient {

    /**
     * Training 등록
     */
    @PostMapping("/api/v1/finetuning/trainings")
    TrainingRead registerTraining(@RequestBody TrainingCreate request);

    /**
     * Training 목록 조회
     */
    @GetMapping("/api/v1/finetuning/trainings")
    TrainingsRead readTrainings(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Training 상세 조회
     */
    @GetMapping("/api/v1/finetuning/trainings/{training_id}")
    TrainingRead readTraining(@PathVariable("training_id") UUID trainingId);

    /**
     * Training 수정
     */
    @PutMapping("/api/v1/finetuning/trainings/{training_id}")
    TrainingRead editTraining(
        @PathVariable("training_id") UUID trainingId,
        @RequestBody TrainingUpdate request
    );

    /**
     * Training 삭제
     */
    @DeleteMapping("/api/v1/finetuning/trainings/{training_id}")
    void removeTraining(@PathVariable("training_id") UUID trainingId);

    /**
     * Training 상태 조회
     */
    @GetMapping("/api/v1/finetuning/trainings/{training_id}/status")
    TrainingStatusRead readTrainingStatus(@PathVariable("training_id") UUID trainingId);

    /**
     * Training 상태 업데이트 (콜백용)
     */
    @PutMapping("/api/v1/finetuning/trainings/{ref_id}/status")
    Object editTrainingStatus(
        @PathVariable("ref_id") UUID refId,
        @RequestBody TrainingTaskCallback request
    );

    /**
     * Training 이벤트 조회
     */
    @GetMapping("/api/v1/finetuning/trainings/{training_id}/events")
    TrainingEventsRead readTrainingEvents(
        @PathVariable("training_id") UUID trainingId,
        @RequestParam(value = "after", required = false) String after,
        @RequestParam(value = "limit", defaultValue = "100") Integer limit
    );

    /**
     * Training 메트릭 조회
     */
    @GetMapping("/api/v1/finetuning/trainings/{training_id}/metrics")
    TrainingMetricsRead readTrainingMetrics(
        @PathVariable("training_id") UUID trainingId,
        @RequestParam(value = "type", defaultValue = "train") TrainingMetricTypeEnum type,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size
    );

    /**
     * Training 메트릭 등록
     */
    @PostMapping("/api/v1/finetuning/trainings/{training_id}/metrics")
    void registerTrainingMetrics(
        @PathVariable("training_id") UUID trainingId,
        @RequestBody List<TrainingMetricCreate> inputMetrics
    );

    /**
     * Training 훅 설정
     */
    @PostMapping("/api/v1/finetuning/trainings/hook")
    Object hookTrainings(
        @RequestParam(value = "cycle", defaultValue = "5") Integer cycle,
        @RequestParam(value = "timeout", defaultValue = "1800") Integer timeout,
        @RequestBody List<UUID> ids
    );

    /**
     * Training 하드 삭제
     */
    @PostMapping("/api/v1/finetuning/trainings/hard-delete")
    Object hardRemoveTraining();
}
