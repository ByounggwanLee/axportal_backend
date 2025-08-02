package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Agent Serving 목록 조회 응답 DTO
 * 에이전트 서빙 목록 조회 결과를 반환하는 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentServingsRead {

    /**
     * 에이전트 서빙 목록
     */
    @JsonProperty("data")
    private List<AgentServingInfo> data;

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("payload")
    private AgentServingInfoPayload payload;
}
