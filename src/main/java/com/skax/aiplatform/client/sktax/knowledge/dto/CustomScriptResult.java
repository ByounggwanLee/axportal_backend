package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Custom Script 결과 DTO
 * OpenAPI 스키마: CustomScriptResult
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomScriptResult {

    @JsonProperty("document_list")
    private List<Object> documentList;

    @JsonProperty("document_count")
    private Integer documentCount;

    @JsonProperty("result_message")
    private String resultMessage;
}
