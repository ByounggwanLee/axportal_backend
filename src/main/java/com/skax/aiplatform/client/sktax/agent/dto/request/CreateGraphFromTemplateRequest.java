package com.skax.aiplatform.client.sktax.agent.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 그래프 템플릿으로부터 Agent Graph 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "그래프 템플릿으로부터 Agent Graph 생성 요청")
public class CreateGraphFromTemplateRequest {

    @NotBlank(message = "템플릿 ID는 필수입니다")
    @JsonProperty("template_id")
    @Schema(description = "템플릿 ID", example = "0fd29a8e-7c25-4099-b35d-01c84e28a66d")
    private String templateId;

    @NotBlank(message = "그래프 이름은 필수입니다")
    @JsonProperty("name")
    @Schema(description = "새 그래프 이름", example = "created_chatbot_template")
    private String name;

    @Builder.Default
    @JsonProperty("description")
    @Schema(description = "그래프 설명", example = "copied from template", defaultValue = "")
    private String description = "";
}
