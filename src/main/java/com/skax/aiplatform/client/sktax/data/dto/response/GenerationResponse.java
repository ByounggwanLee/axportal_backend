package com.skax.aiplatform.client.sktax.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Generation 응답 DTO
 * 
 * <p>데이터 생성 목록을 담는 응답 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationResponse {

    /**
     * 생성 목록 (기본값: [])
     */
    @JsonProperty("data")
    @Builder.Default
    private List<GenerationDetail> data = List.of();
}
