package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * SKTAX Agent Query Body DTO
 * 
 * <p>Agent Graph 실행 시 입력되는 쿼리 바디 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "쿼리 바디")
public class QueryBody {

    /**
     * 메시지 목록
     */
    @NotEmpty(message = "메시지는 최소 하나 이상 필요합니다")
    @Valid
    @JsonProperty("messages")
    @Schema(description = "메시지 목록")
    private List<QueryBodyMessage> messages;

    /**
     * 추가 키워드 인자
     */
    @JsonProperty("additional_kwargs")
    @Schema(description = "추가 키워드 인자", defaultValue = "{}")
    @Builder.Default
    private Map<String, Object> additionalKwargs = Map.of();
}
