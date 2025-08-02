package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 모델 벤치마크 태스크 파일 업로드 요청 Body
 * OpenAPI 명세: Body_post_task_file_api_v1_model_benchmarks__id__task_files_post
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelBenchmarkTaskFilesUploadRequest {

    /**
     * 업로드할 파일들 (binary format)
     * OpenAPI 명세: "files": {"items": {"type": "string", "format": "binary"}, "type": "array"}
     */
    @JsonProperty("files")
    private byte[][] files;
}
