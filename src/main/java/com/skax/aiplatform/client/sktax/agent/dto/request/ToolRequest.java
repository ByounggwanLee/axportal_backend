package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * SKTAX Agent Tool 생성/수정 요청 DTO
 * 
 * <p>Agent에서 사용할 Tool의 생성 및 수정 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Tool 생성/수정 요청")
public class ToolRequest {

    /**
     * Tool 이름 (중복 불가)
     */
    @Schema(description = "Tool의 이름으로 중복된 이름은 설정 할 수 없습니다. Tool의 이름과 Tool에 사용된 함수 명은 같아야 합니다", 
            example = "get_wiki", required = true)
    @JsonProperty("name")
    @NotBlank(message = "Tool 이름은 필수입니다")
    private String name;

    /**
     * Tool 설명
     */
    @Schema(description = "Tool에 대한 설명으로, StructuredTool의 Description으로 자동 설정됩니다", 
            example = "Search on wiki", required = true)
    @JsonProperty("description")
    @NotBlank(message = "Tool 설명은 필수입니다")
    private String description;

    /**
     * Tool 타입 (custom_code, custom_api)
     */
    @Schema(description = "Tool 종류를 설정합니다. Api 호출을 위한 custom_api type과 직접 code를 작성하여 사용하는 custom_code type이 있습니다", 
            example = "custom_api", required = true, allowableValues = {"custom_code", "custom_api"})
    @JsonProperty("tool_type")
    @NotBlank(message = "Tool 타입은 필수입니다")
    private String toolType;

    /**
     * Tool 실행 코드
     */
    @Schema(description = "tool을 실행하는되 사용되는 code입니다. custom_code type의 경우 직접 작성하며, custom_api type의 경우 필수값만 입력하면 자동으로 생성됩니다", 
            example = "code")
    @JsonProperty("code")
    private String code;

    /**
     * 서버 URL (custom_api 타입의 경우)
     */
    @Schema(description = "custom_api type의 tool에서 호출에 사용되는 server 주소입니다", 
            example = "https://ko.wikipedia.org/w/api.php")
    @JsonProperty("server_url")
    private String serverUrl;

    /**
     * HTTP 메소드 (custom_api 타입의 경우)
     */
    @Schema(description = "custom_api type의 tool에서 호출에 사용되는 method 입니다. 현재는 post와 get을 지원합니다", 
            example = "GET", allowableValues = {"GET", "POST"})
    @JsonProperty("method")
    private String method;

    /**
     * API 파라미터 (JSON 형식)
     */
    @Schema(description = "custom_api type의 tool에서 호출에 사용되는 parameter입니다. header, static_param, dynamic_param의 세가지 영역으로 이루어져 있습니다", 
            example = "{\"dynamic_params\":{\"query\":\"str\"},\"header\":{\"auth_key\":\"364c33e8...\"},\"static_params\":{\"action\":\"query\",\"format\":\"json\",\"list\":\"search\"}}")
    @JsonProperty("api_param")
    private String apiParam;
}
