package com.skax.aiportal.client.sktai.authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 프로젝트 역할 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRole {

    /**
     * 역할명
     */
    private String name;

    /**
     * 설명
     */
    private String description;
}
