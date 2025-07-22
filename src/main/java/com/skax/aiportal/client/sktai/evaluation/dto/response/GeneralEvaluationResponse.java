package com.skax.aiportal.client.sktai.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralEvaluationResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tasks")
    private String tasks;

    @JsonProperty("dataset_id")
    private String datasetId;

    @JsonProperty("is_custom")
    private Boolean isCustom;

    @JsonProperty("type_text")
    private String typeText;
}
