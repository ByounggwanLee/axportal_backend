package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 모델 벤치마크 태스크 파일 삭제 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelBenchmarkTaskFilesDeleteRequest {
    
    @JsonProperty("files")
    private List<String> files;
}
