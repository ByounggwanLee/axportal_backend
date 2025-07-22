package com.skax.aiportal.client.sktai.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Tool 생성/수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolRequest {

    /**
     * Tool의 이름으로 중복된 이름은 설정할 수 없습니다.
     */
    private String name;

    /**
     * Tool에 대한 설명
     */
    private String description;

    /**
     * Tool 종류 (custom_api, custom_code)
     */
    @JsonProperty("tool_type")
    private String toolType;

    /**
     * Tool을 실행하는데 사용되는 code
     */
    private String code;

    /**
     * custom_api type의 tool에서 호출에 사용되는 server 주소
     */
    @JsonProperty("server_url")
    private String serverUrl;

    /**
     * custom_api type의 tool에서 호출에 사용되는 method (post, get)
     */
    private String method;

    /**
     * custom_api type의 tool에서 호출에 사용되는 parameter
     */
    @JsonProperty("api_param")
    private String apiParam;
}
