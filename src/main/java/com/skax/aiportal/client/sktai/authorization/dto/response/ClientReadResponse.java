package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.skax.aiportal.client.sktai.authorization.dto.ProjectPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 조회 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientReadResponse {

    /**
     * 프로젝트 정보
     */
    private ProjectPayload project;

    /**
     * 네임스페이스 정보
     */
    private NamespaceInfo namespace;

    /**
     * 네임스페이스 정보 DTO
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NamespaceInfo {
        
        private String id;
        private Double cpuQuota;
        private Double memQuota;
        private Double gpuQuota;
        private Double cpuUsed;
        private Double memUsed;
        private Double gpuUsed;
        private String privateVolumeName;
        private Double cpuUsable;
        private Double memUsable;
        private Double gpuUsable;
        private String name;
        private String description;
        private String creator;
        private String modifier;
        private String createdAt;
        private String modifiedAt;
    }
}
