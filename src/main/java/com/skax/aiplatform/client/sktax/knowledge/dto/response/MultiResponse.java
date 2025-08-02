package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 다중 응답 DTO
 * 
 * <p>목록 조회 시 사용되는 응답 형식입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultiResponse {

    /**
     * 데이터 목록
     */
    @JsonProperty("data")
    @Builder.Default
    private List<Object> data = List.of();

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private Payload payload;
}
