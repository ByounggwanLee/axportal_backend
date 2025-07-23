package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent Tool 수정 요청 DTO
 * 
 * <p>Agent Tool 수정을 위한 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentToolUpdateRequest {

    /**
     * Tool 이름
     */
    @NotBlank(message = "Tool 이름은 필수입니다")
    @Size(max = 100, message = "Tool 이름은 100자를 초과할 수 없습니다")
    private String name;

    /**
     * Tool 설명
     */
    @Size(max = 500, message = "Tool 설명은 500자를 초과할 수 없습니다")
    private String description;

    /**
     * Tool 타입
     */
    @Size(max = 50, message = "Tool 타입은 50자를 초과할 수 없습니다")
    private String toolType;

    /**
     * Tool 구성 정보 (JSON 형태)
     */
    private String configuration;

    /**
     * Tool 스키마 정보 (JSON 형태)
     */
    private String schema;

    /**
     * 활성화 여부
     */
    private Boolean enabled;

    /**
     * 공개 여부
     */
    private Boolean isPublic;

    /**
     * 태그 목록
     */
    private String[] tags;
}
