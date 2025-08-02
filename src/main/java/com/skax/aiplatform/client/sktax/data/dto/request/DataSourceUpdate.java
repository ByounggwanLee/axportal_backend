package com.skax.aiplatform.client.sktax.data.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.DataSourceUpdateFile;
import com.skax.aiplatform.client.sktax.data.dto.S3Config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 업데이트 요청 DTO
 * 
 * <p>데이터소스의 정보를 업데이트하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceUpdate {

    /**
     * 데이터소스 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 업데이트한 사용자
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 수정된 파일 목록
     */
    @JsonProperty("modified_files")
    private List<DataSourceUpdateFile> modifiedFiles;

    /**
     * S3 설정
     */
    @JsonProperty("s3_config")
    private S3Config s3Config;
}
