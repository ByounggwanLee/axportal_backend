package com.skax.aiportal.client.sktai.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMetricCreateRequest {

    @JsonProperty("step")
    private Integer step;

    @JsonProperty("loss")
    private Double loss;

    @JsonProperty("custom_metric")
    private Map<String, Object> customMetric;

    @JsonProperty("type")
    private String type;
}
