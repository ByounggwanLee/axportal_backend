package com.skax.aiplatform.client.sktax.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.model.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 모델 버전 목록 조회 응답 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelVersionsReadResponse {

    /**
     * 모델 버전 목록
     */
    @JsonProperty("data")
    @NotNull(message = "데이터는 필수입니다")
    private List<ModelVersionReadResponse> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    @NotNull(message = "페이로드는 필수입니다")
    private Payload payload;
}
