package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Repo Task DTO
 * OpenAPI 스키마: RepoTask
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepoTask {

    @JsonProperty("id")
    private String id;

    @JsonProperty("repo_id")
    private String repoId;

    @JsonProperty("target_step")
    @Builder.Default
    private KnowledgeAction targetStep = KnowledgeAction.EMBEDDING_AND_INDEXING;

    @JsonProperty("workflow_id")
    private String workflowId;

    @JsonProperty("task_status")
    @Builder.Default
    private RepoTaskStatus taskStatus = RepoTaskStatus.INIT;

    @JsonProperty("task_type")
    @Builder.Default
    private RepoTaskType taskType = RepoTaskType.REPO_INDEXING;

    @JsonProperty("task_target_id")
    private String taskTargetId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("creator")
    private String creator;

    @JsonProperty("error_msg")
    private String errorMsg;

    @JsonProperty("project_name")
    private String projectName;
}
