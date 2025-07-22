package com.skax.aiportal.client.sktai.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerCreateRequest {

    @JsonProperty("registry_url")
    private String registryUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("default_params")
    private String defaultParams;

    @JsonProperty("id")
    private String id;

    @JsonProperty("policy")
    private Object policy;
}
