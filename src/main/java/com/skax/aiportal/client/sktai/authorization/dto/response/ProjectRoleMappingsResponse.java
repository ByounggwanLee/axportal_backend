package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.skax.aiportal.client.sktai.data.dto.Payload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 프로젝트 역할 매핑 조회 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRoleMappingsResponse {

    /**
     * 역할 목록
     */
    private List<RoleResponse> data;

    /**
     * 페이징 정보
     */
    private Payload payload;
}
