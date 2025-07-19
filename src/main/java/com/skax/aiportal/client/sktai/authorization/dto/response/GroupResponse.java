package com.skax.aiportal.client.sktai.authorization.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 그룹 정보 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {

    /**
     * 그룹 ID
     */
    private String id;

    /**
     * 그룹명
     */
    private String name;

    /**
     * 그룹 경로
     */
    private String path;
}
