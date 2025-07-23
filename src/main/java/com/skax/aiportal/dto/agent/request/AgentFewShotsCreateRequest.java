package com.skax.aiportal.dto.agent.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent FewShots 생성 요청 DTO
 * 
 * <p>Few-shot 예시 데이터 생성을 위한 요청 데이터를 담습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentFewShotsCreateRequest {

    /**
     * 프로젝트 ID
     */
    @NotBlank(message = "프로젝트 ID는 필수입니다")
    private String projectId;

    /**
     * FewShots 이름
     */
    @NotBlank(message = "FewShots 이름은 필수입니다")
    private String name;

    /**
     * FewShots 설명
     */
    private String description;

    /**
     * 태그 목록 (쉼표로 구분)
     */
    private String tags;

    /**
     * 버전 설명
     */
    private String versionDescription;

    /**
     * 예시 데이터 콘텐츠 (JSON 형태)
     */
    private String content;

    /**
     * 공개 여부
     */
    @Builder.Default
    private Boolean isPublic = false;

    /**
     * 활성화 여부
     */
    @Builder.Default
    private Boolean isActive = true;
}
