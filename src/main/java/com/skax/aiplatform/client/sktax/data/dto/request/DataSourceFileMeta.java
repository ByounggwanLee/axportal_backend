package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataSource 파일 메타데이터 요청 DTO
 * 
 * <p>데이터소스 파일의 메타데이터를 업데이트하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceFileMeta {

    /**
     * 파일 메타데이터
     */
    @JsonProperty("file_metadata")
    private Object fileMetadata;
}
