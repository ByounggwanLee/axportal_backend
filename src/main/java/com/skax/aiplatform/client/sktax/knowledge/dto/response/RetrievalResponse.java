package com.skax.aiplatform.client.sktax.knowledge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.knowledge.dto.RetrievalResultModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 검색 결과 응답 DTO
 * 
 * <p>문서 검색 결과를 담는 응답 정보입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetrievalResponse {

    /**
     * 타임스탬프
     */
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 상세 정보
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * 추적 ID
     */
    @JsonProperty("traceId")
    private String traceId;

    /**
     * 검색 결과 리스트
     */
    @JsonProperty("data")
    private List<RetrievalResultModel> data;
}
