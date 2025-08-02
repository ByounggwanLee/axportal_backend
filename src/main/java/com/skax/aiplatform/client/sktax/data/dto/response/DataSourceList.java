package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.DataSourceDetailWithCreator;
import com.skax.aiplatform.client.sktax.data.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DataSource 목록 응답 DTO
 * 
 * <p>데이터소스 목록을 담는 응답 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceList {

    /**
     * 데이터소스 목록
     */
    @JsonProperty("data")
    private List<DataSourceDetailWithCreator> data;

    /**
     * 페이징 정보 (필수)
     */
    @JsonProperty("payload")
    private Payload payload;
}
