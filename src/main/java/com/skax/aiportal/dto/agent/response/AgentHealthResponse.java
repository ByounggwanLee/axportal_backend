package com.skax.aiportal.dto.agent.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Health 응답 DTO
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentHealthResponse {

    private String status;
    private String message;
    private Map<String, Object> details;
    private Long timestamp;
    private String version;
    private Map<String, String> components;
}
