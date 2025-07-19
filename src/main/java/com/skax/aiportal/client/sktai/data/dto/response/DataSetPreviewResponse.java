package com.skax.aiportal.client.sktai.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * 데이터셋 미리보기 응답 DTO
 * 
 * <p>SKT AI 플랫폼의 데이터셋 미리보기 정보를 담는 응답 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataSetPreviewResponse {

    /**
     * 미리보기 데이터
     */
    @JsonProperty("data")
    @Builder.Default
    private List<Object> data = List.of();
}
