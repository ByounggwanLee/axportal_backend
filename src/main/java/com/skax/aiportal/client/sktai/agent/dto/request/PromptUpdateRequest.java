package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptCreateRequest.PromptMessage;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptCreateRequest.PromptTag;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptCreateRequest.PromptVariable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Prompt 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptUpdateRequest {

    /**
     * 새로운 Prompt 이름
     */
    @JsonProperty("new_name")
    private String newName;

    /**
     * 릴리즈 플래그
     */
    @Builder.Default
    private Boolean release = false;

    /**
     * Prompt 메시지 목록
     */
    private List<PromptMessage> messages;

    /**
     * Prompt 변수 목록
     */
    private List<PromptVariable> variables;

    /**
     * Prompt 태그 목록
     */
    private List<PromptTag> tags;
}
