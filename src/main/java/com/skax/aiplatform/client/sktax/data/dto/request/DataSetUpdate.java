package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DataSet 업데이트 요청 DTO
 * 
 * <p>데이터셋의 설명과 프로젝트 ID를 업데이트하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSetUpdate {

    /**
     * 데이터셋 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;
}
