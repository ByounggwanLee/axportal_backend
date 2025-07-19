package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 데이터셋 업데이트 요청 DTO
 * 
 * <p>SKT AI 플랫폼에서 기존 데이터셋을 수정할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetUpdateRequest {

    /**
     * 데이터셋 설명
     */
    @NotBlank(message = "설명은 필수입니다")
    private String description;

    /**
     * 프로젝트 ID
     */
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    @JsonProperty("project_id")
    private String projectId;
}
