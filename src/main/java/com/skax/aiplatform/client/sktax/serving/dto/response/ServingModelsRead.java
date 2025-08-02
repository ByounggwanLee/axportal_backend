package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Serving Model 목록 조회 응답 DTO
 * 서빙 모델 목록 조회 결과를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServingModelsRead {

    /**
     * 서빙 모델 목록
     */
    @JsonProperty("data")
    private List<ServingModelView> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private ServingModelViewPayload payload;
}
