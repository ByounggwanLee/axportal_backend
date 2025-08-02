package com.skax.aiplatform.client.sktax.agent.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKTAX Agent Graph 응답 DTO
 * 
 * <p>Agent Graph 실행 결과 응답 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Agent Graph 실행 응답")
public class GraphResponse {

    /**
     * Graph 실행 결과
     */
    @Schema(description = "Agent 실행 결과")
    @JsonProperty("output")
    private GraphResponseOutput output;

    /**
     * 이전 버전 호환용 데이터 필드
     */
    @Schema(description = "Agent 실행 결과, 이전 버전 API 사용자를 위해 남겨둔 필드. It will be deprecated")
    @JsonProperty("data")
    private GraphResponseOutput data;

    /**
     * Graph 응답 출력 내부 클래스
     */
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Graph 응답 출력")
    public static class GraphResponseOutput {

        /**
         * Graph 실행 중 메시지 누적 필드
         */
        @Schema(description = "Field That is used to accumulate messages during graph execution")
        @JsonProperty("messages")
        @Builder.Default
        private List<Object> messages = List.of();

        /**
         * 최종 결과
         */
        @Schema(description = "Final Result. OutputNode will set this Field")
        @JsonProperty("content")
        private Object content;

        /**
         * 추가 키워드 정보
         */
        @Schema(description = "그래프 실행시에 추가적으로 저장하는 용도")
        @JsonProperty("additional_kwargs")
        @Builder.Default
        private Object additionalKwargs = new Object();
    }
}
