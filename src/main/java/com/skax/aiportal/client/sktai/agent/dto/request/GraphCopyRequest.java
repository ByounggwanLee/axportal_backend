package com.skax.aiportal.client.sktai.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Graph 복사 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphCopyRequest {

    /**
     * 새로운 그래프 이름
     */
    @JsonProperty("name")
    private String name;

    /**
     * 새로운 그래프 설명
     */
    @JsonProperty("description")
    private String description;

    /**
     * 그래프 카테고리
     */
    @JsonProperty("category")
    private String category;
}
