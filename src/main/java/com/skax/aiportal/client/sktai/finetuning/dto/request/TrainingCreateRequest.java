package com.skax.aiportal.client.sktai.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCreateRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("prev_status")
    private String prevStatus;

    @JsonProperty("progress")
    private Map<String, Object> progress;

    @JsonProperty("resource")
    private Map<String, Object> resource;

    @JsonProperty("dataset_ids")
    private List<String> datasetIds;

    @JsonProperty("base_model_id")
    private String baseModelId;

    @JsonProperty("params")
    private String params;

    @JsonProperty("envs")
    private Map<String, Object> envs;

    @JsonProperty("description")
    private String description;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("task_id")
    private String taskId;

    @JsonProperty("trainer_id")
    private String trainerId;

    @JsonProperty("policy")
    private Object policy;
}
