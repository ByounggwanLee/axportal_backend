package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



/**
 * SKTAX Agent Test Prompt Variables 요청 DTO
 * 
 * <p>Prompt 변수 테스트 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 변수 테스트 요청")
public class TestPromptVariablesRequest {

    /**
     * 테스트용 변수 (동적으로 변할 수 있음)
     */
    @Schema(description = "테스트용 변수들", example = "{\"name\": \"This is a user query.\", \"user_input\": \"This is a user query.\"}")
    @JsonProperty
    private Object variables;
}
