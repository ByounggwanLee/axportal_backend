package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.Dataset;
import com.skax.aiplatform.client.sktax.data.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 데이터셋 목록 응답 DTO
 * 
 * <p>데이터셋 목록 조회 API의 응답 모델입니다.
 * 데이터셋 배열과 페이징 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSetList {

    /**
     * 데이터셋 목록
     * 조회된 데이터셋들의 배열입니다.
     */
    @JsonProperty("data")
    private List<Dataset> data;

    /**
     * 페이징 정보
     * 페이지네이션 관련 메타데이터입니다.
     */
    @JsonProperty("payload")
    private Payload payload;
}
