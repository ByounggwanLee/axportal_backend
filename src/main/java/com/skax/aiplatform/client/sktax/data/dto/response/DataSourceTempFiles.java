package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.DataSourceTempFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DataSource 임시 파일 목록 응답 DTO
 * 
 * <p>데이터소스의 임시 파일 목록을 담는 응답 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceTempFiles {

    /**
     * 임시 파일 목록 (필수)
     */
    @JsonProperty("data")
    private List<DataSourceTempFile> data;
}
