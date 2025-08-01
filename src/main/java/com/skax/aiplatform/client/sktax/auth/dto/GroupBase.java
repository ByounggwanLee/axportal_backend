package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 그룹 기본 정보 DTO
 * 
 * <p>OpenAPI 스키마명: GroupBase</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "그룹 기본 정보")
public class GroupBase {

    @JsonProperty("group_id")
    @Schema(description = "그룹 ID")
    private Long groupId;

    @JsonProperty("group_name")
    @Schema(description = "그룹명")
    private String groupName;

    @JsonProperty("group_description")
    @Schema(description = "그룹 설명")
    private String groupDescription;

    @JsonProperty("is_active")
    @Schema(description = "활성 상태")
    private Boolean isActive;

    @JsonProperty("created_at")
    @Schema(description = "생성 일시")
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "수정 일시")
    private String updatedAt;
}
