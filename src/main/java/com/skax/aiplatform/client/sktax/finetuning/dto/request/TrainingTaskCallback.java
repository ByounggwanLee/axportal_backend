package com.skax.aiplatform.client.sktax.finetuning.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Training Task Callback 요청 DTO
 * Task Manager로부터의 콜백을 위한 요청 데이터입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingTaskCallback {

    /**
     * 상태
     */
    @JsonProperty("status")
    @NotBlank(message = "상태는 필수입니다")
    private String status;

    /**
     * 워크플로우 ID
     */
    @JsonProperty("workflow_id")
    @NotBlank(message = "워크플로우 ID는 필수입니다")
    private String workflowId;

    /**
     * 메시지
     */
    @JsonProperty("message")
    @NotBlank(message = "메시지는 필수입니다")
    private String message;

    /**
     * 타입
     */
    @JsonProperty("type")
    @NotBlank(message = "타입은 필수입니다")
    private String type;

    /**
     * 참조 ID
     */
    @JsonProperty("ref_id")
    @NotBlank(message = "참조 ID는 필수입니다")
    private String refId;
}
