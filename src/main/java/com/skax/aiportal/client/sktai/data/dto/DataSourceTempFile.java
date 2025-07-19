package com.skax.aiportal.client.sktai.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 임시 파일 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTempFile {

    @NotBlank(message = "파일 이름은 필수입니다")
    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("temp_file_path")
    @Builder.Default
    private String tempFilePath = "";

    @JsonProperty("file_metadata")
    private Object fileMetadata;

    @JsonProperty("knowledge_config")
    private Object knowledgeConfig;
}