package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * HTTP 유효성 검사 오류 DTO
 * 
 * <p>HTTP 요청에서 발생한 유효성 검사 오류 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HTTPValidationError {

    /**
     * 오류 상세 정보
     */
    @JsonProperty("detail")
    private List<ValidationError> detail;
}
