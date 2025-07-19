package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 생성 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedClientReadResponse {

    /**
     * 프로젝트 정보
     */
    private ProjectPayload project;

    /**
     * 생성된 네임스페이스 정보
     */
    private CreatedNamespaceInfo namespace;

    /**
     * 생성된 네임스페이스 정보 DTO
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatedNamespaceInfo {
        
        private String id;
        private String privateVolumeName;
        private Double cpuQuota;
        private Double memQuota;
        private Double gpuQuota;
        private String name;
        private String description;
        private String creator;
        private String modifier;
        private String createdAt;
        private String modifiedAt;
    }
}
