package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.agent.dto.PromptMessage;
import com.skax.aiplatform.client.sktax.agent.dto.PromptVariable;
import com.skax.aiplatform.client.sktax.agent.dto.PromptTag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;
import java.util.List;

/**
 * SKTAX Agent Prompt 생성 요청 DTO
 * 
 * <p>Agent에서 사용할 Prompt 생성 요청 데이터를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 생성 요청")
public class PromptCreateRequest {

    /**
     * Prompt 이름
     */
    @Schema(description = "Prompt name", example = "Insurance Consultation Prompt", required = true)
    @JsonProperty("name")
    @NotBlank(message = "Prompt 이름은 필수입니다")
    private String name;

    /**
     * 프로젝트 ID
     */
    @Schema(description = "Project ID", example = "d89a7451-3d40-4bab-b4ee-6aecd55b4f32")
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 릴리즈 여부
     */
    @Schema(description = "Flag of release", example = "false")
    @JsonProperty("release")
    @Builder.Default
    private Boolean release = false;

    /**
     * Prompt 메시지 목록
     */
    @Schema(description = "Prompt messages", required = true)
    @JsonProperty("messages")
    @Valid
    private List<PromptMessage> messages;

    /**
     * Prompt 변수 목록
     */
    @Schema(description = "Prompt variables", required = true)
    @JsonProperty("variables")
    @Valid
    private List<PromptVariable> variables;

    /**
     * Prompt 태그 목록
     */
    @Schema(description = "Prompt tags", required = true)
    @JsonProperty("tags")
    @Valid
    private List<PromptTag> tags;
}
