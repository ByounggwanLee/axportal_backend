package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 검색 결과 모델 DTO
 * 
 * <p>검색된 문서의 개별 결과 정보를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetrievalResultModel {

    /**
     * 검색된 본문 내용
     */
    @JsonProperty("content")
    private String content;

    /**
     * 문서 메타데이터
     */
    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    /**
     * 검색 점수
     */
    @JsonProperty("score")
    private Double score;
}
