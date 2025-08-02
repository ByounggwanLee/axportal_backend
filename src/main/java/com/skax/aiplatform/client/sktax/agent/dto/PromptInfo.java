package com.skax.aiplatform.client.sktax.agent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SKTAX Agent Prompt 정보 DTO
 * 
 * <p>Prompt의 기본 정보를 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Prompt 정보")
public class PromptInfo {

    /**
     * Prompt UUID
     */
    @Schema(description = "Prompt UUID", example = "83c84984-2970-49b5-a333-705cb769f35a")
    @JsonProperty("uuid")
    private String uuid;

    /**
     * Prompt 이름
     */
    @Schema(description = "Prompt 이름", example = "Insurance Consultation Prompt updated")
    @JsonProperty("name")
    private String name;

    /**
     * Prompt 타입
     */
    @Schema(description = "Prompt 타입", example = "0")
    @JsonProperty("ptype")
    private Integer ptype;

    /**
     * 릴리즈 버전
     */
    @Schema(description = "Prompt release version", example = "2")
    @JsonProperty("release_version")
    private Integer releaseVersion;

    /**
     * 최신 버전
     */
    @Schema(description = "Prompt latest version", example = "3")
    @JsonProperty("latest_version")
    private Integer latestVersion;

    /**
     * 생성일시
     */
    @Schema(description = "Date of creation", example = "2024-09-15T15:32:37.616Z")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 태그 목록
     */
    @Schema(description = "태그 목록", example = "[\"chatbot\", \"humor\"]")
    @JsonProperty("tags")
    private List<String> tags;
}
