package com.skax.aiportal.client.sktai.agent.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Agent App 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUpdateRequest {

    /**
     * 앱 이름
     */
    private String name;

    /**
     * 앱 설명
     */
    private String description;
}
